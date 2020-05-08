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

    public Map<String, Integer> getShipResources() {
        return getData().getResourcesInShip();
    }

    public boolean convertResources(String from, String to) {
        if (getData().getResourceQuantityInShip(from) > 1 && getData().getResourceQuantityInShip(to) < getData().getCargoSpacePerResource()) {
            getShipResources().replace(from, (getData().getResourceQuantityInShip(from) - 1));
            getShipResources().replace(to, (getData().getResourceQuantityInShip(to) + 1));
            return true;
        }
        return false;
    }

    public boolean hireCrewMember(String officer) {
        if(haveEnoughResources(1)){
            getData().hireCrew();
            return true;
        }
        return false;
    }

    public boolean upgradeCargoSpace() {
        Ship pShip = getPlayerShip();
        if(haveEnoughResources(2)) {
            if (pShip instanceof Mining) {
                if (getData().getCargoSpacePerResource() < 24) {
                    getData().upgradeCargoSpace();
                    return true;
                }
            } else {
                if (getData().getCargoSpacePerResource() < 12) {
                    getData().addCargoSpace();
                    return true;
                }
            }
        }
        return false;
    }

    public boolean purchaseMiningDrone() {
        if(haveEnoughResources(2)) {
            getData().purchaseDrone();
            return true;
        }
        return false;
    }

    public boolean upgradeWeapons() {
        if(haveEnoughResources(2)) {
            getData().upgradeWeapons();
            return true;
        }
        return false;
    }

    private boolean haveEnoughResources(int needed) {
        Ship pShip = getPlayerShip();
        if(getData().getResourceQuantityInShip("BLUE") < needed)
            System.out.println("Not enough blue resources");
        if(getData().getResourceQuantityInShip("RED") < needed)
            System.out.println("Not enough red resources");
        if(getData().getResourceQuantityInShip("GREEN") < needed)
            System.out.println("Not enough green resources");
        if(getData().getResourceQuantityInShip("BLACK") >= needed) {
            return true;
        }
        System.out.println("Not enough Black resources");
        return false;
    }

    @Override
    public IState returnToOrbit() {
        getSector().setAlreadyVisitedSS();
        return new InOrbit(getData());
    }
}
