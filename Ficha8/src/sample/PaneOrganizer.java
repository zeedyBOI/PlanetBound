package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class PaneOrganizer {

    StackPane root = new StackPane();

    public PaneOrganizer() {
        Button btn = new Button();
        btn.setText("Say Hello World");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Hello World!");
            }
        });

        root.getChildren().add(btn);
    }

    public Pane getRoot() {
        return root;
    }
}
