package Logic.States;

import Logic.Data.GameData;
import Logic.Data.Military;
import Logic.Data.Mining;
import Logic.Data.Ship;

import java.util.Map;

public class VisitSS extends Adapter {
    public VisitSS(GameData data) {
        super(data);
    }

    private Map<String, Integer> getShipResources() {
        return getData().getResourcesInShip();
    }

    public boolean convertResources(String from, String to) {
        return getData().convertResources(from, to);
    }

    public boolean enoughResourcesToHire() {
        if(getData().getCrewMembers() < 6)
            return haveEnoughResources(1, 1, 1, 1);
        return false;
    }

    public void hireCrewMember() {
        getData().hireCrew();
    }

    public boolean enoughResourcesToUpgradeSpace() {
        return haveEnoughResources(3, 3, 3, 3);
    }

    public void upgradeCargoSpace() {
        Ship pShip = getPlayerShip();
        if (pShip instanceof Mining) {
            if (getData().getCargoSpacePerResource() < 24) {
                getData().upgradeCargoSpace();
            }
        } else {
            if (getData().getCargoSpacePerResource() < 12) {
                getData().upgradeCargoSpace();
            }
        }
    }

    public boolean enoughResourcesToBuyDrone() {
        return haveEnoughResources(2, 2, 2, 2);
    }

    public void purchaseMiningDrone() {
        getData().purchaseDrone();
    }

    public boolean enoughResourcesToUpgradeWeapons() {
        return haveEnoughResources(2, 2, 2, 2);
    }

    public void upgradeWeapons() {
        getData().upgradeWeapons();
    }

    private boolean haveEnoughResources(int r, int g, int b, int black) {
        if(getData().getResourceQuantityInShip("RED") < r)
            return false;
        if(getData().getResourceQuantityInShip("GREEN") < g)
            return false;
        if(getData().getResourceQuantityInShip("BLUE") < b)
            return false;
        return getData().getResourceQuantityInShip("BLACK") >= black;
    }

    private void spendResources(int r, int g, int b, int black) {

    }

    public void convertToFuel() {
        if(enoughResourcesForFuel()) {
            getData().removeResourcesFromShip(1, "RED");
            getData().removeResourcesFromShip(1, "BLUE");
            getData().removeResourcesFromShip(1, "BLACK");
        }
    }

    public boolean enoughResourcesForFuel() {
        return haveEnoughResources(1, 0, 1, 1);
    }

    public void convertToAmmo() {
        if(enoughResourcesForAmmo()) {
            getData().removeResourcesFromShip(1, "RED");
            getData().removeResourcesFromShip(1, "BLACK");
        }
    }

    public boolean enoughResourcesForAmmo() {
        return haveEnoughResources(1, 0, 0, 1);
    }

    public void convertToShield() {
        if(enoughResourcesForShield()) {
            getData().removeResourcesFromShip(1, "GREEN");
            getData().removeResourcesFromShip(1, "BLUE");
            getData().removeResourcesFromShip(1, "BLACK");
        }
    }

    public boolean enoughResourcesForShield() {
        return haveEnoughResources(0 ,1, 1, 1);
    }

    @Override
    public IState returnToOrbit() {
        getSector().setAlreadyVisitedSS();
        return new InOrbit(getData());
    }
}
