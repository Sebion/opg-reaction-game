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

        setSceneTo(nameField.getScene(),player);
    }

    @FXML
    public  void on_submitButton_pressed(){

        if (!nameField.getText().equals(null)){
            player.setName(nameField.getText());
        }


    }


    void setSceneTo(Scene scene, Player player) {
        Stage stage = (Stage) scene.getWindow();
        changeScene(stage, FXMLPATH.MAIN_MENU, Constants.APP_NAME);
    }
    private void changeScene(Stage stage, String fxml, String title) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
        try {
            Parent root = loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle(title);
            stage.setResizable(false);
            stage.show();
            MainMenuController mainMenuController = loader.getController();
            mainMenuController.onCreate(player);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
