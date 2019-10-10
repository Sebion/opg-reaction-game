package sample.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.FileController;
import sample.Player;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class Scoreboard10Controller extends Controller {

    private static ArrayList<Player> players;

    @FXML
    private TableView<Player> tableView;
    @FXML
    private TableColumn<Player, Integer> tableColumnOrder;
    @FXML
    private TableColumn<Player, String> tableColumnPlayerName;
    @FXML
    private TableColumn<Player, Float> tableColumnScore;

    public void onCreate(Player player) {

        FileController fileController = new FileController();
        players = fileController.read();
        Collections.sort(players);
        int index = 0;
        for (int i = 0; i < players.size(); i++) {
            if(players.get(i).getName().equals(player.getName())) {
                index = i;
                break;
            } else if (player.getHighScore() > players.get(players.size() - 1).getHighScore()) {
                index = players.size();
            }
        }
        ArrayList<Player> play10 = createTHEArrayList(index, player);
        bindDataToTableView(play10);
    }

    private void bindDataToTableView(ArrayList<Player> play10) {
        tableColumnOrder.setCellValueFactory(new PropertyValueFactory("index"));
        tableColumnPlayerName.setCellValueFactory(new PropertyValueFactory("name"));
        tableColumnScore.setCellValueFactory(new PropertyValueFactory("highScore"));
        ObservableList<Player> players = FXCollections.observableList(play10);
        tableView.setItems(players);
    }

    private ArrayList<Player> createTHEArrayList(int index, Player player) {
        ArrayList<Player> players10 = new ArrayList<>();
        int detract = 5;
        int plus = 5;
        if (index < 5) {
            detract =  index;
        }
        for (int i = index - detract; i < index; i++) {
            Player playert = players.get(i);
            playert.setIndex(i+1);
            players10.add(playert);
        }
        if (index > players.size() - 5) {
            plus=players.size()-index;
        }
        player.setIndex(index + 1);
        players10.add(player);
        for (int i = index; i < index + plus; i++) {
            Player playert = players.get(i);
            playert.setIndex(i+2);
            players10.add(playert);
        }
        return players10;
    }

}
