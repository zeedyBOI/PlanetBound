package Logic.States;

public interface State{
    State defineNames(int pNum, String pName, char p);
    State startGame();
    State putPiece(int pNum, int xx, int yy);
    State returnPiece(int pNum, int xx, int yy);
    State quit(int pNum);
}
