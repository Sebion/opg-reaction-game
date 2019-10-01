package sample.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import sample.Constants;

public class PlayController extends Controller {

    @FXML
    private Button backButton;
    @FXML
    private Button gameButton;


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

        });

    }


}
