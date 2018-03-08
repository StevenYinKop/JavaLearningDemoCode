package com.yinzifan.algorithm;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import java.util.ArrayList;
import java.util.List;

/**
 * 节点
 */
class Node{

    /** 节点id **/
    private String id;
    /** 父节点id **/
    private String pid;
    /** 节点名称 **/
    private String name;
    /** 子节点 **/
    private List<Node> childen;
    /** 构造函数 **/
    public Node(){}
    /** 构造函数 **/
    public Node(String id,String pid,String name,List<Node> nodes){
        this.id = id;
        this.pid = pid;
        this.name = name;
        this.childen = nodes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Node> getChilden() {
        return childen;
    }

    public void setChilden(List<Node> childen) {
        this.childen = childen;
    }
}

/**
 * 递归函数测试
 * Created by Ay on 2016/7/2.
 */
public class RecursionDemo {

    public static String nodeName = "";

    public static void main(String[] args) {
        /** 初始化树模型 **/
        Node node = initTreeModel();
        /** 节点id **/
        getNodeId(node, "CC2");
    }

    /**
     *
     * @param node
     * @return
     */
    public static String getNodeId(Node node,String myId){
        /** 打印每次遍历节点信息 **/
        System.out.println("--->>>" + node.getId());
        /** 判断是否是我们苦苦寻找的id **/
        if(StringUtils.isNotEmpty(myId) && myId.equals(node.getId())){
            nodeName = node.getName();
            return nodeName;
        }else{
            if(null != node.getChilden() && node.getChilden().size() >0){
                    for(Node n:node.getChilden()){
                        /** 这里是重点中的重点，如果nodeName不为空，恭喜你找到了，返回该值,
                          递归函数就会一层一层的返回，每一层的返回都会进行该判断，但我们已经找到
                         值了，所有递归相当于被打破了**/
                        if(StringUtils.isNotEmpty(nodeName)){
                            return nodeName;
                        }else{
                            /** 继续递归 **/
                            getNodeId(n, myId);
                        }

                    }
            }
            return null;
        }
    }


    /**
     * 初始化树模型
     * @return
     */
    public static Node initTreeModel(){
        /** 构造第三层节点 **/
        Node AAA1 = new Node("AAA1","AA1","AAA1",null);
        Node AAA2 = new Node("AAA2","AA1","AAA2",null);
        Node AAA3 = new Node("AAA3","AA1","AAA3",null);
        Node AAA4 = new Node("AAA4","AA1","AAA4",null);
        List<Node> AAANodes = new ArrayList<>();
        AAANodes.add(AAA1);
        AAANodes.add(AAA2);
        AAANodes.add(AAA3);
        AAANodes.add(AAA4);

        Node AA1 = new Node("AA1","A","AA1",null);
        Node AA2 = new Node("AA2","A","AA2",null);
        Node AA3 = new Node("AA3","A","AA3",null);

        List<Node> AANodes = new ArrayList<>();
        AANodes.add(AA1);
        AANodes.add(AA2);
        AANodes.add(AA3);

        Node A = new Node("A","0","A",null);

        AA1.setChilden(AAANodes);
        A.setChilden(AANodes);

        Node BBB1 = new Node("BBB1","BB1","BBB1",null);
        Node BBB2 = new Node("BBB2","BB1","BBB2",null);
        Node BBB3 = new Node("BBB3","BB1","BBB3",null);
        Node BBB4 = new Node("BBB4","BB1","BBB4",null);

        List<Node> BBBNode = new ArrayList<>();
        BBBNode.add(BBB1);
        BBBNode.add(BBB2);
        BBBNode.add(BBB3);

        BBBNode.add(BBB4);

        Node BB1 = new Node("BB1","B","BB1",null);
        Node BB2 = new Node("BB2","B","BB2",null);
        Node BB3 = new Node("BB3","B","BB3",null);

        List<Node> BBNode = new ArrayList<>();
        BBNode.add(BB1);
        BBNode.add(BB2);
        BBNode.add(BB3);

        Node B = new Node("B","0","B",null);

        B.setChilden(BBNode);
        BB1.setChilden(BBBNode);

        Node CC1 = new Node("CC1","C","CC1",null);
        Node CC2 = new Node("CC2","C","CC2",null);
        Node CC3 = new Node("CC3","C","CC3",null);
        List<Node> CCNode = new ArrayList<>();
        CCNode.add(CC1);
        CCNode.add(CC2);
        CCNode.add(CC3);

        Node C = new Node("C","0","C",null);
        C.setChilden(CCNode);

        List<Node> nodes = new ArrayList<>();
        nodes.add(A);
        nodes.add(B);
        nodes.add(C);
        System.out.println(nodes.toString());
        Node root = new Node("0",null,"root",nodes);
        /** 打印json数据 **/
        System.out.println(JSONObject.toJSON(root).toString());
        return root;
    }
}
