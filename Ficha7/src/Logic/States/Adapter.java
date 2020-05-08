package Logic.States;

import Logic.Data.Ball;
import Logic.Data.BlackBall;
import Logic.Data.GameData;

public class Adapter implements IState {
    GameData data;

    public Adapter(GameData data) {
        this.data = data;
    }

    public GameData getData() {
        return data;
    }

    public Ball takeBall() {
        Ball b = getData().getRandomBall();
        return b;
    }

    public void addBlackToBag(BlackBall b) {
        getData().addToBag(b);
    }

    public boolean bagIsEmpty() {
        return getData().isEmpty();
    }

    protected void showMessage(int p) {
        if(p == 1)
            System.out.println("YOU TOOK A WHITE BALL! YOU RECEIVE 1 POINT!");
        if(p == 0)
            System.out.println("YOU TOOK A BLACK BALL :c");
        if(p > 1)
            System.out.println("YOU TOOK A WHITE BALL! YOU RECEIVE" + p + " POINTS!");
        if(p == -1)
            System.out.println("YOU LOST 1 POINT :c");
    }

    @Override
    public IState start() {
        return this;
    }

    @Override
    public IState exit() {
        return this;
    }

    @Override
    public IState bet() {
        return bet(0);
    }

    @Override
    public IState bet(int nBalls) {
        return this;
    }

    @Override
    public IState remove2FromBag() {
        return this;
    }

    @Override
    public IState remove1WhiteFromPoints() {
        return this;
    }
}
