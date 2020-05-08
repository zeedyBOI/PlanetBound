package Logic.States;

import Logic.Data.GameData;

public class Beginning extends Adapter{

    public Beginning() {
        super(new GameData());
    }

    public Beginning(GameData data) {
        super(data);
    }

    @Override
    public IState start() {
        return new WaitDecision(getData());
    }

    @Override
    public IState exit() {
        return new GameOver(getData());
    }
}
