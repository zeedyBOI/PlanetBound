package Logic.States;

import Logic.Data.GameData;

import java.util.Scanner;

public class OnPlanet extends Adapter {
    public OnPlanet(GameData data) {
        super(data);
        startExploration();
    }

    private void startExploration() {
        getData().cleanSpots();
        getData().setTerrainSpots();
        getData().printTerrain();
        String resourceMined = scanMine();
    }




    //!private void scanMine() {
    private String scanMine() {
        Scanner kb = new Scanner(System.in);
        do {

        }while();
    }

    @Override
    public IState returnToOrbit() {
        return new InOrbit(getData());
    }


}
