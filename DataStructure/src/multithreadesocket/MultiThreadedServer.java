package multithreadesocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreadedServer {

    static void main() throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);

        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        System.out.println("多线程服务端已经启动，端口8080，等待连接....");

        try{
            while (true){
                Socket clientsocket = serverSocket.accept();
                System.out.println("客户端接入："+clientsocket.getInetAddress()+"["+clientsocket.getPort()+"]");
                threadPool.execute(new ClientHandler(clientsocket));
            }
        }finally {
            serverSocket.close();

        }
    }

    static class ClientHandler implements Runnable {
        private Socket socket;
        public ClientHandler(Socket socket){
            this.socket = socket;
        }
        @Override
        public void run(){
            try(
                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
            ){
                String cMessage;
                String sMsg;
                Scanner scanner = new Scanner(System.in);
                while ((cMessage = in.readLine()) != null){
                    System.out.println("收到客户端消息："+cMessage);
                    System.out.println("请输入服务器回答内容：");
                    sMsg = scanner.nextLine();
                    out.println("服务器回答："+sMsg);
                }
            }catch (IOException e){
                System.out.println("服务器["+socket.getPort()+"],异常断开");
            }finally {
                try {
                    if (socket != null && !socket.isClosed()){
                        socket.close();
                    }
                }catch (IOException e){
                    e.printStackTrace();
                }
                System.out.println("服务器["+socket.getPort()+"],连接已释放");
            }
        }
    }
}


