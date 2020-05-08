package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.awt.*;

public class PaneOrganizer3 {

    HBox root;
    Button btnGreen;
    Button btnBlue;

    public PaneOrganizer3() {
        createObjects();
        setOnView();
        setListener();
    }

    private void createObjects() {
        root = new HBox();
        btnGreen = new Button("Green");
        btnBlue = new Button("Blue");
    }

    private void setListener() {
        btnGreen.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                root.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
            }
        });

        btnBlue.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                root.setBackground(new Background(new BackgroundFill(Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY)));
            }
        });
    }

    private void setOnView() {
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(btnGreen, btnBlue);
    }

    public Pane getRoot() {
        return root;
    }
}
