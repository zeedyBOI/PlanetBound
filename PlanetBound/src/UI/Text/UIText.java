package UI.Text;

import Logic.Data.GameData;
import Logic.Data.Military;
import Logic.StateChanger;
import Logic.States.*;

import java.util.Scanner;

public class UIText {
    StateChanger machine;
    boolean shutdown = false;
    Scanner kb;

    public UIText(StateChanger machine) {
        this.machine = machine;
        kb = new Scanner(System.in);
    }

    public void start() {
        machine.start();
        showShipOptions();
        do {
            listOptions();
        }while(!shutdown);
    }

    private void showShipOptions() {
        System.out.println("Select your ship:");
        System.out.println("1 - Mining Ship");
        System.out.println("2 - Military Ship");
        System.out.print("Option: ");
        int x;
        do{
            x = kb.nextInt();
        }while(x < 1 || x > 2);
        machine.selectShip(x);
        ((InOrbit) machine.getCurrentState()).createNewSector();
    }

    public void listOptions() {
        if(machine.getCurrentState() instanceof OnPlanet) {
            ((OnPlanet) machine.getCurrentState()).startExploration();
            machine.returnToOrbit();
            return;
        }
        if(machine.getCurrentState() instanceof Beginning) {
            machine.start();
            showShipOptions();
            return;
        }
        if(machine.getCurrentState() instanceof InOrbit) {
            machine.showGameState();
            System.out.println("1 - Go to Planet and Explore it");
            System.out.println("2 - Go to Next Sector");
            if(machine.getData().hasSS()) {
                System.out.println("3 - Go to Space Station");
            }
            System.out.print("Your choice: ");
            switch (kb.nextInt()) {
                case 1:
                    machine.landOnPlanet();
                    break;
                case 2:
                    machine.nextTurn();
                    break;
                case 3:
                    if(machine.sectorHasSS()) {
                        machine.visitSS();
                        break;
                    }
                default:
                    System.out.println("Invalid Option!");
                    break;
            }
        }
        else if(machine.getCurrentState() instanceof VisitSS) {
            if(((VisitSS) machine.getCurrentState()).enoughResourcesForAmmo())
                System.out.println("1 - Make Ammo");
            else
                System.out.println("Not enough resources to convert to ammo (1 BLACK, 1 BLUE)");
            if(((VisitSS) machine.getCurrentState()).enoughResourcesForFuel())
                System.out.println("2 - Make Fuel cells");
            else
                System.out.println("Not enough resources to convert to ammo (1 BLACK, 1 BLUE, 1 GREEN)");
            if(((VisitSS) machine.getCurrentState()).enoughResourcesForShield())
                System.out.println("3 - Make Shield cells");
            else
                System.out.println("Not enough resources to convert to ammo (1 BLACK, 1 BLUE, 1 GREEN)");
            if(((VisitSS) machine.getCurrentState()).enoughResourcesToHire() && machine.getData().getCrewMembers() < 6)
                System.out.println("4 - Hire Crew");
            else
                System.out.println("Not enough resources to hire crew (1 BLACK, 1 BLUE, 1 GREEN, 1 RED)");
            if(((VisitSS) machine.getCurrentState()).enoughResourcesToBuyDrone() && !machine.getData().droneIsAlive())
                System.out.println("5 - Buy new Drone");
            else
                System.out.println("Not enough resources to buy new drone (2 BLACK, 2 BLUE, 2 GREEN, 2 RED) or you dont need a new drone");
            if(((VisitSS) machine.getCurrentState()).enoughResourcesToUpgradeSpace())
                System.out.println("6 - Upgrade space in ship");
            else
                System.out.println("Not enough resources to upgrade space (3 BLACK, 3 BLUE, 3 GREEN, 3 RED)");
            if(((VisitSS) machine.getCurrentState()).enoughResourcesToUpgradeWeapons() && machine.getData().getPlayerShip() instanceof Military)
                System.out.println("7 - Upgrade Weapons");
            else
                System.out.println("Not enough resources to upgrade weapons (2 BLACK, 2 BLUE, 2 GREEN, 2 RED) or ship not eligible");
            System.out.println("8 - Return to Orbit");
            System.out.print("Your choice: ");
            switch (kb.nextInt()) {
                case 1:
                    ((VisitSS) machine.getCurrentState()).convertToAmmo();
                    break;
                case 2:
                    ((VisitSS) machine.getCurrentState()).convertToFuel();
                    break;
                case 3:
                    ((VisitSS) machine.getCurrentState()).convertToShield();
                    break;
                case 4:
                    ((VisitSS) machine.getCurrentState()).hireCrewMember();
                    break;
                case 5:
                    ((VisitSS) machine.getCurrentState()).purchaseMiningDrone();
                    break;
                case 6:
                    ((VisitSS) machine.getCurrentState()).upgradeCargoSpace();
                    break;
                case 7:
                    ((VisitSS) machine.getCurrentState()).upgradeWeapons();
                    break;
                case 8:
                    machine.returnToOrbit();
                    break;
                default:
                    System.out.println("Invalid Option!");
                    break;
            }
        }
        else if(machine.getCurrentState() instanceof GameOver) {
            if(((GameOver) machine.getCurrentState()).won()) {
                System.out.println("You reached your new Home");
            }
            else
                ((GameOver) machine.getCurrentState()).reason();
            System.out.println("1 - Restart Game");
            System.out.println("2 - Exit Game");
            switch (kb.nextInt()) {
                case 1:
                    machine.start();
                    break;
                case 2:
                    shutdown = true;
                    break;
            }

        }
    }
}
