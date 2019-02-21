package GameLogic;

import Client.Threads.NetzwerkThread;

/**
 * Autor: Christoph Wohlers
 */
public class NetzwerkThreadHandler {

    /**
     * Der NetzwerkThreadHandler startet einen NetzwerkThread mit
     * den Parametern serverip und serverport.
     */

    private static NetzwerkThreadHandler nw = null;

    private Thread netzwerkThread;

    public static NetzwerkThreadHandler getInstance() {
        if (nw == null) {
            nw = new NetzwerkThreadHandler();
        }
        return nw;
    }

    public void startNetzwerkThread(String serverip, int serverport) {
        if (netzwerkThread == null) {
            netzwerkThread = new Thread(new NetzwerkThread(serverip, serverport));
        }
        if (!netzwerkThread.isAlive()) {
            netzwerkThread.start();
        }
    }


}
