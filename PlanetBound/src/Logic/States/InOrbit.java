package Logic.States;

import Logic.Data.GameData;
import Logic.Data.RedSector;
import Logic.Data.Ship;
import Logic.Data.WhiteSector;

import javax.swing.*;

public class InOrbit extends Adapter {
    enum Events {
        CREW_DEATH,
        SALVAGE_SHIP,
        CARGO_LOSS,
        FUEL_LOSS,
        NO_EVENT,
        SHIP_RESCUE
    };

    public InOrbit(GameData data) {
        super(data);
        createNewSector();
    }

    private void applyEvent() {
        applyEvent(getData().randomD6());
    }

    private void applyEvent(int idEvent) {
        Ship.Officers[] off = Ship.Officers.values();
        Events[] e = Events.values();
        System.out.println(e[idEvent - 1]);
        switch (idEvent) {
            case 1:
                System.out.println("Your " + off[getData().getCrewMembers() - 1] + " died");
                getData().killCrew();
                break;
            case 2:
                int n = getData().randomD6();
                String color = getData().getRandomColor();
                System.out.println("You found " + n + " of " + color + "resource");
                getData().addResourceToShip(n, color);
                break;
            case 3:
                System.out.println("You lost " + getData().loseResourcesInShip());
                break;
            case 4:
                System.out.println("You lost fuel");
                getData().loseFuel();
                break;
            case 5:
                break;
            case 6:
                if(getData().hireCrew())
                    System.out.println("You found a " + off[getData().getCrewMembers()] + "in a destroyed ship");
                else
                    System.out.println("You found a ship but didnt have space to receive the officer");
                break;
        }
    }

    private void goToNextSector() {
        if(!getData().inWinCondition() || getData().getCrewMembers() > 0) {
            createNewSector();
            getData().loseFuel();
        }
        if(getData().inWinCondition() || getData().getCrewMembers() == 0)
            exit();
    }

    private void createNewSector() {
        int x = (int)(Math.random() * 10);
        if(x <= 3)
            getData().setCurrentSector(new RedSector());
        else
            getData().setCurrentSector(new WhiteSector());
    }

    @Override
    public IState nextTurn() {
        applyEvent();
        goToNextSector();
        return new InOrbit(getData());
    }

    @Override
    public IState visitSS() {
        return new VisitSS(getData());
    }

    @Override
    public IState landOnPlanet() {
        if(getData().getMineAttemptsLeft() > 0)
            return new OnPlanet(getData());
        return this;
    }

    @Override
    public IState exit() {
        return new GameOver(getData());
    }
}
