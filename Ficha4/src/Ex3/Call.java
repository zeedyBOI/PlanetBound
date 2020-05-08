package Ex3;

public class Call {
    int min;
    double cost;

    public Call(int min, double cost) {
        this.min = min;
        this.cost = cost;
    }

    public int getMin() {
        return min;
    }

    public double getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "Call{" +
                "min=" + min +
                ", cost=" + cost +
                '}';
    }
}
