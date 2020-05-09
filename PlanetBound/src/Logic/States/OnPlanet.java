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
        getData().setResourceOnTerrain();
        getData().setTerrainSpots();
        getData().printTerrain();
        String resourceMined = scanMine();
    }




    //!private void scanMine() {
    private String scanMine() {
        Scanner kb = new Scanner(System.in);
        do {
            getData().printTerrain();
            getData().move(kb.next().charAt(0), 'D');
            getData().moveAlien();
            if(getData().isAlienNextToDrone())
                getData().fight();
            if(getData().droneAtResource()) {
                getData().putResourceInDrone(getData().getResourceOnTerrain());
                getData().setDroneReadyToLeave();
            }
        }while(getData().isDroneReadyToReturnToShip() && getData().droneAtSpawn());
        return getData().emptyDrone();
    }



    @Override
    public IState returnToOrbit() {
        return new InOrbit(getData());
    }


}
