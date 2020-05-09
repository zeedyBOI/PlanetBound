package Logic.States;

import Logic.Data.GameData;

public class Beginning extends Adapter {
    public Beginning(GameData data) {
        super(data);
    }

    @Override
    public IState start() {
        return new WaitShipSelection(getData());
    }
}