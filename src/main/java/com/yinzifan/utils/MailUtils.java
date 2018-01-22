package com.yinzifan.utils;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

/**
* @author Cin
* @time 2018/01/03 21:19:15
*/
public class MailUtils {
    public static void foo() {
        
    }
    
	/**
	 * 发送邮件
	 * @param to
	 * @param code
	 */
	public static void sendMail(String to, String content) {
		//1 创建连接对象
		Properties properties = new Properties();
		//2 创建邮件对象
		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("root@cincommon.com", "root");
			}			
		});
		//3 发送一封邮件
//		Transport.send(msg);
	}
	
}
