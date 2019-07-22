package lesson;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChatServer {
    ServerSocket listener = null;
    Socket client = null;
    int maxCount = 10;
    int count = 0;
    int port = 8888;

    public static void main(String[] args) {
        ChatServer chat = new ChatServer();
        chat.createConnection();
    }

    void createConnection() {

        try {
            listener = new ServerSocket(port, maxCount);
            System.out.println("Установлено состояние прослушивания соединений...");
            System.out.println("Всего может подключиться " + maxCount + " клиентов.");
            while (count <= maxCount) {
                count++;
                client = listener.accept();
                System.out.println("Подключился клиент " + client.getInetAddress().getHostName());
                MyListener ml = new MyListener(client);
                Thread t = new Thread(ml);
                t.setDaemon(true);
                t.start();
            }
        } catch (IOException ex) {
            Logger.getLogger(ChatServer.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
    }
}
