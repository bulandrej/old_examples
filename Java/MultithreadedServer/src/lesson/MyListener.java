package lesson;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import static java.lang.Double.parseDouble;

public class MyListener implements Runnable {
    Socket socket = null;
    ObjectOutputStream out = null;
    ObjectInputStream in = null;
    String msg = "";

    public MyListener(Socket s) {
        this.socket = s;
    }

    @Override
    public void run() {
        try {
            System.out.println("Подключился клиент " +
                    this.socket.getInetAddress().getHostName());
            out = new ObjectOutputStream(socket.
                    getOutputStream());
            out.flush();
            in = new ObjectInputStream(socket.
                    getInputStream());
            do {
                try {
                    msg = (String) in.readObject();
                    System.out.println("данные от клиента: " + msg);
                    if (msg.equals("break")) {
                        break;
                    }

                    sendMessage(ParseMSG(msg));
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(MyListener.
                            class.getName()).
                            log(Level.SEVERE, null, ex);
                }
            } while (!msg.equals("break"));
        } catch (IOException ex) {
            Logger.getLogger(MyListener.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
    }

    void sendMessage(String m) {
        try {
            out.writeObject(m);
            out.flush();
        } catch (IOException ex) {
            Logger.getLogger(MyListener.
                    class.getName()).
                    log(Level.SEVERE, null, ex);
        }
    }

    public String ParseMSG(String in){
        try {
            String[] fields = in.split("[ ]");
            String result = Double.toString(parseDouble(fields[0]) + parseDouble(fields[1]));

            return ("Результат: " + result);
        }catch(Exception e){
            return "Введите корректные данные!";
        }
    }
}
