package Logic.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameData {
    static int NBALLS = 10;
    List<Ball> bag;
    List<WhiteBall> points;
    List<WhiteBall> whiteBallsRemoved;
    List<BlackBall> blackBallsRemoved;

    public GameData() {
        bag = new ArrayList<>();
        points = new ArrayList<>();
        whiteBallsRemoved = new ArrayList<>();
        blackBallsRemoved = new ArrayList<>();
        for (int i = 0; i < NBALLS; i++) {
            bag.add(new WhiteBall());
            bag.add(new BlackBall());
        }
    }

    public Ball getRandomBall() {
        Collections.shuffle(bag);
        Ball b = bag.remove(0);
        return b;
    }

    public int getPoints() {
        return points.size();
    }

    public void addToBag(Ball b) {
        bag.add(b);
    }

    public void addPoint(WhiteBall b) {
        points.add(b);
    }

    public void addToBlackRemoved(BlackBall b) {
        blackBallsRemoved.add(b);
    }

    public void removePoint() {
        points.remove(0);
    }

    public boolean isEmpty() {
        if(bag.isEmpty())
            return true;
        return false;
    }
}
