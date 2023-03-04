import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
public class workServerOptimaze {
    static Socket clientSocket;

    public static void main(String[] args){
        try {
            ServerSocket serverSocket = new ServerSocket(0001);
            serverSocket.setReuseAddress(true);
            System.out.println("Запустили сервер");
            while (true) {
                clientSocket = serverSocket.accept();
                ClientHandler clientSock = new ClientHandler(clientSocket);
                new Thread(clientSock).start();


            }
        }catch (IOException e){
            System.err.println(e);
        }
    }
}
