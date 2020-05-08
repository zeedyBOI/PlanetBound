package Ex3;

import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MobileCo {
    String name;
    Set<SIMCard> cards;

    MobileCo(String name) {
        this.name = name;
        cards = new HashSet<>();
    }

    private String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public boolean addCard(int num) {
        addCard(num, 0);
        return true;
    }

    public boolean addCard(int num, double money) {
        do {
            switch (pickPlan()) {
                case 1:
                    cards.add(new SmallTalker(num, money));
                    return true;
                case 2:
                    cards.add(new BigTalker(num, money));
                    return true;
                default:
                    System.out.println("Plan not recognized!");
                    break;
            }
        }while(true);
    }

    public boolean removeCard(int num) {
        SIMCard x;
        if((x = searchCard(num)) != null) {
            return cards.remove(x);
        }
        return false;
    }

    private int pickPlan() {
        System.out.println("1 - Small Talker");
        System.out.println("2 - Big Talker");
        System.out.print("Option:");
        Scanner kb = new Scanner(System.in);
        return kb.nextInt();
    }

    public boolean addBalance(int num, double money) {
        SIMCard x;
        if((x = searchCard(num)) != null) {
            x.recharge(money);
            return true;
        }
        return false;
    }

    public boolean regCall(int n_from, int n_to, int min) {
        SIMCard nF, nT;
        if((nF = searchCard(n_from)) != null && (nT = searchCard(n_to)) != null) {
            nF.addCall(n_to, min);
            nT.addCallR(n_from, min);
            return true;
        }
        return false;
    }

    private SIMCard searchCard(int num) {
        for (SIMCard c: cards) {
            if(num == c.getNumber())
                return c;
        }
        return null;
    }

    private boolean cardExists(int number) {
        return cards.contains(number);
    }

    public double checkBalance(int num) {
        SIMCard x;
        if((x = searchCard(num)) != null) {
            return x.getBalance();
        }
        else
            System.out.println("Card doesnt exist!");
            return 0;
    }

    public String getCardData(int num) {
        return searchCard(num).toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("######################");
        sb.append("MobileCo named" + name + " with the cards by natural order: \n");
        for (SIMCard sc : cards) {
            sb.append(sc.getNumber()).append("\n");
        }
        return sb.toString();
    }

    public String toStringNumericOrder() {
        int m = 0;
        SIMCard x = null;
        Set<SIMCard> ts = new HashSet<>(cards);
        StringBuilder sb = new StringBuilder();
        sb.append("######################");
        sb.append("MobileCo named" + name + " with the cards by numeric order: \n");
        for (SIMCard sc : ts) {
            for (SIMCard c : ts) {
                if(sc.getNumber() > m) {
                    x = sc;
                    m = sc.getNumber();
                }
            }
            ts.remove(x);
            sb.append(sc.getNumber()).append("\n");
        }
        return sb.toString();
    }

    public String toStringBalanceOrder() {
        int m = 0;
        SIMCard x = null;
        Set<SIMCard> ts = new HashSet<>(cards);
        StringBuilder sb = new StringBuilder();
        sb.append("######################");
        sb.append("MobileCo named" + name + " with the cards by balance order: \n");
        for (SIMCard sc : ts) {
            for (SIMCard c : ts) {
                if(sc.getBalance() > m) {
                    x = c;
                    m = sc.getNumber();
                }
            }
            ts.remove(x);
            sb.append(sc.getNumber()).append("\n");
        }
        return sb.toString();
    }
}