package geektime.netty.filter;

import okhttp3.Headers;

public class MyFilter {

    /**
     * 添加一个请求头  nio: xxx
     */
    public Headers doFilter() {
        return new Headers.Builder().add("nio", "xxx").build();
    }
}
