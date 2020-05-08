package Logic;

import Logic.Data.GameData;
import Logic.States.Adapter;
import Logic.States.Beginning;
import Logic.States.IState;
import Logic.States.WaitDecision;

public class StateMac {
    GameData data;
    IState currentState;

    public StateMac() {
        data = new GameData();
        this.currentState = new Beginning(getData());
    }

    public GameData getData() {
        return data;
    }

    public void setData(GameData data) {
        this.data = data;
    }

    public IState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(IState currentState) {
        this.currentState = currentState;
    }

    public void start() {
        setCurrentState(currentState.start());
    }

    public void exit() {
        setCurrentState(currentState.exit());
    }

    public void bet() {
        setCurrentState(currentState.bet(0));
    }

    public void bet(int n) {
        setCurrentState(currentState.bet(n));
    }

    public void remove2FromBag() {
        setCurrentState(currentState.remove2FromBag());
    }

    public void remove1WhiteFromPoints() {
        setCurrentState(currentState.remove1WhiteFromPoints());
    }

    public int getPoints() {
        return getData().getPoints();
    }
}
