package Client.GUI;

import GameLogic.NetzwerkThreadHandler;
import GameLogic.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


/**
 * Autoren: Christoph Wohlers, Michael Schwenk
 */
public class LoginGUI implements Initializable {

    /**
     * LoginGUI.java ist der Controller fuer die Login-GUI. Hier werden die Elemente
     * der Login-GUI geladen und Aktionen in der Login-GUI werden verarbeitet.
     */

    @FXML
    Button loginButton;

    @FXML
    Button registrierenButton;

    @FXML
    PasswordField passwortRegistrieren;

    @FXML
    PasswordField passwortWiederholenRegistrieren;

    @FXML
    PasswordField passwortLogin;

    @FXML
    Label erfolgsLabelLogin;

    @FXML
    Label erfolgsLabelRegistrieren;

    @FXML
    TextField loginnameRegistrieren;

    @FXML
    TextField loginnameLogin;

    @FXML
    RadioButton waehleDiktator;

    @FXML
    RadioButton waehleKumpeltyp;

    @FXML
    RadioButton waehleKFC;

    @FXML
    RadioButton waehleMcKing;

    @FXML
    RadioButton waehlePizzaCap;

    @FXML
    Label serverAdresseLabel;

    @FXML
    TextField serverIPFeld, serverPortFeld;

    NetzwerkThreadHandler nth = NetzwerkThreadHandler.getInstance();

    /**
     * Hier wird die Login-GUI initialisiert. Die Inhalte der Methode
     * werden beim Aufruf der Login-GUI geladen.
     * Zudem wird festgelegt, welche Elemente welche Aktionen ausfuehren.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        serverAdresseLabel.setText("");

        final ToggleGroup charakter = new ToggleGroup();
        waehleDiktator.setToggleGroup(charakter);
        waehleKumpeltyp.setToggleGroup(charakter);
        waehleDiktator.setSelected(true);

        final ToggleGroup fraktion = new ToggleGroup();
        waehleKFC.setToggleGroup(fraktion);
        waehleMcKing.setToggleGroup(fraktion);
        waehlePizzaCap.setToggleGroup(fraktion);
        waehleKFC.setSelected(true);

        registrierenButton.setOnAction(this::handleButtonActionRegistrieren);
        loginButton.setOnAction(this::handleButtonActionLogin);

    }

    /**
     * Wird der Registrieren-Button geklickt, werden zunaechst die Server-IP und
     * der Server-Port aus der GUI ausgelesen. Es wird geprueft, ob die Passwoerter
     * uebereinstimmen und es werden die Auswahlen fuer Fraktion und Charakter ausgelesen.
     * Dann wird ein NetzwerkThread mit den Server-Daten erstellt und eine Verbindung mit dem
     * Server aufgebaut. Dann wird ein Befehl mit den eingegebenen Daten an den Server
     * gesendet. Gibt dieser True zurueck, war die Registrierung erfolgreich und der Spieler
     * wird eingeloggt. Ansonsten bekommt er eine Fehlermeldung.
     * Da ein NetzwerkThread gestartet und nicht beendet wird, werden die Textfelder fuer
     * die Server-Daten deaktiviert.
     */
    @FXML
    private void handleButtonActionRegistrieren(ActionEvent event) {

        if (!(passwortRegistrieren.getText().contains("#") || passwortRegistrieren.getText().contains("'") ||
                loginnameRegistrieren.getText().contains("#") || loginnameRegistrieren.getText().contains("'"))) {

            serverAdresseLabel.setText("Um die Server-Adresse zu aendern, starten Sie bitte den Client neu!");
            serverIPFeld.setDisable(true);
            serverPortFeld.setDisable(true);

            registrierenButton.setDisable(true);
            loginButton.setDisable(true);

            if (!passwortRegistrieren.getText().equals(passwortWiederholenRegistrieren.getText())) {

                registrierenButton.setDisable(false);
                loginButton.setDisable(false);

                erfolgsLabelRegistrieren.setText("Passwoerter stimmen nicht ueberein!");

            } else {

                String charakter;

                if (waehleDiktator.isSelected()) {
                    charakter = "D";
                } else {
                    charakter = "K";
                }

                String fraktion;

                if (waehleKFC.isSelected()) {
                    fraktion = "K";
                } else if (waehleMcKing.isSelected()) {
                    fraktion = "M";
                } else {
                    fraktion = "P";
                }

                try {
                    nth.startNetzwerkThread(serverIPFeld.getText(), Integer.parseInt(serverPortFeld.getText()));
                } catch (Exception e) {
                    //e.printStackTrace();
                }

                RegisterHandler rh = new RegisterHandler();
                String[] answer = rh.register(loginnameRegistrieren.getText(), passwortRegistrieren.getText(), fraktion, charakter);

                if (answer[0].equals("TRUE")) {
                    LoginHandler lh = new LoginHandler();
                    String answerLogin = lh.login(loginnameRegistrieren.getText(), passwortRegistrieren.getText());
                    if (answerLogin.equals("TRUE")) {
                        loadHomeGUI(event);
                    } else {
                        erfolgsLabelLogin.setText(answerLogin);
                    }

                } else if (answer[0].equals("EXISTIERT BEREITS")) {
                    //gib an User Message registrien nich moeglich

                    registrierenButton.setDisable(false);
                    loginButton.setDisable(false);

                    erfolgsLabelRegistrieren.setText("Der Name existiert bereits, waehle bitte einen anderen aus.");
                } else {
                    //gib an User Message registrien nich moeglich

                    registrierenButton.setDisable(false);
                    loginButton.setDisable(false);

                    erfolgsLabelRegistrieren.setText("Registrieren nicht moeglich.");
                }
            }
        } else {
            erfolgsLabelRegistrieren.setText("Registrieren nicht moeglich. Felder duerfen # und ' nicht enthalten!");
        }
    }


