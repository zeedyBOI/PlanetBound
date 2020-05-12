package Logic.States;

import Logic.Data.GameData;
import Logic.Data.Military;
import Logic.Data.Mining;

import java.util.Scanner;

public class WaitShipSelection extends Adapter{
    public WaitShipSelection(GameData data) {
        super(data);
    }

    @Override
    public IState selectShip(int opt) {
        if(opt == 1) {
            getData().setPlayerShip(new Mining());
            return new InOrbit(getData());
        }
        if(opt == 2)
            getData().setPlayerShip(new Military());
        return new InOrbit(getData());
    }
}
