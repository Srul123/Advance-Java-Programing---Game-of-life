package israel.heiblum.maman12_ex2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;


/**
 * @ Maman 12 - EX2
 * @author Israel Heiblum 301823555
 */


public class GameOfLifeController {
    boolean isInit = false;
    GameOfLife life;

    @FXML
    private Button button;

    @FXML
    private Canvas canvas_cover;

    @FXML
    public void initialize() {
        button.setStyle("-fx-background-color: #40B5E7");
        GraphicsContext graphics = canvas_cover.getGraphicsContext2D();
        life = new GameOfLife(10, 10, graphics);
    }

    @FXML
    void nextGen(ActionEvent event) {
        if(!isInit) {
            life.init();
            button.setText("Click to calculate the next generation");
            button.setStyle("-fx-background-color: #5EBA7D");
            isInit = true;
        } else {
            life.nextStep();
        }

    }

}
