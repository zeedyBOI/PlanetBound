package Logic.States;

import Logic.Data.GameData;

import java.util.Scanner;

public class OnPlanet extends Adapter {
    public OnPlanet(GameData data) {
        super(data);
    }

    public void startExploration() {
        getData().cleanSpots();
        getData().spawnResource();
        getData().setTerrainSpots();
        scanMine();
        System.out.println(getData().addResourceToShip(getData().getResourceMined()));
        getData().emptyDrone();
    }

    private void scanMine() {
        boolean a = false;
        boolean b = false;
        boolean moved;
        Scanner kb = new Scanner(System.in);
        getData().spawnAlien();
        do {
            System.out.println(getData().printTerrain());
            do {
                moved = getData().move(kb.next().toUpperCase().charAt(0), 'D');
            } while (!moved);
            System.out.println(getData().printTerrain());
            if(getData().isAlienNextToDrone()) {
                getData().fight();
                getData().spawnNewAlien();
            }
            getData().moveAlien();
            System.out.println(getData().printTerrain());
            if(getData().isAlienNextToDrone()) {
                getData().fight();
                getData().spawnNewAlien();
            }
            if (getData().droneAtResource()) {
                getData().putResourceInDrone(getData().getResourceOnTerrain());
                getData().setDroneReadyToLeave();
            }
            if (getData().droneAtSpawn())
                if(getData().isDroneReadyToReturnToShip())
                    return;
        }while(true);
        //return getData().emptyDrone();
    }

    @Override
    public IState returnToOrbit() {
        return new InOrbit(getData());
    }


}
