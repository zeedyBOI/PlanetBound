package Logic.Data;

public class RedSector extends Sector{
    public RedSector() {
        super(true);
    }

    @Override
    public String toString() {
        return "RedSector{" +
                "withSpaceStation=" + withSpaceStation +
                planet.toString() +
                '}';
    }
}
