package sample.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import sample.Constants;
import sample.FXMLPATH;
import sample.Player;



public class MainMenuController extends Controller {

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


    public void onCreate(Player player) {
        this.player = player;
        this.player.setName(player.getName());
        this.player.setHighScore(player.getHighScore());

        System.out.println(player.getName()+"menoooooo"+welcomeLabel.getText());
        welcomeLabel.setText("Welcome "+player.getName()+" !");

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
