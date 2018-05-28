package afspraken.systeem.ui.afsprakenlijst;

import afspraken.systeem.ui.afspraaktoevoegen.FXMLAfspraakToevoegenController;
import afspraken.systeem.database.DatabaseDerby;
import com.jfoenix.controls.JFXButton;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;


import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;





public class FXMLAfsprakenLijstController implements Initializable {

    ObservableList<Afspraak> list = FXCollections.observableArrayList(); //<--- We maken hier een nieuwe arraylist met datatype Afspraak we noemen deze list.

    @FXML
    private AnchorPane rootPane;
    @FXML
    private TableView<Afspraak> tableView;
    @FXML
    private TableColumn<Afspraak, String> behandelingColumn;
    @FXML
    private TableColumn<Afspraak, String> afspraakDatumColumn;
    @FXML
    private TableColumn<Afspraak, String> afspraakIdColumn;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initCol();
        LoadData();

    }

    private void initCol() {
        behandelingColumn.setCellValueFactory(new PropertyValueFactory<>("behandeling"));
        afspraakDatumColumn.setCellValueFactory(new PropertyValueFactory<>("afspraakDatum"));
        afspraakIdColumn.setCellValueFactory(new PropertyValueFactory<>("afspraakId"));
    }

    private void LoadData() {
        DatabaseDerby derby = new DatabaseDerby();
        String qu = "SELECT * FROM AFSPRAAK";
        ResultSet rs = derby.execQuery(qu);
        try {
            while (rs.next()) {
                String behandeling = rs.getString("behandeling");
                String datum = rs.getString("afspraakDatum");
                String afspraakId = rs.getString("id");

               list.add(new Afspraak(behandeling, datum, afspraakId)); //<-- Observable ArrayList de bovenstaande queries worden aan de list toegevoegd

            }
        } catch (SQLException ex) {
            Logger.getLogger(FXMLAfspraakToevoegenController.class.getName()).log(Level.SEVERE, null, ex);
        }
        tableView.getItems().setAll(list);
    }


    public static class Afspraak {
        private final SimpleStringProperty behandeling;
        private final SimpleStringProperty afspraakDatum;
        private final SimpleStringProperty afspraakid;

        Afspraak(String behandeling, String afspraakDatum, String afspraakid) {
            this.behandeling = new SimpleStringProperty(behandeling);
            this.afspraakDatum = new SimpleStringProperty(afspraakDatum);
            this.afspraakid = new SimpleStringProperty(afspraakid);
        }
        //Getters
        public String getBehandeling() {
            return behandeling.get();
        }

        public String getAfspraakDatum() {
            return afspraakDatum.get();
        }
        public String getAfspraakId(){ return afspraakid.get();
        }

    }


}






