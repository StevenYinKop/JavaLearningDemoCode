package com.yinzifan.dtu;
/**     
 * 项目名：***********************   
 * 包名：dtu.model    
 * 文件名：TestDTU.java   
 * 文件描述:(DTU测试)  
 * 作者 ：huastone E-mail: huastone_he@163.com   
 * 创建时间：2013-3-22-上午11:30:21    
 * 版本信息：@version V1.0.0      
 */   
public class TestDTU {   
   
    /**     
     * DTU 调用方法  
     * main    
     * (这里描述这个方法适用条件 – 可选)    
     * @param args：   void  
     * author： huastone  
     * 日期：2013-3-22-上午11:30:25      
     * @exception   
     * @version  V1.0.0     
     */   
    public static void main(String[] args) {   
        String host_ip = "xxx.xxx.xxx.xx";   //DTU的IP地址   
        int port = 1001;       //DTU端口   
        //调用   
        NKLongSocket nksocket = new NKLongSocket(host_ip,port,null);   
        nksocket.start();   
    }   
   
}  