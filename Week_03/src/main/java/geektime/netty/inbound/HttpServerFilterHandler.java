package geektime.netty.inbound;

import geektime.netty.filter.MyFilter;
import geektime.netty.http.MyHttpClient;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;
import okhttp3.Headers;
import okhttp3.Response;

/**
 *
 */
public class HttpServerFilterHandler extends SimpleChannelInboundHandler<FullHttpRequest> {

    private MyFilter myFilter;

    public HttpServerFilterHandler(MyFilter myFilter) {
        this.myFilter = myFilter;
    }


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, FullHttpRequest request) throws Exception {
        // 拿到请求相关参数  请求头 uri method content
        // 组装新的请求，传递参数
        System.out.println("uri: " + request.uri());
        String url = "http://localhost:8801" + request.uri();

        MyHttpClient client = new MyHttpClient();
        // 设置 请求头
        Headers headers = myFilter.doFilter();
        Response response = client.doHttpRequest(url, headers);

        String body = response.body().string();
        System.out.println("body: " + body);
        // 获取请求响应信息，组装返回
        String contentType = response.header(HttpHeaderNames.CONTENT_TYPE.toString());
        System.out.println("Content-Type: " + contentType);

        FullHttpResponse fullHttpResponse = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK);
        fullHttpResponse.headers().set(HttpHeaderNames.CONTENT_TYPE, contentType);
        StringBuilder builder = new StringBuilder();
        builder.append(body);
        ByteBuf buffer = Unpooled.copiedBuffer(builder, CharsetUtil.UTF_8);
        fullHttpResponse.content().writeBytes(buffer);
        buffer.release();
        ctx.writeAndFlush(fullHttpResponse)
                .addListener(ChannelFutureListener.CLOSE);
    }
}
