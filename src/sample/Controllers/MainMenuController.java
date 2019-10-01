package sample.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import sample.Constants;
import sample.FXMLPATH;
import sample.Player;

import javax.xml.soap.Text;

public class MainMenuController extends Controller {

    private Player player;

    @FXML
    private Text welcomeText;

    @FXML
    private Button playButton;
    @FXML
    private Button changePlayerButton;
    @FXML
    private Button scoreboardButton;
    @FXML
    private Button quitButton;

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
