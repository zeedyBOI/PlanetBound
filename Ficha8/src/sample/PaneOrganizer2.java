package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class PaneOrganizer2 {

    StackPane root = new StackPane();
    Button btn;

    public PaneOrganizer2() {
        createObjects();
        setOnView();
        setListener();
    }

    private void createObjects() {
        root = new StackPane();
        btn = new Button("Say Hello World");
    }

    private void setListener() {
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Hello World!");
            }
        });
    }

    private void setOnView() {
        root.getChildren().add(btn);
    }

    public Pane getRoot() {
        return root;
    }
}
