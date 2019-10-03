package sample.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import sample.Constants;
import sample.FileController;
import sample.Player;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class PlayController extends Controller implements Initializable {

    @FXML
    private Button backButton;
    @FXML
    private Button gameButton;

    private FileController fileController;
    private Player player;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        fileController=new FileController();
        player=NameInputController.player;
    }

    @FXML
    public void on_back_button_pressed() {

        goBack(backButton.getScene());
    }


    @FXML
    public void on_play_button_pressed() {
        long waitTime = (long) (Math.random() * 2500 + 500);
        gameButton.setText("Steady!");


        long curTime = System.currentTimeMillis();
        while (System.currentTimeMillis() <= curTime + waitTime) {


        }
        gameButton.setText("Press me!");
        long startTime = System.currentTimeMillis();

        gameButton.setOnAction((event) -> {
            gameButton.setDisable(true);

            long finalTime = System.currentTimeMillis() - startTime;
            if (finalTime<3){
                gameButton.setText("Cheater!");
            }else
            gameButton.setText(String.valueOf(finalTime));
            fileController.write(player.getName(),String.valueOf(finalTime));
        });

    }


}
