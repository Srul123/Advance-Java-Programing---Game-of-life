package israel.heiblum.maman12_ex2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;


/**
 * @ Maman 12 - EX2
 * @author Israel Heiblum 301823555
 */


public class GameOfLifeApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GameOfLifeApplication.class.getResource("game-of-life-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Maman 12 EX2 - Game of Life");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}