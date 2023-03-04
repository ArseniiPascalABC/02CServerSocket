import java.io.*;
import java.net.Socket;

class ClientHandler implements Runnable {
    static String username;
    private final Socket clientSocket;
    int counter;
    BufferedWriter out = null;
    BufferedReader in = null;

    public ClientHandler(Socket socket, int counter)
    {
        this.clientSocket = socket;
        this.counter = counter;
    }

    public void run() {
        String arr[] = new String[10];
        try {
            out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String word = "";
            int j;
            while (true) {
                j = 1;
                username = in.readLine();
                arr[counter] = username;
                out.write("Привет, " + username + "\n");
                out.flush();
                word = in.readLine();
                while (!word.equals("bye")){
                    if ((word.equals("exit")) && (arr[counter].equals("admin"))) {
                        out.flush();
                        in.close();
                        out.close();
                        System.out.println("Пока " + username);
                        clientSocket.close();

                        System.out.println("Сервер закрыт");
                        System.exit(0);
                        break;
                    } else {
                        System.out.println("Получено сообщение от пользователя №" + counter + "(" + arr[counter]  + "): " + word);
                        out.write(j + " " + word + "\n");
                        out.flush();
                        j++;
                        word = in.readLine();
                    }
                }
                out.flush();
                out.close();
                in.close();
                System.out.println("Пока " + arr[counter]);
            }
        } catch (IOException e) {
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
