package geektime.netty.http;

import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class MyHttpClient {

    /**
     * 发送 HTTP 请求
     * 返回 Response
     * @param url
     * @return
     * @throws IOException
     */
    public Response doHttpRequest(String url) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        return response;
    }

    public Response doHttpRequest(String url, Headers headers) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .headers(headers)
                .build();

        Response response = client.newCall(request).execute();
        return response;
    }
}
