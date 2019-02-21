package Client.GUI;

import Client.Main;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Autor: Christoph Wohlers
 */
public class GUIMain extends Application {

    /**
     * Die GUIMain startet die GUI mit Hilfe einer FXML-Datei. Ein FXMLLoader
     * laedt dazu die LoginGUI.fxml, erstellt eine Scene und eine Stage und zeigt diese
     * dann an. Wird der Schliessen-Button angeklickt, werden Platform und System beendet.
     *
     * @param primaryStage
     * @throws Exception
     */

    @Override
    public void start(Stage primaryStage) throws Exception {


        try {
            Parent rootLogin = FXMLLoader.load(getClass().getClassLoader().getResource("Ansichten/LoginGUI.fxml"));
            Scene sceneLogin = new Scene(rootLogin);
            primaryStage.setScene(sceneLogin);
            primaryStage.setTitle("FastFoodWars");
            primaryStage.show();

            primaryStage.setOnCloseRequest(event -> {
                Platform.exit();
                System.exit(1);
            });

        } catch (Exception e) {
            //e.printStackTrace();
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
        }
    }

}
