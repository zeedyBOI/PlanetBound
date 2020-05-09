package Logic.Data;
import Logic.Data.GameData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Planet {
    private final String color;
    private final char[][] terrain;
    private final List<String> resourcesAvailable;
    private String resourceOnTerrain;
    private int miningAttemptsRemaining;
    private String alienType;

    public Planet() {
        resourcesAvailable = new ArrayList<>();
        this.color = pickColor();
        terrain = new char[6][6];
        cleanTerrain();
    }

    private String pickColor() {
        int x = (int)(Math.random() * 100);
        if(x < 25) {
            resourcesAvailable.add("RED");
            resourcesAvailable.add("GREEN");
            setMiningAttemptsRemaining(2);
            return "GREEN";
        }
        else if(x > 25 && x < 50) {
            resourcesAvailable.add("BLACK");
            resourcesAvailable.add("BLUE");
            setMiningAttemptsRemaining(2);
            return "BLACK";
        }
        else if(x > 50 && x < 75) {
            resourcesAvailable.add("RED");
            resourcesAvailable.add("BLUE");
            setMiningAttemptsRemaining(2);
            return "RED";
        }
        else {
            resourcesAvailable.add("BLACK");
            resourcesAvailable.add("GREEN");
            resourcesAvailable.add("BLUE");
            resourcesAvailable.add("PINK");
            setMiningAttemptsRemaining(4);
            return "BLUE";
        }
    }

    protected int getMiningAttemptsRemaining() {
        return miningAttemptsRemaining;
    }

    private void setMiningAttemptsRemaining(int miningAttemptsRemaining) {
        this.miningAttemptsRemaining = miningAttemptsRemaining;
    }

    protected void minedOnce() {
        this.miningAttemptsRemaining--;
    }

    protected String getColor() {
        return color;
    }

    protected char[][] getTerrain() {
        return terrain;
    }

    protected void setPos(int xx, int yy, char icon) {
        this.terrain[xx][yy] = icon;
    }

    protected List<String> getResourcesAvailable() {
        return resourcesAvailable;
    }

    protected String getResourceOnTerrain() {
        return resourceOnTerrain;
    }

    protected void setResourceOnTerrain() {
        Collections.shuffle(getResourcesAvailable());
        this.resourceOnTerrain = getResourcesAvailable().get(0);
    }

    public String getAlienType() {
        return alienType;
    }

    public void setAlienType() {
        int x = (int)(Math.random() * 100);
        if(x < 25)
            this.alienType = "BLACK";
        if(x < 50)
            this.alienType = "GREEN";
        if(x < 75)
            this.alienType = "BLUE";
        this.alienType = "RED";
    }

    protected void cleanTerrain() {
        for (int i = 0; i < terrain.length; i++) {
            for (int j = 0; j < terrain[i].length; j++) {
                terrain[i][j] = '_';
            }
        }
    }

    protected int getPosX(char icon) {
        for (int i = 0; i < terrain.length; i++) {
            for (int j = 0; j < terrain[i].length; j++) {
                if(terrain[i][j] == icon)
                    return i;
            }
        }
        return -1;
    }

    protected int getPosY(char icon) {
        for (int i = 0; i < terrain.length; i++) {
            for (int j = 0; j < terrain[i].length; j++) {
                if(terrain[i][j] == icon)
                    return j;
            }
        }
        return -1;
    }

    protected void moveDown(char icon) {
        int x = getPosX(icon);
        int y = getPosY(icon);
        setPos(x, y, '_');
        setPos(++x, y, icon);
    }

    protected void moveLeft(char icon) {
        int x = getPosX(icon);
        int y = getPosY(icon);
        setPos(x, y, '_');
        setPos(x, --y, icon);
    }

    protected void moveUp(char icon) {
        int x = getPosX(icon);
        int y = getPosY(icon);
        setPos(x, y, '_');
        setPos(--x, y, icon);
    }

    protected void moveRight(char icon) {
        int x = getPosX(icon);
        int y = getPosY(icon);
        setPos(x, y, '_');
        setPos(x, ++y, icon);
    }

    protected String listResources() {
        StringBuilder sb = new StringBuilder();
        for (String r : resourcesAvailable) {
            sb.append(r).append('\n');
        }
        return sb.toString();
    }

    public String printTerrain() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < terrain.length; i++) {
            for (int j = 0; j < terrain[i].length; j++) {
                sb.append(terrain[i][j]);
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return "Planet{" +
                "color='" + color + '\'' +
                "Resources" + listResources() +
                '}';
    }
}
