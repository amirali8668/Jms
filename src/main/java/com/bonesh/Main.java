package com.bonesh;

import jakarta.jms.*;
import org.apache.activemq.ActiveMQConnectionFactory;

public class Main {
    public static void main(String[] args) {
//        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
//        try {
//            Connection connection = connectionFactory.createConnection();
//            connection.start();
//            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
//            Queue queue = session.createQueue("Satna");
//            MessageProducer messageProducer = session.createProducer(queue);
//            TextMessage textMessage = session.createTextMessage("sent: satna as IR1554848488484848 from IR15415615611514 15789674");
//            messageProducer.send(textMessage);
//            session.close();
//            connection.close();
//
//
//        } catch (JMSException e) {
//            throw new RuntimeException(e);
//        }


            ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
            try {
                Connection connection = connectionFactory.createConnection();
                Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
                MessageConsumer messageConsumer = session.createConsumer(session.createQueue("Satna"));
                TextMessage message = (TextMessage) messageConsumer.receive();
                System.out.println("This Text Mess of Queue:  " + message.getText());
                messageConsumer.close();
                session.close();
                connection.close();


            } catch (JMSException e) {
                throw new RuntimeException(e);
            }


    }
}