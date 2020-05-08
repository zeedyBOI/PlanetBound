package Ex3;

import java.util.*;
public abstract class SIMCard {
    private int number;
    private double balance;
    private Map<Integer, List<Call>> registry;
    private List<Call> calls;

    public SIMCard(int num) {
        this(num, 0);
    }

    public SIMCard(int number, double money) {
    this.number = number;
    balance = money;
    calls = new ArrayList<>();
    registry = new HashMap<>();
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    void recharge(double money) {
        balance += money;
    }

    boolean numberAlreadyExists(int number) {
        Set<Integer> keys = registry.keySet();
        for (Integer num : keys) {
            if(num == number) {
                return true;
            }
        }
        return false;
    }

    void addCallR(int number, int min) {
        if(numberAlreadyExists(number)) {
            registry.get(number).add(new Call(min, 0));
        }
        else {
            List<Call> call = new ArrayList<>();
            call.add(new Call(min, 0));
            registry.put(number, call);
        }
    }

    void addCall(int number, int min) {
        if(posBalance()) {
            if(numberAlreadyExists(number)) {
                registry.get(number).add(new Call(min, calCost(min)));
            }
            else {
                List<Call> call = new ArrayList<>();
                call.add(new Call(min, calCost(min)));
                registry.put(number, call);
            }
            setBalance(balance - calCost(min));
        }
    }

    boolean posBalance() {
        if(getBalance() > 0)
            return true;
        return false;
    }
    
    private String getRegistry() {
        StringBuilder sb = new StringBuilder();
        for (Integer key: registry.keySet()) {
            sb.append(key).append(registry.get(key).toString());
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return "SIMCard" +
                "\nnumber=" + number +
                "\nbalance=" + balance +
                "\nregistry=" + getRegistry() +
                '}';
    }

    abstract Double calCost(int min);
}
