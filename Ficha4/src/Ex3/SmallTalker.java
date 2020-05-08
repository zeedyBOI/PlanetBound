package Ex3;

public class SmallTalker extends SIMCard {
    final double CALL_COST_PER_MIN = 0.2;

    public SmallTalker(int num) {
        this(num, 0);
    }

    public SmallTalker(int num, double money) {
        super(num, money);
    }

    @Override
    Double calCost(int min) {
        return CALL_COST_PER_MIN * min;
    }


}
