package Logic.States;

import Logic.Data.GameData;

public class GameOver extends Adapter {
    public GameOver(GameData data) {
        super(data);
        showPoints();
    }

    private void showPoints() {
        System.out.println("YOU FINISHED WITH " + getData().getPoints() + "!");
    }

    @Override
    public IState start() {
        return new Beginning();
    }
}
