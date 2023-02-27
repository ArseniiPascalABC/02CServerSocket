import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class workServerOptimaze {
    static Socket clientSocket;
    static BufferedReader in;
    static BufferedWriter out;
    static String word;
    public static void main(String[] args){
        try{
            ServerSocket serverSocket = new ServerSocket(0001,2);
            System.out.println("Запустили сервер");
            for (int i = 0; i < 2; i++){
                clientSocket = serverSocket.accept();
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
                word = in.readLine();
                System.out.println("К нам пришел " + word);
                out.write("Привет, " + word + "\n");
                out.flush();
            }
            clientSocket.close();
            in.close();
            out.close();
            System.out.println("Сервер закрыт");
            serverSocket.close();
        } catch (IOException e){
            System.err.println(e);
        }
    }
}
