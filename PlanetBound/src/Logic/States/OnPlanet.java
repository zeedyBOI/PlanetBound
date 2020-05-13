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
        getData().spawnResource();
        getData().setTerrainSpots();
        String resourceMined = scanMine();
        getData().putResourceInDrone(resourceMined);
    }

    private String scanMine() {
        Scanner kb = new Scanner(System.in);
        getData().spawnAlien();
        do {
            System.out.println(getData().printTerrain());
            getData().move(kb.next().toUpperCase().charAt(0), 'D');
            if(getData().isAlienNextToDrone()) {
                getData().fight();
                getData().spawnAlien();
            }
            System.out.println(getData().printTerrain());
            getData().moveAlien();
            System.out.println(getData().printTerrain());
            if(getData().isAlienNextToDrone()) {
                getData().fight();
                getData().spawnAlien();
            }
            if(getData().droneAtResource()) {
                getData().putResourceInDrone(getData().getResourceOnTerrain());
                getData().setDroneReadyToLeave();
            }
        }while(!getData().isDroneReadyToReturnToShip() && !getData().droneAtSpawn());
        return getData().emptyDrone();
    }

    @Override
    public IState returnToOrbit() {
        getData().addResourceToShip(getData().emptyDrone());
        return new InOrbit(getData());
    }


}
