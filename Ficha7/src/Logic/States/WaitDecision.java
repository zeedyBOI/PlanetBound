package Logic.States;

import Logic.Data.Ball;
import Logic.Data.BlackBall;
import Logic.Data.GameData;
import Logic.Data.WhiteBall;

public class WaitDecision extends Adapter {
    public WaitDecision(GameData data) {
        super(data);
    }

    @Override
    public IState bet() {
        return bet(0);
    }

    @Override
    public IState bet(int nBalls) {
        if(!bagIsEmpty()) {
            if (haveEnoughPoints(nBalls)) {
                Ball b = takeBall();
                if (nBalls == 0) {
                    if (b instanceof WhiteBall) {
                        addPoint((WhiteBall) b);
                        showMessage(1);
                    } else {
                        showMessage(0);
                        removeBlackFromGame((BlackBall) b);
                    }
                    return new WaitDecision(getData());
                } else {
                    if (b instanceof WhiteBall) {
                        addPoint((WhiteBall) b);
                        for (int i = 0; i < nBalls; i++) {
                            addPoint(new WhiteBall());
                        }
                        showMessage(nBalls + 1);
                        return new WaitDecision(getData());
                    } else
                        return new LostBet(getData());
                }
            }
            return new WaitDecision(getData());
        }
        return new GameOver(getData());
    }

    @Override
    public IState exit() {
        return new GameOver(getData());
    }

    private boolean haveEnoughPoints(int nBalls) {
        if(getData().getPoints() >= nBalls)
            return true;
        System.out.println("NOT ENOUGH POINTS");
        return false;
    }

    private void addPoint(WhiteBall b) {
        getData().addPoint(b);
    }

    private void removeBlackFromGame(BlackBall b) {
        getData().addToBlackRemoved(b);
    }
}
