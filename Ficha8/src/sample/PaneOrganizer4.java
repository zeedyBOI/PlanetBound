package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class PaneOrganizer4 {
    BorderPane root;
    HBox centerPane;
    HBox bottomPane;
    Button btnGreen;
    Button btnBlue;

    Label lbGreen;
    int nGreen = 0;

    Label lbBlue;
    int nBlue = 0;

    public PaneOrganizer4() {
        createObjects();
        setOnView();
        setListener();
    }

    private void createObjects() {
        root = new BorderPane();
        centerPane = new HBox(10);
        bottomPane = new HBox(10);
        btnGreen = new Button("Green");
        btnBlue = new Button("Blue");
        lbGreen = new Label("nGreen: " + nGreen);
        lbBlue = new Label("nBlue: " + nBlue);
    }

    private void setListener() {
        btnGreen.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                root.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
                lbGreen.setText("nGreen: "+ ++nGreen);
            }
        });

        btnBlue.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                root.setBackground(new Background(new BackgroundFill(Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY)));
                lbBlue.setText("nBlue: + nBlue");

            }
        });
    }

    private void setOnView() {
        centerPane.setAlignment(Pos.CENTER);
        root.setCenter(centerPane);
        root.setBottom(bottomPane);
        centerPane.getChildren().addAll(btnGreen, btnBlue);
        bottomPane.getChildren().addAll(lbBlue, lbGreen);
    }

    public Pane getRoot() {
        return root;
    }
}
