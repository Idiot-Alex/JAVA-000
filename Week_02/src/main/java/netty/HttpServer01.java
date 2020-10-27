package netty;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 使用 Socket 监听 8801 端口
 * 输出 Hello World
 */
public class HttpServer01 {

    public static void main(String[] args) throws IOException {
        System.out.println("Application start...");
        ServerSocket serverSocket = new ServerSocket(8801);
        while (true) {
            Socket socket = serverSocket.accept();
            doService(socket);
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
