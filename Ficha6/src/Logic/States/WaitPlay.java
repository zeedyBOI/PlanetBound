package Logic.States;

import Logic.Data.Data;

public class WaitPlay extends Adapter {
    public WaitPlay(Data data) {
        super(data);
    }

    @Override
    public State putPiece(int pNum, int xx, int yy) {
        getData().play(pNum, xx, yy);
    }


    @Override
    public State quit(int pNum) {
        return null;
    }
}