    /**
     * Ein NetzwerkThread wird mit den angegeben Server-Daten gestartet.
     * Die eingegeben Login-Daten werden an den Server gesendet. Bekommt
     * der CLient true zurueck, war der Login erfolgreich und die HomeGUI wird geladen.
     * Da ein NetzwerkThread gestartet und nicht beendet wird, werden die Textfelder fuer
     * die Server-Daten deaktiviert.
     */
    @FXML
    private void handleButtonActionLogin(ActionEvent event) {

        if (!(passwortLogin.getText().contains("#") || passwortLogin.getText().contains("'") ||
                loginnameLogin.getText().contains("#") || loginnameLogin.getText().contains("'"))) {

            serverAdresseLabel.setText("Um die Server-Adresse zu aendern, starten Sie bitte den Client neu!");
            serverIPFeld.setDisable(true);
            serverPortFeld.setDisable(true);

            registrierenButton.setDisable(true);
            loginButton.setDisable(true);

            try {
                nth.startNetzwerkThread(serverIPFeld.getText(), Integer.parseInt(serverPortFeld.getText()));
            } catch (Exception e) {
                //e.printStackTrace();
            }

            LoginHandler lh = new LoginHandler();
            String answer = lh.login(loginnameLogin.getText(), passwortLogin.getText());
            if (answer.equals("TRUE")) {
                loadHomeGUI(event);
            } else {
                //gib an User Message login nich moeglich

                registrierenButton.setDisable(false);
                loginButton.setDisable(false);

                erfolgsLabelLogin.setText(answer);
            }
        } else {
            erfolgsLabelLogin.setText("Login nicht moeglich. \nFelder duerfen # und ' nicht enthalten!");
        }
    }

    /**
     * Die HomeGUI.fxml wird geladen, es werden eine Scene erstellt,
     * die aktuelle Stage geladen und aktualisiert.
     * Die Home-GUI wird mit dieser Methode gestartet.
     */
    private void loadHomeGUI(ActionEvent event) {
        try {
            Parent rootHome = FXMLLoader.load(getClass().getClassLoader().getResource("Ansichten/HomeGUI.fxml"));
            Scene sceneHome = new Scene(rootHome);
            Stage homeStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            homeStage.setScene(sceneHome);
            homeStage.show();
        } catch (IOException e) {
            //e.printStackTrace();
        }
    }
}
