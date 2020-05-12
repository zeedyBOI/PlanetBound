package Logic.States;

import Logic.Data.GameData;
import Logic.Data.Sector;
import Logic.Data.Ship;

public class Adapter implements IState{
    private GameData data;

    public Adapter(GameData data) {
        this.data = data;
    }

    public GameData getData() {
        return data;
    }

    public Ship getPlayerShip() {
        return getData().getPlayerShip();
    }

    public Sector getSector() { return getData().getCurrentSector(); }

    @Override
    public IState start() {
        return this;
    }

    @Override
    public IState selectShip(int opt) {
        return this;
    }

    @Override
    public IState nextTurn() {
        return this;
    }

    @Override
    public IState returnToOrbit() {
        return this;
    }

    @Override
    public IState landOnPlanet() {
        return this;
    }

    @Override
    public IState explore() {
        return this;
    }

    @Override
    public IState visitSS() {
        return this;
    }

    @Override
    public IState exit() {
        return this;
    }
}
