package Logic.Data;

public abstract class Sector {
    boolean withSpaceStation;
    boolean alreadyVisitedSS;
    Planet planet;

    public Sector(boolean withSpaceStation) {
        this.withSpaceStation = withSpaceStation;
        this.alreadyVisitedSS = false;
        this.planet = new Planet();
    }

    public Planet getPlanet() {
        return planet;
    }

    public String getPlanetType() {
        return getPlanet().getColor();
    }

    public boolean alreadyVisitedSS() {
        return alreadyVisitedSS;
    }

    public void setAlreadyVisitedSS() {
        this.alreadyVisitedSS = true;
    }

    public boolean hasSpaceStation() {
        return withSpaceStation;
    }

    @Override
    public String toString() {
        return "Sector{" +
                "withSpaceStation=" + withSpaceStation +
                ", " + planet.toString() +
                '}';
    }
}
