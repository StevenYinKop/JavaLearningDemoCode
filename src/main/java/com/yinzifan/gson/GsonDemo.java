package com.yinzifan.gson;

import com.google.gson.Gson;
import com.yinzifan.gson.entity.DemoEntity;

/**
 * @author yinzf2
 * 2018/07/05	14:28:19
 */
public class GsonDemo {
    public static void main(String[] args) {
        String demoStr1 = 
"{\r\n" + 
"    \"id\": \"ch_K8abn1HW1eXHPm9e9CWnHG88\",\r\n" + 
"    \"object\": \"charge\",\r\n" + 
"    \"created\": 1530771654,\r\n" + 
"    \"livemode\": false,\r\n" + 
"    \"paid\": false,\r\n" + 
"    \"refunded\": false,\r\n" + 
"    \"reversed\": false,\r\n" + 
"    \"app\": \"app_mTifv9qDe5COz90a\",\r\n" + 
"    \"channel\": \"wx\",\r\n" + 
"    \"order_no\": \"18070540312\",\r\n" + 
"    \"client_ip\": \"98.146.197.49\",\r\n" + 
"    \"amount\": 600,\r\n" + 
"    \"amount_settle\": 600,\r\n" + 
"    \"currency\": \"cny\",\r\n" + 
"    \"subject\": \"充值订单\",\r\n" + 
"    \"body\": \"用户 guagua1 充值 6元。\",\r\n" + 
"    \"extra\": {},\r\n" + 
"    \"time_paid\": null,\r\n" + 
"    \"time_expire\": 1530778853,\r\n" + 
"    \"time_settle\": null,\r\n" + 
"    \"transaction_no\": null,\r\n" + 
"    \"refunds\": {\r\n" + 
"        \"object\": \"list\",\r\n" + 
"        \"url\": \"\\/v1\\/charges\\/ch_K8abn1HW1eXHPm9e9CWnHG88\\/refunds\",\r\n" + 
"        \"has_more\": false,\r\n" + 
"        \"data\": []\r\n" + 
"    },\r\n" + 
"    \"amount_refunded\": 0,\r\n" + 
"    \"failure_code\": null,\r\n" + 
"    \"failure_msg\": null,\r\n" + 
"    \"metadata\": {},\r\n" + 
"    \"credential\": {\r\n" + 
"        \"object\": \"credential\",\r\n" + 
"        \"wx\": {\r\n" + 
"            \"appId\": \"wxqlahw1vxhi90vlmf\",\r\n" + 
"            \"partnerId\": \"2650949467\",\r\n" + 
"            \"prepayId\": \"11010000001807054qvbj1vpi9u5y18i\",\r\n" + 
"            \"nonceStr\": \"887dbf029e288dcef24d8f4fa514cd15\",\r\n" + 
"            \"timeStamp\": 1530771654,\r\n" + 
"            \"packageValue\": \"Sign=WXPay\",\r\n" + 
"            \"sign\": \"C66CEF5AD0276AB5A14379B4800B1C47\"\r\n" + 
"        }\r\n" + 
"    },\r\n" + 
"    \"description\": null\r\n" + 
"}";

        Gson gson = new Gson();
        DemoEntity fromJson = gson.fromJson(demoStr1, DemoEntity.class);
        System.out.println(fromJson.toString());
        // DemoEntity [id=ch_K8abn1HW1eXHPm9e9CWnHG88, object=charge, created=1530771654, livemode=false, paid=false, refunded=false, reversed=false, app=app_mTifv9qDe5COz90a, channel=wx, order_no=18070540312, client_ip=98.146.197.49, amount=600, amount_settle=600, currency=cny, subject=充值订单, body=用户 guagua1 充值 6元。, extra={}, time_paid=null, time_expire=1530778853, time_settle=null, transaction_no=null, refunds=Refunds [object=list, url=/v1/charges/ch_K8abn1HW1eXHPm9e9CWnHG88/refunds, has_more=false, data=[]], amount_refunded=0, failure=null, failure_msg=null, credential=Credential [object=credential, wx=Wx [appId=wxqlahw1vxhi90vlmf, partnerId=2650949467, prepayId=11010000001807054qvbj1vpi9u5y18i, nonceStr=887dbf029e288dcef24d8f4fa514cd15, timeStamp=1530771654, packageValue=Sign=WXPay, sign=C66CEF5AD0276AB5A14379B4800B1C47]], description=null]
        
    }
}
