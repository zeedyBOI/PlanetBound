package Logic.Data;

public class Piece {
    int x;
    int y;
    char p;

    public Piece() {
        this(-1, -1, 'o');
    }

    public Piece(int x, int y, char p) {
        this.x = x;
        this.y = y;
        this.p = p;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public char getP() {
        return p;
    }

    public void setP(char p) {
        this.p = p;
    }
}
