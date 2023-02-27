import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class workServer {
    public static void main(String[] args){
        try{
            ServerSocket serverSocket = new ServerSocket(0001,2);
            System.out.println("Запустили сервер");

            Socket clientSocket = serverSocket.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
            String word = in.readLine();
            System.out.println("К нам пришел " + word);
            out.write("Привет, " + word + "\n");
            out.flush();
            clientSocket = serverSocket.accept();
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
            word = in.readLine();
            System.out.println("К нам пришел " + word);
            out.write("Привет, " + word + "\n");
            out.flush();
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
