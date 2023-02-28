import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
public class workServerOptimaze {
    static Socket clientSocket;
    static BufferedReader in;
    static BufferedWriter out;
    static String username;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int j = 0;
        String word;
        try{
            ServerSocket serverSocket = new ServerSocket(0001);
            System.out.println("Запустили сервер");
            while(true){
                clientSocket = serverSocket.accept();
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

                username = in.readLine();
                System.out.println("К нам пришел " + username);
                out.write("Привет, " + username + "\n");
                out.flush();

                word = in.readLine();
                int x = Integer.parseInt(word);
                System.out.println("Принят x = " + x);
                out.write("x = " + word + "\n");
                out.flush();

                word = in.readLine();
                int y = Integer.parseInt(word);
                System.out.println("Принят y =" + y);
                out.write("y = " + word + "\n");
                double gg = ((3*Math.pow(Math.cos(x-(Math.PI/6)),2))/((1/2)+Math.sin(Math.pow(y,2))));
                System.out.println("Ответ =" + gg);

                out.write("Ответ =" + gg + "\n");
                out.flush();

                in.close();
                out.close();
                clientSocket.close();
            }

        } catch (IOException e){
            System.err.println(e);
        }
    }
}