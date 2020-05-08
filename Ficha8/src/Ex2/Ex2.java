package Ex2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Ex2 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(new PaneOrganizer().getRoot(), 400, 350);
        primaryStage.setTitle("Ficha 9 ex");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
