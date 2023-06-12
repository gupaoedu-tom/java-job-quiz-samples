package com.gupaoedu.job.quiz.node02;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;

public class NettyPipelineTest {

    public static void main(String[] args) {
        Bootstrap client = new Bootstrap();
        client.channel(NioSocketChannel .class)
        .handler(new ChannelInitializer() {
            @Override
            protected void initChannel(Channel ch) throws Exception {
                // 接收客户端请求的处理流程
                ChannelPipeline pipeline = ch.pipeline();
                // 对象编码器
                pipeline.addLast("encoder",new ObjectEncoder());
                // 对象解码器
                pipeline.addLast("encoder", new ObjectDecoder());
            }
        });
    }


}
