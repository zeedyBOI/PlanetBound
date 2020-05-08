package Ex2;

import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Ellipse;

public class PaneOrganizer {
    Pane root;
    Figure fig;
    Ellipse ellipse;

    public PaneOrganizer() {
        createObjects();
        setOnView();
        setListener();
    }

    private void setListener() {
        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                fig = new Figure();
                if (mouseEvent.getX() > 0 && mouseEvent.getX() < root.getWidth() && mouseEvent.getY() > 0 && mouseEvent.getY() < root.getHeight()) {
                    fig.setInicio(mouseEvent.getX(), mouseEvent.getY());
                    ellipse = new Ellipse(fig.getCenterX(), fig.getCenterY(), fig.getRadiusX(), fig.getRadiusY());
                    ellipse.setFill(fig.getColor());
                    ellipse.setStroke(Color.BLUE);
                    root.getChildren().add(ellipse);
                }
            }
        });
        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (mouseEvent.getX() > 0 && mouseEvent.getX() < root.getWidth() && mouseEvent.getY() > 0 && mouseEvent.getY() < root.getHeight()) {
                    fig.setFim(mouseEvent.getX(), mouseEvent.getY());
                    ellipse.setCenterX(fig.getCenterX());
                    ellipse.setCenterY(fig.getCenterY());
                    ellipse.setRadiusX(fig.getRadiusX());
                    ellipse.setRadiusY(fig.getRadiusY());
                }
            }
        });
    }

    private void setOnView() {
        //root.setCenter(drawPane);
        //root.setTop(panelCores);
        //root.setBottom(panelTools);
    }

    private void createObjects() {
        //TODO:ellipse = new Ellipse();//!DIMENSIONS
        root = new Pane();
        fig = new Figure();
    }

    public Pane getRoot() {
        return root;
    }
}
