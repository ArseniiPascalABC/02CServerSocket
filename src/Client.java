import java.io.*;
import java.net.Socket;

public class Client {
    private static Socket clientSocket;
    private static BufferedReader reader;
    private static BufferedReader in;
    private static BufferedWriter out;

    public static void main(String[] args) {
        try {
            clientSocket = new Socket("localhost", 0001);
            reader = new BufferedReader(new InputStreamReader(System.in));
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

            System.out.println("Ваше Имя? :");
            String username = reader.readLine();
            out.write(username + "\n");
            out.flush();
            String serverWord = in.readLine();
            System.out.println(serverWord);
            String word;
            while(true){
                System.out.println("Введите слово: ");
                word = reader.readLine();
                out.write(word + "\n");
                out.flush();
                if ((word.equals("bye"))||(word.equals("exit") && username.equals("admin"))){
                    clientSocket.close();
                    in.close();
                    out.flush();
                    out.close();
                    break;
                }
                else{
                    serverWord = in.readLine();
                    System.out.println(serverWord);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}