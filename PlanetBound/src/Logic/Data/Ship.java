package Logic.Data;

import java.util.*;

public abstract class Ship {

    enum Officers {
        CAPTAIN,
        NAVIGATION,
        EXPLORATION,
        CARGO_HOLD,
        WEAPONS,
        SHIELDS
    }

    private int cargoSpacePerResource;
    private int fuel;
    private int shield;
    private int ammo;
    private int weaponDamage;
    private int crewMembers;
    private int artifacts;
    private MiningDrone drone;
    private Map<String, Integer> resources;

    public Ship(int cargoSpace, int fuel, int shield, int ammo) {
        this.cargoSpacePerResource = cargoSpace;
        this.fuel = fuel;
        this.shield = shield;
        this.ammo = ammo;
        this.weaponDamage = 1;
        this.crewMembers = 6;
        this.artifacts = 0;
        this.drone = new MiningDrone();
        resources = new HashMap<>();
    }

    protected int getCargoSpacePerResource() {
        return cargoSpacePerResource;
    }

    protected void addCargoSpace() {
        this.cargoSpacePerResource += 6;
    }

    protected int getFuel() {
        return fuel;
    }

    protected void addFuel(int fuel) {
        this.fuel += fuel;
    }

    protected void remove1Fuel () { this.fuel--; }

    protected int getShield() {
        return shield;
    }

    protected void addShield(int shield) {
        this.shield += shield;
    }

    protected int getAmmo() {
        return ammo;
    }

    protected void addAmmo(int ammo) {
        this.ammo += ammo;
    }

    protected int getWeaponDamage() {
        return weaponDamage;
    }

    protected void upgradeWeapons() {
        this.weaponDamage++;
    }

    protected int getCrewMembers() {
        return crewMembers;
    }

    protected void addCrewMember() {
        if(getCrewMembers() < 6)
            this.crewMembers++;
    }

    protected void killCrewMember() {
        this.crewMembers--;
    }

    protected int getArtifacts() {
        return artifacts;
    }

    protected void addArtifacts() {
        this.artifacts++;
    }

    protected boolean haveAllArtifacts() {
        return getArtifacts() == 5;
    }

    protected void setDroneSpawnPos(int x, int y) {
        getMiningDrone().setPos(x, y);
    }

    protected int getDroneSpawnX() {
        return getMiningDrone().getSpawnX();
    }

    protected int getDroneSpawnY() {
        return getMiningDrone().getSpawnY();
    }

    protected MiningDrone getMiningDrone() {
        return drone;
    }

    protected boolean droneIsAlive() {
        return getMiningDrone().isAlive();
    }

    protected boolean isDroneReadyToComeBack() {
        return getMiningDrone().isReadyToLeavePlanet();
    }

    protected void setDroneReadyToLeave() {
        getMiningDrone().readyToLeavePlanet();
    }

    protected void killDrone() {
        getMiningDrone().setDestroyed();
    }

    protected void newMiningDrone() {
        this.drone = new MiningDrone();
    }

    protected String emptyDrone() {
        return getMiningDrone().getResourceMined();
    }

    protected int getDroneArmor() { return getMiningDrone().getArmor(); }

    protected void droneTakeDamage() { getMiningDrone().takeDamage(); }

    protected void refillDroneArmor() { getMiningDrone().refillArmor();}

    protected void putResourceInDrone(String resource) {
        getMiningDrone().setResourceMined(resource);
    }

    protected Map<String, Integer> getResources() {
        return resources;
    }

    protected int getResourceQuantity(String resource) {
        return resources.get(resource);
    }

    protected void addResources(int nR, String resource) {
        if(resourceInShip(resource)) {
            resources.replace(resource, (resources.get(resource) + nR));
        }
        else {
            resources.put(resource, nR);
        }
    }

    protected void removeResource(int n, String resource) {
        resources.replace(resource, (resources.get(resource)) - n);
    }

    private boolean resourceInShip(String resource) {
        return resources.containsKey(resource);
    }

    protected boolean convertResources(String from, String to) {
        if(crewMembers >= 4) {
            if (getResourceQuantity(from) > 1 && getResourceQuantity(to) < getCargoSpacePerResource()) {
                resources.replace(from, (getResourceQuantity(from) - 1));
                resources.replace(to, (getResourceQuantity(to) + 1));
                return true;
            }
            return false;
        }
        return false;
    }

    public String listCrew() {
        Officers[] off = Officers.values();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < crewMembers; i++){
            sb.append(off[i]).append(", ");
        }
        return sb.toString();
    }

    public String listResources() {
        StringBuilder sb = new StringBuilder();
        for (String r: resources.keySet()) {
            sb.append(r).append(": ").append(resources.get(r));
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return "Ship{" +
                ", cargoSpacePerResource=" + cargoSpacePerResource +
                ", fuel=" + fuel +
                ", shield=" + shield +
                ", ammo=" + ammo +
                ", crewMembers=" + crewMembers +
                ", crew=" + listCrew() +
                ", resources=" + listResources() +
                '}';
    }
}
