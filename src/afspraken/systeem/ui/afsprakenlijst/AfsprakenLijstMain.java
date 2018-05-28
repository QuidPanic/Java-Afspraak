package afspraken.systeem.ui.afsprakenlijst;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


//Basis loader net zoals de main class in  afspraaktoevoegen package het zal de FXMLBoekelijst.fxml gaan laden
public class AfsprakenLijstMain extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLAfsprakenLijst.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
