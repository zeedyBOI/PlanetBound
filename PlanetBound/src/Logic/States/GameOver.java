package Logic.States;

import Logic.Data.GameData;

public class GameOver extends Adapter{
    public GameOver(GameData data) {
        super(data);
    }

    public boolean won() {
        return getData().inWinCondition();
    }

    public void reason() {
        if(getData().getFuel() == 0)
            System.out.println("You ran out of fuel!");
        if(getData().getCrewMembers() == 0)
            System.out.println("All your crew died!");
    }

    @Override
    public IState start() {
        return new Beginning(getData());
    }
}
