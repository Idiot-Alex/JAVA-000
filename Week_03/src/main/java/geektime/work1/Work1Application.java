package geektime.work1;

import geektime.netty.inbound.HttpServerHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

/**
 * 作业 1
 * 使用 Netty 接收 HTTP 请求并且转发到 Server
 * 比如客户端访问 localhost:8080/ 实际上经过 Netty 中转访问 localhost:8801/
 */
public class Work1Application {

    public static void main(String[] args) throws InterruptedException {
        int port = 8080;
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup(16);
        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    // 设置线程队列得到连接个数
                    .option(ChannelOption.SO_BACKLOG, 128)
                    // 无延迟
                    .option(ChannelOption.TCP_NODELAY, true)
                    // 设置保持活动连接状态
                    .option(ChannelOption.SO_KEEPALIVE, true)
                    .handler(new LoggingHandler(LogLevel.INFO))
                    // 子处理器
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel channel) throws Exception {
                            channel.pipeline()
                                    // HttpRequest decoder
                                    .addLast(new HttpRequestDecoder())
                                    .addLast(new HttpObjectAggregator(1024 * 1024))
                                    // HttpResponse encoder
                                    .addLast(new HttpResponseEncoder())
                                    .addLast(new HttpServerHandler())
                            ;
                        }
                    });
            System.out.println("Netty Server start.....");
            // 绑定端口号，启动服务端
            ChannelFuture channelFuture = serverBootstrap.bind(port).sync();
            // 对关闭通道进行监听
            channelFuture.channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
