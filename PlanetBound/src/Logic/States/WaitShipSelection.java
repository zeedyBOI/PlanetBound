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
    public IState selectShip() {
        int opt = showShipOptions();
        if(opt == 1) {
            getData().setPlayerShip(new Mining("Mining ship"));
            return new InOrbit(getData());
        }
        if(opt == 2)
            getData().setPlayerShip(new Military("Military Ship"));
        return this;
    }

    private int showShipOptions() {
        Scanner kb = new Scanner(System.in);
        System.out.println("Select your Ship:");
        System.out.println("1 - Mining Ship");
        System.out.println("2 - Military Ship");
        return kb.nextInt();
    }
}
