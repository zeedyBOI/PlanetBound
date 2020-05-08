package Logic.Data;

public class MiningDrone {
    private boolean health;
    private int armor;
    private boolean readyToLeavePlanet;

    public MiningDrone() {
        this.health = true;
        this.armor = 6;
        this.readyToLeavePlanet = false;
    }

    protected boolean isAlive() {
        return health;
    }

    protected void setDestroyed() {
        this.health = false;
    }

    protected int getArmor() {
        return armor;
    }

    protected void takeDamage() {
        this.armor--;
    }

    protected void refillArmor() {
        this.armor = 6;
    }

    protected boolean isReadyToLeavePlanet() {
        return readyToLeavePlanet;
    }

    protected void readyToLeavePlanet() {
        this.readyToLeavePlanet = true;
    }

    protected void notReadyToLeavePlanet() {
        this.readyToLeavePlanet = false;
    }
}
