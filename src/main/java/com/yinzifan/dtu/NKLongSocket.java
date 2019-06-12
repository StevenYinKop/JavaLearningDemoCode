package com.yinzifan.dtu;
/**     
 * 项目名：****************   
 * 包名：dtu.model.NKLongSocket  
 * 文件名：LongSocket.java   
 * 文件描述:(长连接获取DTU数据接口)  
 * 作者 ：huastone E-mail: huastone_he@163.com   
 * 创建时间：2013-3-22-上午11:25:21    
 * 版本信息：@version V1.0.0      
 */   
import java.io.BufferedReader;   
import java.io.ByteArrayOutputStream;   
import java.io.DataInputStream;   
import java.io.IOException;   
import java.io.InputStream;   
import java.io.InputStreamReader;   
import java.io.PrintWriter;   
import java.net.InetAddress;   
import java.net.InetSocketAddress;   
import java.net.Socket;   
import java.net.UnknownHostException;   
   
import org.apache.commons.logging.Log;   
import org.apache.commons.logging.LogFactory;   
   
   
public class NKLongSocket extends Thread{   
    //日志处理接口   
    private Log mylog = LogFactory.getLog(NKLongSocket.class);   
       
    private String ip=null;//连接服务器的IP   
    private Integer port=null;//连接服务器的端口   
    private String operName = ""; //操作人   
    private Integer timeout = 1000*30; //连接超时设置 以毫秒为单位   
       
    private Socket socket=null;//套节字对象   
    private boolean close = false; // 关闭连接标志位，true表示关闭，false表示连接   
    private Integer sotimeout=1000*60;//读取超时时间，以毫秒为单位   
    //------------------------------------------------------------------------------   
    private ByteArrayOutputStream out;   
       
    public NKLongSocket(){   
//      init();   
    }   
       
    public NKLongSocket(String ip,Integer port,String operName){   
        this.ip = ip;   
        this.port = port;   
        this.operName = operName;   
//      init();   
    }   
    /**  
     * 初始化socket对象  
     * @throws IOException   
     */   
    public void init() throws IOException{   
        try {   
            out = new ByteArrayOutputStream();   
             //--------------------------------------------------   
            InetAddress address = InetAddress.getByName(ip);   
            socket = new Socket();     
//          socket = new Socket(address,port);   
            socket.setKeepAlive(true);//开启保持活动状态的套接字   
            socket.setSoTimeout(sotimeout);//设置超时时间   
            socket.connect(new InetSocketAddress(address, port), timeout);   
            close=!send(socket,"2");//发送初始数据，发送成功则表示已经连接上，发送失败表示已经断开   
            if(!close){   
                mylog.info("建立连接成功："+ip+":"+port);   
            }else{   
                mylog.error("创建连接失败:"+ip+":"+port);   
            }   
        }catch(UnknownHostException e) {   
            e.printStackTrace();   
            socket.close();   
            mylog.error("init socket Error:"+e.getMessage());   
            throw e;   
        }catch(IOException e){   
            e.printStackTrace();   
            socket.close();   
            mylog.error("init socket error:"+e.getMessage());   
            throw e;   
        }   
    }   
       
    /**  
     * 读数据线程  
     */   
    public void run() {   
        while(true){   
            //---------读数据---------------------------   
            close = isServerClose();//判断是否断开   
            if(!close){//没有断开，开始读数据   
                try {   
                    // 读取数据   
                    byte[] bytes = readStreamByte();   
                    //处理数据方法   
                    getLongByte(bytes);   
                } catch (Exception e) {   
                    e.printStackTrace();   
                }   
            }   
            //---------创建连接-------------------------   
            while(close){//已经断开，重新建立连接   
                try{   
                    mylog.info("重新建立连接："+ip+":"+port);   
                    //初始化连接   
                    init();   
                }catch(Exception se){   
                    mylog.error("创建连接失败:"+ip+":"+port);   
                    close=true;   
                }   
            }   
        }   
    }   
       
