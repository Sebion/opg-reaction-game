package sample.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ScoreboardController extends Controller {
    @FXML
    private Button backButton;


    @FXML
    public void on_back_button_pressed(){

        goBack(backButton.getScene());
    }
}
