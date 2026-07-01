package multithreadesocket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class SocketClient {
    static void main() {
        try(Socket socket = new Socket("10.4.240.165",8080);
            PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            Scanner scanner = new Scanner(System.in)){

            System.out.println("成功连接服务器！");
            System.out.println("请输入消息：");

            while(true){
                System.out.println("你：");
                String msg = scanner.nextLine();

                if ("exit".equalsIgnoreCase(msg)){
                    System.out.println("正在断开连接....");
                    break;
                }
                out.println(msg);

                String response = in.readLine();
                System.out.println(response); //服务端响应
            }
        }catch (Exception e){
            System.out.println("无法连接到服务器，请确认服务端已启动。");
            e.printStackTrace();
        }
    }
}
