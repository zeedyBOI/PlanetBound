package UI;

import Logic.StateMac;
import Logic.States.IState;
import Logic.States.LostBet;

import java.util.Scanner;

public class UIStateMachine {
    StateMac machine;
    boolean shutdown = false;

    public UIStateMachine(StateMac machine) {
        this.machine = machine;
    }

    public void waitStart() {
        Scanner kb = new Scanner(System.in);
        do {
            showStart();
            int x = kb.nextInt();
            switch (x) {
                case 1:
                    shutdown = false;
                    start();
                    break;
                case 2:
                    return;
            }
        }while(true);
    }

    private void start() {
        machine.start();
        while(!shutdown) {
            waitInput();
        }
        return;
    }

    private void showStart() {
        System.out.println("1-Start Game");
        System.out.println("2-Exit Game");
        System.out.print("Option: ");
    }

    private void waitInput() {
        int b;
        IState afterState;
        Scanner kb = new Scanner(System.in);
        showOptions();
        switch (kb.nextInt()) {
            case 1:
                System.out.println("How many balls you want to bet: ");
                do {
                    b = kb.nextInt();
                }while(b < 0);
                machine.bet(b);
                if(machine.getCurrentState() instanceof LostBet) {
                    lostBetOptions();
                    switch (kb.nextInt()) {
                        case 1:
                            machine.remove1WhiteFromPoints();
                            break;
                        case 2:
                            machine.remove2FromBag();
                            break;
                    }
                }
                return;
            case 2:
                machine.bet();
                return;
            case 3:
                machine.exit();
                shutdown = true;
                return;
        }
    }

    private void showOptions() {
        System.out.println("You have " + machine.getPoints() + " point(s)!");
        System.out.println("1-Bet");
        System.out.println("2-Just take ball");
        System.out.println("3-Quit Game");
        System.out.print("Option: ");
    }

    private void lostBetOptions() {
        System.out.println("1-Remove 1 point");
        System.out.println("2-Take 2 from the bag");
        System.out.print("Option: ");
    }
}
