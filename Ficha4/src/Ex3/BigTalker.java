package Ex3;

public class BigTalker extends SIMCard {
    final double CALL_COST = 0.5;
    final double CALL_COST_PER_MIN = 0.02;

    public BigTalker(int num) {
        this(num, 0);
    }

    public BigTalker(int num, double money) {
        super(num, money);
    }

    @Override
    Double calCost(int min) {
        return CALL_COST + CALL_COST_PER_MIN * min;
    }
}
