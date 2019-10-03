package sample.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import sample.Constants;
import sample.FXMLPATH;
import sample.Player;

import javax.naming.Name;
import java.net.URL;
import java.util.ResourceBundle;


public class MainMenuController extends Controller implements Initializable {

    private Player player = new Player();

    @FXML
    private Label welcomeLabel;
    @FXML
    private Button playButton;
    @FXML
    private Button changePlayerButton;
    @FXML
    private Button scoreboardButton;
    @FXML
    private Button quitButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.player= NameInputController.player;
        welcomeLabel.setText("Welcome "+ player.getName()+" !");
    }

    @FXML
    public void play_button_pressed() {
        setSceneTo(playButton.getScene(), FXMLPATH.PLAY, Constants.PLAY_TITLE);
    }

    @FXML
    public void changePlayer_button_pressed() {
        setSceneTo(playButton.getScene(), FXMLPATH.CHANGE_PLAYER, Constants.CHANGE_PLAYER_TITLE);
    }

    @FXML
    public void scoreboard_button_pressed() {
        setSceneTo(playButton.getScene(), FXMLPATH.SCOREBOARD, Constants.SCOREBOARD_TITLE);
    }

    @FXML
    public void quit_button_pressed() {
        System.exit(1);
    }
}
