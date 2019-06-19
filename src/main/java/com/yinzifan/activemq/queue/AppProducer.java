package com.yinzifan.activemq.queue;

import java.util.concurrent.ThreadLocalRandom;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppProducer {
	private static final String url="tcp://47.102.152.87:61616";
	private static final String queueName = "queue01";
	private static final Logger LOGGER = LoggerFactory.getLogger(AppProducer.class);
	public static void main(String[] args) throws JMSException {
		// 1. 创建连接工厂, 按照指定的url, 采用默认的用户名和密码
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
		// 2. 通过ConnectionFactory, 获得连接(Connection)
		Connection connection = connectionFactory.createConnection();
		// 3. 启动访问
		connection.start();
		// 4. 创建会话
		// 两个参数, transacted事务, acknowledgeMode签收
		// connection.createSession(transacted, acknowledgeMode);
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		// 5. 创建目的地(指定是队列queue还是主题topic)
		Queue queue = session.createQueue(queueName);
		// 6. 创建消息的生产者
		MessageProducer producer = session.createProducer(queue);
		// 7. 通过使用messageProducer生产100条消息发送到MQ的队列里面
		for (int i = 1; i <= 100; i++) {
			// 8. 瞎JB写点消息
			TextMessage textMessage = session.createTextMessage();
			String text = "msg" + i + ": random number:" + ThreadLocalRandom.current().nextDouble(100);
			textMessage.setText(text);
			LOGGER.info("text: {}", text);
			producer.send(textMessage);
		}
		// 9. 关闭资源
		producer.close();
		session.close();
		connection.close();
		LOGGER.info("***close***");
	}
}
