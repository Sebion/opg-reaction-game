package sample.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MainMenuController {


    @FXML
    private Button playButton;
    @FXML
    private Button changePlayerButton;
    @FXML
    private Button scoreboardButton;
    @FXML
    private Button quitButton;

    @FXML
    public void play_button_pressed(){
    

    } @FXML
    public void changePlayer_button_pressed(){


    } @FXML
    public void scoreboard_button_pressed(){


    } @FXML
    public void quit_button_pressed(){


    }

    protected void setSceneTo(Scene scene) {
        Stage stage = (Stage) scene.getWindow();
        changeScene(stage, "..\\FXMLS\\Play.fxml", "Play");
    }
    void changeScene(Stage stage, String fxml, String title) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
        try {
            Parent root = loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle(title);
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }






}
