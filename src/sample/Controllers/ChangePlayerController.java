package sample.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Constants;
import sample.FXMLPATH;
import sample.Player;

import java.io.IOException;

public class ChangePlayerController extends Controller{

    private Player player =new Player();
    @FXML
    private Button backButton;

    @FXML
    private Button submitButton;

    @FXML
    private TextField nameField;


    @FXML
    public void on_back_button_pressed(){

       goBack(nameField.getScene());
    }

    @FXML
    public  void on_submitButton_pressed(){

        if (!nameField.getText().equals("")){
            NameInputController.player.setName(nameField.getText());
            goBack(nameField.getScene());
        }


    }




}
