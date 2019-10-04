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
import java.util.*;

public class ScoreboardController extends Controller implements Initializable {
    @FXML
    private Button backButton;

    @FXML
    private TableView<Player> scoreTable;
    @FXML
    private TableColumn<Player, String> player;
    @FXML
    private TableColumn<Player, Long> highScore;


    private FileController fileController;
    private ArrayList<Player> highScoreMap;


    @FXML
    public void on_back_button_pressed() {

        goBack(backButton.getScene());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        fileController = new FileController();
        highScoreMap = fileController.read();
        ArrayList<Player> top10 = new ArrayList<>();
        Collections.sort(highScoreMap);

        for (int i = 0;i <10; i++) {
            top10.add(highScoreMap.get(i));
        }
        System.out.println(highScoreMap);


        player.setCellValueFactory(new PropertyValueFactory<>("name"));
        highScore.setCellValueFactory(new PropertyValueFactory<>("highScore"));
        ObservableList<Player> players = FXCollections.observableArrayList(top10);


        scoreTable.setItems(players);


    }


}
