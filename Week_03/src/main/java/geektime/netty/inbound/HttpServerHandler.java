package geektime.netty.inbound;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HttpServerHandler extends SimpleChannelInboundHandler<FullHttpRequest> {

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, FullHttpRequest fullHttpRequest) throws Exception {
        // 拿到请求相关参数  请求头 uri method content
        // 组装新的请求，传递参数
        System.out.println(fullHttpRequest.headers());
        System.out.println(fullHttpRequest.method());
        System.out.println(fullHttpRequest.content());
        System.out.println(fullHttpRequest.uri());

        String url = "http://localhost:8801";
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        String body = response.body().string();
        System.out.println(body);
        // 获取请求响应信息，组装返回
        System.out.println(response.header("Content-Type"));

        FullHttpResponse fullHttpResponse = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK);
        fullHttpResponse.headers().set("Content-Type", "text/html;charset=utf-8");
        StringBuilder builder = new StringBuilder();
        builder.append(body);
        ByteBuf buffer = Unpooled.copiedBuffer(builder, CharsetUtil.UTF_8);
        fullHttpResponse.content().writeBytes(buffer);
        buffer.release();
        channelHandlerContext.writeAndFlush(fullHttpResponse)
                .addListener(ChannelFutureListener.CLOSE);
    }
}
