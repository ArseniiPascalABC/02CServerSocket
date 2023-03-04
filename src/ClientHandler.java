import java.io.*;
import java.net.Socket;

class ClientHandler implements Runnable {
    static String username;
    private final Socket clientSocket;
    int counter;

    // Constructor
    public ClientHandler(Socket socket, int counter)
    {
        this.clientSocket = socket;
        this.counter = counter;
    }

    public void run() {
        BufferedWriter out = null;
        BufferedReader in = null;
        try {
            out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String word = "";
            int j;
            while (true) {
                j = 1;
                username = in.readLine();
                out.write("Привет, " + username + "\n");
                out.flush();
                while (!"bye".equalsIgnoreCase(word = in.readLine())){
                    if ((word.equals("exit")) && (counter == 1)) {
                        out.flush();
                        in.close();
                        out.close();
                        System.out.println("Пока " + username);
                        clientSocket.close();
                        System.out.println("Сервер закрыт");
                        System.exit(0);
                    } else {
                        System.out.println("Получено сообщение от пользователя № " + counter + ": " + word);
                        out.write(j + " " + word + "\n");
                        out.flush();
                        j++;
                        word = in.readLine();
                    }
                }
                System.out.println("Пока " + username);
                in.close();
                out.flush();
                out.close();
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                    clientSocket.close();
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
