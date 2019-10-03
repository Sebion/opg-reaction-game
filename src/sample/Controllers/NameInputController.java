package sample.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sample.Player;

import java.net.URL;
import java.util.ResourceBundle;


public class NameInputController extends Controller implements Initializable {


    @FXML
    private TextField nicknameTextField;
    @FXML
    private Button playButton;

    static Player player;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        player = new Player();
    }

    @FXML
    private void on_button_play_pressed(){
        if (!nicknameTextField.getText().equals("")){
            player.setName(nicknameTextField.getText());

            goBack(playButton.getScene());
        }


    }
}
