package Logic;

import Logic.Data.GameData;
import Logic.States.Beginning;
import Logic.States.IState;

public class StateChanger {
    private GameData data;
    private IState currentState;

    public StateChanger() {
        this.data = new GameData();
        this.currentState = new Beginning(getData());
    }

    public GameData getData() {
        return data;
    }

    public IState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(IState currentState) {
        this.currentState = currentState;
    }

    public boolean sectorHasSS() {
        return getData().hasSS();
    }

    public void start() {
        setCurrentState(getCurrentState().start());
    }

    public void selectShip() {
        setCurrentState(getCurrentState().selectShip());
    }

    public void nextTurn() {
        setCurrentState(getCurrentState().nextTurn());
    }

    public void returnToOrbit() {
        setCurrentState(getCurrentState().returnToOrbit());
    }

    public void landOnPlanet() {
        setCurrentState(getCurrentState().landOnPlanet());
    }

    public void explore() {
        setCurrentState(getCurrentState().explore());
    }

    public void visitSS() {
        setCurrentState(getCurrentState().visitSS());
    }

    public void exit() {
        setCurrentState(getCurrentState().exit());
    }

}