    /**  
     * 处理数据  
     * getLongByte    
     * (根据自己的需要修改)    
     * @param bytes  
     * @return  
     * @throws Exception：   ByteArrayOutputStream  
     * author： huastone  
     * 日期：2013-3-23-上午9:47:01     
     * @exception   
     * @version  V1.0.0  
     */   
    private ByteArrayOutputStream getLongByte(byte[] bytes) throws Exception{   
        for (byte b : bytes) {   
            if(b!=0){   
                out.write(b);   
                //判断到文件流尾部   
                if(b==40){   
                   //开始处理数据   
                    byte[] gh = out.toByteArray();   
                    int len = gh.length;   
                    //取数据到文件流尾部   
                    if(gh[len-3]==27 && gh[len-2]==74 && gh[len-1]==40){   
                           
                        mylog.info("||"+new String(gh,"GBK"));   
                        //---处理数据入库方法  自己增加就是   
                        //PoundSrv srv = new PoundSrv(gh,operName);   
                        //srv.run();   
                        //重置对象   
                        out.reset();   
                    }   
                }   
            }   
        }   
        return out;   
    }   
       
    /**  
     * 发送数据，发送失败返回false,发送成功返回true  
     * @param csocket  
     * @param message  
     * @return  
     */   
    private boolean send(Socket csocket,String message){   
        try{   
            PrintWriter out = new PrintWriter(csocket.getOutputStream(), true);   
            out.println(message);   
            return true;   
        }catch(Exception se){   
            se.printStackTrace();   
            return false;   
        }   
    }   
       
    /**  
     * 判断是否断开连接，断开返回true,没有返回false  
     * @param socket  
     * @return  
     * @throws IOException   
     */   
    private boolean isServerClose(){   
        try{   
            // 发送心跳包     
            socket.sendUrgentData(0);//发送1个字节的紧急数据，默认情况下，服务器端没有开启紧急数据处理，不影响正常通信   
            return false;   
        }catch(Exception se){   
            return true;   
        }   
    }   
       
       
       
    /**  
     * 将读取的数据流转换成字节数组  
     * readStreamByte    
     * @return：   byte[]  
     * author： huastone  
     * 日期：2013-3-25-上午11:15:47     
     * @throws Exception   
     * @exception   
     * @version  V1.0.0  
     */   
    private byte[] readStreamByte() throws Exception{   
        int readIndex = 50;   
        byte[] data = new byte[readIndex];   
        InputStream in;   
        try {    
            in = socket.getInputStream();   
            in.read(data, 0, readIndex);    
        }catch (IOException e) {    
            e.printStackTrace();    
        }   
        return data;   
    }   
       
