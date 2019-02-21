package Client.Threads;

import GameLogic.NetzwerkHandler;

/**
 * Autor: Christoph Wohlers
 */
public class NetzwerkThread extends Thread {

    /**
     * Der NetzwerkThread initialisiert den NetzwerkHandler.
     */

    private NetzwerkHandler netzwerkHandler;

    public NetzwerkThread(String serverip, int serverport) {
        super("NetzwerkThread");
        netzwerkHandler = NetzwerkHandler.getInstance(serverip, serverport);
    }


    @Override
    public void run() {
            netzwerkHandler.initialize();
    }

    public NetzwerkHandler getNetzwerkHandler() {
        return netzwerkHandler;
    }


}
