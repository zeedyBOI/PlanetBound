package Logic.Data;

import java.util.ArrayList;
import java.util.List;

public class Player {
    final int NPIECES = 3;
    String name;
    char pieceLetter;
    List<Piece> pieces;
    int piecesLeft = NPIECES;

    public Player(String name, char pieceLetter) {
        this.name = name;
        this.pieceLetter = pieceLetter;
        pieces = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Piece> getPieces() {
        return pieces;
    }

    public char getPieceLetter() {
        return pieceLetter;
    }

    public void setPieceLetter(char pieceLetter) {
        this.pieceLetter = pieceLetter;
    }

    public int getPiecesLeft() {
        return piecesLeft;
    }

    public void setPiecesLeft(int piecesLeft) {
        this.piecesLeft = piecesLeft;
    }

    public int getNpieces() {
        return NPIECES;
    }
}