package Logic.States;

import Logic.Data.Ball;
import Logic.Data.BlackBall;
import Logic.Data.GameData;

public class LostBet extends Adapter {
    public LostBet(GameData data) {
        super(data);
    }

    @Override
    public IState remove2FromBag() {
        Ball b;
        for (int i = 0; i < 2; i++) {
            b = takeBall();
            if(b instanceof BlackBall)
                addBlackToBag((BlackBall)b);
        }
        return new WaitDecision(getData());
    }

    @Override
    public IState remove1WhiteFromPoints() {
        losePoint();
        showMessage(-1);
        return new WaitDecision(getData());
    }

    private void losePoint() {
        getData().removePoint();
    }
}