    /**  
     * 将数据流转换成文本  
     * readTextAll    
     * (数据处理方法)    
     * @return：   String  
     * author： huastone  
     * 日期：2013-3-25-上午11:15:47     
     * @throws Exception   
     * @exception   
     * @version  V1.0.0  
     */   
    public String readTextAll() throws Exception{   
        String resultStr = null;    
        int readIndex = 50;   
        byte[] data = new byte[readIndex];   
        InputStream in;   
        try {    
            in = socket.getInputStream();    
            in.read(data, 0, readIndex);    
            if(data!=null){   
                for (byte b : data) {   
                    System.out.print(b+",");   
                }   
                System.out.println("");   
                System.out.println("----->");   
            }   
        }catch (IOException e) {    
            e.printStackTrace();    
        }   
        return resultStr;   
    }   
    /**  
     * (一次性读取数据，转换成文本)  
     * getResultStr1    
     * (数据处理方法)    
     * @param sourceSocket  
     * @return：   String  
     * author： huastone  
     * 日期：2013-3-24-上午9:29:15     
     * @throws InterruptedException   
     * @exception   
     * @version  V1.0.0  
     */   
    public String getResultStrAll() throws InterruptedException {   
        String resultStr = null;    
        InputStream in;    
        try {    
            in = socket.getInputStream();    
            int readIndex = 4096 * 20;    
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in,"GBK"), readIndex);   
            char[] charArray = new char[readIndex];    
            int read_rst = bufferedReader.read(charArray);   
            for (char c : charArray) {   
                mylog.info("-->:"+c);   
            }   
            resultStr = new String(charArray, 0, read_rst);   
        } catch (IOException e) {    
            e.printStackTrace();    
        }    
        return resultStr;    
    }   
       
    /**  
     *   
     * (将数据流转换成文本--读取方法)  
     * getHEX    
     * (数据处理方法)    
     * @return  
     * @throws InterruptedException：   String  
     * author： huastone  
     * 日期：2013-3-24-上午10:10:48     
     * @exception   
     * @version  V1.0.0  
     */   
    public String getHEX() throws InterruptedException {   
        String resultStr = null;    
        InputStream in;    
        try {    
            in = socket.getInputStream();    
            int readIndex = 4096 * 20;    
            DataInputStream dataIn = new DataInputStream(in);   
            byte[] buf = new byte[readIndex];   
            int read_rst = dataIn.read(buf);   
            for (byte c : buf) {   
                mylog.info("-->:"+c);   
            }   
            resultStr = new String(buf, 0, read_rst);   
        } catch (IOException e) {    
            e.printStackTrace();    
        }    
        return resultStr;    
    }    
       
    /**  
     * (一字节一字节读取)  
     * getResultStr    
     * (数据处理方法)    
     * @param sourceSocket  
     * @return：   String  
     * author： huastone  
     * 日期：2013-3-24-上午7:37:50     
     * @exception   
     * @version  V1.0.0  
     */   
    public String getResultStr(){   
        String resultStr = null;    
        InputStream in = null;    
        try {    
            in = socket.getInputStream();    
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));    
            int read_rst = bufferedReader.read();    
            StringBuffer readBuffer = new StringBuffer();    
            while (read_rst != -1){    
                char singleChar = (char) read_rst;    
                mylog.info("-->"+singleChar);   
                readBuffer.append(singleChar);    
            }    
            bufferedReader.close();    
            resultStr = readBuffer.toString();    
        } catch (IOException e) {    
            e.printStackTrace();    
        }    
        return resultStr;    
    }    
       
    /**   
     * 读取流   
     * @param inStream   
     * @return 字节数组   
     * @throws Exception   
     */     
    public static byte[] readStream(InputStream in) throws Exception {     
        ByteArrayOutputStream out = new ByteArrayOutputStream();     
        byte[] buffer = new byte[1024];     
        int len = -1;     
        while ((len = in.read(buffer)) != -1) {     
            out.write(buffer, 0, len);     
        }     
        out.close();     
        in.close();     
        return out.toByteArray();   
    }   
       
    /**  
     * 读取数据  
     * inputStreamToByte    
     * (数据流处理方法)    
     * @param inStream  
     * @return  
     * @throws Exception：   byte[]  
     * author： huastone  
     * 日期：2013-3-24-上午10:12:16     
     * @exception   
     * @version  V1.0.0  
     */   
    public byte[] inputStreamToByte(InputStream inStream) throws Exception {   
        int count = 0;   
        int haveCheck = 0;   
        // 如果在网络传输中数据没有完全传递，则方法返回0   
        while (count == 0) {   
            count = inStream.available();   
            haveCheck++;   
            if (haveCheck >= 50)   
                return null;   
        }   
        byte[] b = new byte[count];   
        inStream.read(b);   
        return b;   
    }   
       
    /**  
     * 读取数据  
     * inputStreamAll    
     * (数据流处理方法)    
     * @param inStream  
     * @return  
     * @throws Exception：   byte[]  
     * author： huastone  
     * 日期：2013-3-24-上午10:12:47     
     * @exception   
     * @version  V1.0.0  
     */   
    public byte[] inputStreamAll(InputStream inStream) throws Exception {   
        int count = 100;   
        byte[] b = new byte[count];   
        int readCount = 0; // 已经成功读取的字节的个数   
        while (readCount < count) {   
            readCount += inStream.read(b, readCount, count - readCount);   
        }   
        return b;   
    }   
       
       
    /**  
     * 读取数据  
     * getStreamAll    
     * (数据流处理方法)    
     * @param is  
     * @return  
     * @throws Exception：   byte[]  
     * author： huastone  
     * 日期：2013-3-24-上午10:12:47  
     * @exception   
     * @version  V1.0.0  
     */   
    public byte[] getStreamAll(InputStream is) throws Exception{   
        int readBytes=0;   
        //1024可改成任何需要的值   
        byte[] b= new byte[100];   
        int len=b.length;   
        while (readBytes < len) {   
            int read = is.read(b, readBytes, len - readBytes);   
            //判断是不是读到了数据流的末尾 ，防止出现死循环。   
            if (read == -1) {   
                break;   
            }   
            readBytes += read;   
        }   
        return b;   
    }   
       
       
}  