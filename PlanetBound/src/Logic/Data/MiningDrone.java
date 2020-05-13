package Logic.Data;

public class MiningDrone {
    private boolean health;
    private int armor;
    private boolean readyToLeavePlanet;
    private int spawnX, spawnY;
    private String resourceMined;

    public MiningDrone() {
        this.health = true;
        this.armor = 6;
        this.readyToLeavePlanet = false;
        this.spawnX = this.spawnY = -1;
    }

    protected void setPos(int xx, int yy) {
        setSpawnX(xx);
        setSpawnY(yy);
    }

    protected int getSpawnX() {
        return spawnX;
    }

    private void setSpawnX(int spawnX) {
        this.spawnX = spawnX;
    }

    protected int getSpawnY() {
        return spawnY;
    }

    private void setSpawnY(int spawnY) {
        this.spawnY = spawnY;
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

    protected String getResourceMined() {
        setResourceMined(null);
        return resourceMined;
    }

    protected void setResourceMined(String resourceMined) {
        this.resourceMined = resourceMined;
    }

    @Override
    public String toString() {
        return "MiningDrone{" +
                "alive=" + health +
                ", armor=" + armor +
                '}';
    }
}
