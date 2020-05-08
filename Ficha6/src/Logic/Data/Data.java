package Logic.Data;


import java.util.HashMap;
import java.util.Map;

public class Data {
    Map<Integer, Player> players;
    int[][] gameBoard;
    int currentPlayer = -1;

    public Data() {
        players = new HashMap<>();
        gameBoard = new int[3][3];
    }

    public boolean addPlayer(int pNum, String pName, char p) {
        if((players.put(pNum ,new Player(pName, p))) != null)
            return true;
        return false;
    }

    public Player getPlayer(int num) {
        return players.get(num);
    }

    public boolean play(int pNum, int xx, int yy) {
        if(spaceValid(xx, yy))
            return getPlayer(pNum).getPieces().add(new Piece(xx, yy, getPlayer(pNum).getPieceLetter()));
        return false;
    }

    public boolean spaceValid(int xx, int yy) {
        if(gameBoard[xx][yy] == ' ')
            return true;
        return false;
    }
}
