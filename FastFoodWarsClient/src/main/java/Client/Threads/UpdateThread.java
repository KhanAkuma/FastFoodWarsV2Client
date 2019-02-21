package Client.Threads;

import GameLogic.UpdateHandler;

/**
 * Autor: Christoph Wohlers
 */
public class UpdateThread extends Thread {

    /**
     * Der UpdateThread initialisiert den UpdateHandler.
     */

    private UpdateHandler updateHandler = UpdateHandler.getInstance();

    public UpdateThread() {
        super("UpdateThread");
    }

    @Override
    public void run() {
        updateHandler.initialize();
    }

    public UpdateHandler getUpdateHandler() {
        return updateHandler;
    }

}
