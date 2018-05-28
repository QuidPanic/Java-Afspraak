package afspraken.systeem.ui.klanttoevoegen;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class KlantToevoegenMain extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("FXMLKlantToevoegen.fxml"));
        primaryStage.setTitle("Klant Toevoegen");
        primaryStage.setScene(new Scene(root));
        primaryStage.sizeToScene();
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
