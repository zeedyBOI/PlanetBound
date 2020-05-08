package sample;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class PaneOrganizer5 {
    BorderPane root;
    HBox centerPane;
    HBox bottomPane;
    Button btnGreen;
    Button btnBlue;

    Label lbGreen;
    int nGreen = 0;

    Label lbBlue;
    int nBlue = 0;

    MyButton btnYellow;
    MyButton btnBlack;
    MyButton btnWhite;

    public PaneOrganizer5() {
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
        btnYellow = new MyButton("Yellow", Color.YELLOW);
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
        btnYellow.addSetOnAction();
    }

    private void setOnView() {
        centerPane.setAlignment(Pos.CENTER);
        root.setCenter(centerPane);
        root.setBottom(bottomPane);
        centerPane.getChildren().addAll(btnGreen, btnBlue);
        centerPane.getChildren().add(btnYellow);
        bottomPane.getChildren().addAll(lbBlue, lbGreen);
        bottomPane.getChildren().add(btnYellow.getLabel());
    }

    public Pane getRoot() {
        return root;
    }

    class MyButton extends Button implements EventHandler<ActionEvent> {

        int nClicks = 0;
        Label label = null;
        Color color;
        Background background;

        public MyButton(String label, Color color) {
            super(label);
            this.color = color;
            this.background = new Background(new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY));
        }

        public Label getLabel() {
            if(label == null)
                label = new Label(this.getText() + ": " + nClicks);
            return label;
        }

        public void addSetOnAction() {
            this.setOnAction(this);
        }

        @Override
        public void handle(ActionEvent actionEvent) {
            ((Pane)this.getParent()).setBackground(background);
            if(label != null)
                label.setText(this.getText() + ": " + ++nClicks);
        }
    }
}
