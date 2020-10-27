package geektime.java000.netty;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 使用 Socket 监听 8801 端口
 * 输出 Hello World
 * 使用线程池
 */
public class HttpServer03 {

    public static void main(String[] args) throws IOException {
        System.out.println("Application start...");
        ExecutorService executorService = Executors.newFixedThreadPool(40);
        ServerSocket serverSocket = new ServerSocket(8801);
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                executorService.execute(() -> doService(socket));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void doService(Socket socket) {
        try {
            Thread.sleep(20);
            // 输出 Hello World
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
            printWriter.println("HTTP/1.1 200 OK");
            printWriter.println("Content-Type:text/html;charset=utf-8");
            printWriter.println();
            printWriter.write("Hello World");
            printWriter.close();
            socket.close();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
