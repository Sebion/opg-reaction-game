package sample.Controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.Constants;
import sample.FXMLPATH;
import sample.Player;

import java.io.IOException;

class Controller {

    void setSceneTo(Scene scene, String fxml, String title) {
        Stage stage = (Stage) scene.getWindow();
        changeScene(stage, fxml, title);
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

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void goBack(Scene scene){
        setSceneTo(scene, FXMLPATH.MAIN_MENU, Constants.APP_NAME);
    }

    public void createNewScene(String fxml, String title, Player player, float highScore) {
        Stage stage =  new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
        try {
            Parent root = loader.load();
            Scoreboard10Controller scoreboard10Controller = loader.getController();
            scoreboard10Controller.onCreate(player, highScore);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle(title);
            stage.setResizable(false);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}