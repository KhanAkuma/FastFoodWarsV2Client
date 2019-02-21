package GameLogic;

import java.io.*;
import java.net.Socket;

/**
 * Autoren: Christoph Wohlers, Jakob Grosse Boeckmann
 */
public class NetzwerkHandler {

    /**
     * Der NetzwerkHandler baut eine Verbindung zum Server auf. Dafuer
     * werden entweder Parameter fuer Server-IP und Server-Port uebergeben
     * oder er baut eine Verbindung mit Standard-Werten auf.
     * Er ist ein Singleton, damit es nur eine Verbindung pro Client zum Server gibt.
     */

    private int port = 4444;
    private String host = "localhost";
    private String[] serverAnswer;
    private String clientIn;

    private Socket socket;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;


    private static NetzwerkHandler nw = null;

    private NetzwerkHandler() {
        host = "localhost";
        port = 4444;

        try {
            socket = new Socket(host, port);
            oos = new ObjectOutputStream(socket.getOutputStream());
            ois = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            //e.printStackTrace();
        }
    }

    private NetzwerkHandler(String serverip, int serverport) {

        host = serverip;
        port = serverport;

        try {
            socket = new Socket(host, port);
            oos = new ObjectOutputStream(socket.getOutputStream());
            ois = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            //e.printStackTrace();
        }
    }

    public static NetzwerkHandler getInstance(String serverip, int serverport) {
        if (nw == null) {
            nw = new NetzwerkHandler(serverip, serverport);
        }
        return nw;
    }

    public static NetzwerkHandler getInstance() {
        if (nw == null) {
            nw = new NetzwerkHandler();
        }
        return nw;
    }


    /**
     * Hier wird die Verbindung zum Server aufgebaut. Der NetzwerkHandler
     * horcht nach Antworten vom Server.
     */
    public void initialize() {

        System.out.println(socket.getLocalPort());
        String[] clientIn;
        String[] serverIn;
        String[] fromServer;
        String[] fromUser = null;

        System.out.println("Establishing communication with server");
        try {
            while ((fromServer = (String[]) ois.readObject()) != null) {

                String input = "";
                for (int i = 0; i < fromServer.length; i++) {
                    input += fromServer[i] + ";";
                }
                System.out.println("InputVonServer: " + input);
                serverAnswer = fromServer;
                //TODO: GGF. Beantworte Serverrequest
            }
        } catch (IOException e) {
            //e.printStackTrace();
        } catch (ClassNotFoundException f) {
            //f.printStackTrace();
        }
    }


    /**
     * Hier wird ein Befehl-String-Array an den Server gesendet.
     *
     * @param befehl Befehl, der an den Server gesendet wird.
     */
    public void sendeBefehl(String[] befehl) {
        try {
            oos.writeObject(befehl);
        } catch (IOException e) {
            //e.printStackTrace();
        }

        String input = "";
        for (int i = 0; i < befehl.length; i++) {
            input += befehl[i] + ";";
        }
        System.out.println("Befehl: " + input + "!");
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getClientIn() {

        return clientIn;
    }

    public String[] getServerAnswer() {
        return serverAnswer;
    }

    public void setClientIn(String clientIn) {
        this.clientIn = clientIn;
    }

    public int getPort() {

        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void setServerAnswer(String[] serverAnswer) {
        this.serverAnswer = serverAnswer;
    }
}
