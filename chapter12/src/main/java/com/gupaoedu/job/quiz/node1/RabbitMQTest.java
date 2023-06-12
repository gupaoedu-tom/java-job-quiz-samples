package com.gupaoedu.job.quiz.node1;

import com.rabbitmq.client.*;

import java.io.IOException;

public class RabbitMQTest {

    private final static String QUEUE_NAME = "TEST_ACK_QUEUE";

    private final static String EXCHANGE_NAME = "";

    private final static byte[] data = null;

    private final static String ROUTING_KEY = "";

    public static void main(String[] args) throws Exception {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setUri("amqp://admin:123456@192.168.8.147:5672");

        // 建立连接
        Connection conn = factory.newConnection();
        // 创建消息通道
        final Channel channel = conn.createChannel();

        // 声明队列（默认交换机AMQP default，Direct）
        // String queue, boolean durable, boolean exclusive, boolean autoDelete, Map<String, Object> arguments
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        System.out.println(" Waiting for message....");


        channel.confirmSelect();

        channel.addConfirmListener(new ConfirmListener() {
            @Override
            public void handleAck(long deliveryTag, boolean multiple) throws IOException {

                System.out.println("确认收到消息");

                //其他处理
            }

            //RabbitMQ因自身内部错误导致消息丢失，就会发送一条nack消息
            @Override
            public void handleNack(long deliveryTag, boolean multiple) throws IOException {

                System.out.println("未确认消息，标识:" + deliveryTag);

                //其他处理，比如重新发送消息等

            }
        });


        channel.exchangeDeclare(EXCHANGE_NAME,"direct",true);

        channel.queueDeclare(QUEUE_NAME, true,false,false,null);

        channel.basicPublish(EXCHANGE_NAME,ROUTING_KEY,MessageProperties.PERSISTENT_TEXT_PLAIN,data);

    }

}
