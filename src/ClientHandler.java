import java.io.*;
import java.net.Socket;

class ClientHandler implements Runnable {
    static BufferedReader in;
    static BufferedWriter out;
    static String username;
    private final Socket clientSocket;

    // Constructor
    public ClientHandler(Socket socket)
    {
        this.clientSocket = socket;
    }

    public void run() {
        BufferedWriter out = null;
        BufferedReader in = null;

        try {
            out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String word;
            int j;
            boolean x = true;
            while (x) {
                j = 1;
                username = in.readLine();
                System.out.println("К нам пришел " + username);
                out.write("Привет, " + username + "\n");
                out.flush();

                word = in.readLine();
                if (!word.equals("bye")) {
                    while (!word.equals("bye")) {
                        if ((word.equals("exit")) && (username.equals("admin"))) {
                            out.flush();
                            in.close();
                            out.close();
                            System.out.println("Пока " + username);
                            clientSocket.close();
                            System.out.println("Сервер закрыт");
                            System.exit(0);
                        } else {
                            System.out.println("Получено сообщение: " + word);
                            out.write(j + " " + word + "\n");
                            out.flush();
                            j++;
                            word = in.readLine();
                        }
                    }
                }
                else{
                    System.out.println("Пока " + username);
                    in.close();
                    out.flush();
                    out.close();
                    clientSocket.close();
                    x = false;
                }
            }
            clientSocket.close();
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
