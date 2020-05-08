package Ex2;


import javafx.scene.paint.Color;

public class Figure {
    double x1, y1, x2, y2;
    Color color;

    public Figure() {
        x1 = y1= x2 = y2 = -1;
        color = new Color(Math.random(), Math.random(), Math.random(), Math.random());
    }

    public Color getColor() {
        return color;
    }

    public void setInicio(double x, double y) {
        this.x1 = x;
        this.y1 = y;
        this.x2 = x;
        this.y2 = y;
    }

    public void setFim(double x, double y) {
        this.x2 = x;
        this.y2 = y;
    }

    public double getCenterX() { return (x1 + x2) / 2; }

    public double getCenterY() { return (y1 + y2) / 2; }

    public double getRadiusX() { return Math.abs(x2 - x1)/2; }

    public double getRadiusY() { return Math.abs(y2 - y1)/2; }
}
