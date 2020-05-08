package Logic.States;

import Logic.Data.Data;

public class WaitStart extends Adapter {
    public WaitStart(Data data) {
        super(data);
    }

    @Override
    public State defineNames(int pNum, String pName, char p) {
        if((getData().addPlayer(pNum, pName, p)) == true)
            System.out.println("Player " + pNum + ": " + pName + "added!");
        else
            System.out.println("ERROR PLAYER NOT ADDED!");
        return this;
    }

    @Override
    public State startGame() {
        return new WaitPlay(getData());
    }
}
