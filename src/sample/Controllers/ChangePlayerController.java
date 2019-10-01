package sample.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sample.Player;

public class ChangePlayerController extends Controller{

    private Player player;
    @FXML
    private Button backButton;

    @FXML
    private Button submitButton;

    @FXML
    private TextField nameField;


    @FXML
    public void on_back_button_pressed(){

        goBack(backButton.getScene());
    }

    @FXML
    public  void on_submitButton_pressed(){

        if (!nameField.getText().equals(null)){
            player.setName(nameField.getText());
        }


    }

}
