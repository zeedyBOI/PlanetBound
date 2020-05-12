package Logic.States;

import Logic.Data.GameData;

public class GameOver extends Adapter{
    public GameOver(GameData data) {
        super(data);
    }

    private boolean won() {
        return getData().inWinCondition();
    }

    @Override
    public IState start() {
        return new Beginning(getData());
    }
}
