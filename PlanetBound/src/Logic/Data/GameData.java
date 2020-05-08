package Logic.Data;

import java.util.List;
import java.util.Map;

public class GameData {
    private Ship playerShip;
    private Sector currentSector;

    public GameData() {
    }

    public int randomD6() {
        return (int)(1 + Math.random() * 6);
    }

    public Ship getPlayerShip() {
        return playerShip;
    }

    public int getCargoSpacePerResource() {
        return getPlayerShip().getCargoSpacePerResource();
    }

    public void addCargoSpace() {
        getPlayerShip().addCargoSpace();
    }

    public void setPlayerShip(Ship playerShip) {
        this.playerShip = playerShip;
    }

    public Sector getCurrentSector() {
        return currentSector;
    }

    public boolean hasSS() {
        return getCurrentSector().hasSpaceStation();
    }

    public void setCurrentSector(Sector nextSector) {
        this.currentSector = nextSector;
    }

    public void createNewSector() {
        int x = (int)(Math.random() * 10);
        if(x <= 3)
            setCurrentSector(new RedSector());
        else
            setCurrentSector(new WhiteSector());
    }

    public boolean inWinCondition() {
        return getPlayerShip().haveAllArtifacts();
    }

    public Planet getPlanet() {
        return getCurrentSector().getPlanet();
    }

    public void hireCrew() {
        getPlayerShip().addCrewMember();
    }

    public void killCrew() { getPlayerShip().killCrewMember(); }

    public char[][] getTerrain() {
        return getPlanet().getTerrain();
    }

    public List<String> getResourcesAvailableOnPlanet() {
        return getPlanet().getResourcesAvailable();
    }

    public String listResourcesAvailableOnPlanet() {
        return getPlanet().listResources();
    }

    public int getResourceQuantityInShip(String resource) {
        return getPlayerShip().getResourceQuantity(resource);
    }

    public Map<String, Integer> getResourcesInShip() {
        return getPlayerShip().getResources();
    }

    public void purchaseDrone() {
        getPlayerShip().newMiningDrone();
    }

    public void upgradeWeapons() {
        getPlayerShip().upgradeWeapons();
    }

    public void upgradeCargoSpace() {
        getPlayerShip().addCargoSpace();
    }

    public void cleanSpots() {
        resetTerrain();
    }

    private void setSpot(int x, int y, char i) {
        setPosOnTerrain(x, y, i);
    }

    public void setTerrainSpots() {
        int Sx = randomD6();
        int Sy = randomD6();
        int Dx, Dy, Ax, Ay;
        do {
            Dx = randomD6();
            Dy = randomD6();
            Ax = randomD6();
            Ay = randomD6();
        }while(Dx == Sx && Dy == Sy || Dx == Ax && Dy == Ay || Ax == Sx && Ay == Sy);
        setSpot(Sx, Sy, 'S');
        setSpot(Dx, Dy, 'D');
        setSpot(Ax, Ay, 'A');
    }

    public void resetTerrain() {
        getPlanet().cleanTerrain();
    }

    public void setPosOnTerrain(int x, int y, char icon) {
        getPlanet().setPos(x, y, icon);
    }

    public void move(char key_pressed, char icon) {
        switch (key_pressed) {
            case 'W':
                moveUp(icon);
                break;
            case 'S':
                moveDown(icon);
                break;
            case 'A':
                moveLeft(icon);
                break;
            case 'D':
                moveRight(icon);
                break;
            default:
                break;
        }
    }

    public void moveDown(char icon) {
        getPlanet().moveDown(icon);
    }

    public void moveLeft(char icon) {
        getPlanet().moveLeft(icon);
    }

    public void moveUp(char icon) {
        getPlanet().moveUp(icon);
    }

    public void moveRight(char icon) {
        getPlanet().moveRight(icon);
    }

    public String printTerrain() {
        return getPlanet().printTerrain();
    }
}
