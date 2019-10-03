package sample.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.FileController;
import sample.Player;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

public class ScoreboardController extends Controller implements Initializable {
    @FXML
    private Button backButton;
    private TableView tableView;
    private FileController fileController;
    private Map<String,Long> highScore;


    @FXML
    public void on_back_button_pressed(){

        goBack(backButton.getScene());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    tableView = new TableView();
    fileController = new FileController();
    highScore = fileController.read();



    ObservableList<Player> players = FXCollections.observableArrayList(
                new Player("Amos",546 ),
                new Player("Keep",5554 )
                );


        TableColumn<Player, String> column1 = new TableColumn<>("Player");
        column1.setCellValueFactory(new PropertyValueFactory<>("name"));


        TableColumn<Player, Long> column2 = new TableColumn<>("Highscore");
        column2.setCellValueFactory(new PropertyValueFactory<>("highScore"));

        tableView.setItems(players);




    }



}
