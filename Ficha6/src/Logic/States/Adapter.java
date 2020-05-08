package Logic.States;

import Logic.Data.Data;

public class Adapter implements State {
    private Data data;

    public Adapter(Data data) {
        this.data = data;
    }

    public Data getData() {
        return data;
    }

    @Override
    public State defineNames(int pNum, String pName, char p) {
        return this;
    }

    @Override
    public State startGame() {
        return this;
    }

    @Override
    public State putPiece(int pNum, int xx, int yy) {
        return this;
    }

    @Override
    public State returnPiece(int nP, int xx, int yy) {
        return this;
    }

    @Override
    public State quit(int nP) {
        return this;
    }
}
