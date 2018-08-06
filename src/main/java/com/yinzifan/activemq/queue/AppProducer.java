package com.yinzifan.activemq.queue;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppProducer {

	private static final String url="tcp://127.0.0.1:61616";
	private static final String queueName = "first_queue";
	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AppProducer.class);
	public static void main(String[] args) throws JMSException {
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
		Connection connection = connectionFactory.createConnection();
		connection.start();
		
		// 创建会话
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE); // 应答模式, 自动应答
		
		Destination destination = session.createQueue(queueName);
		
		MessageProducer producer = session.createProducer(destination);
		
		for (int i = 0; i < 100; i++) {
			TextMessage textMessage = session.createTextMessage("text: " + i);
			producer.send(textMessage);
			LOGGER.info("发送消息: {}", textMessage.getText());
		}
		connection.close();
		// 创建目的地Destination
		
	}
}
