package Logic.States;

import Logic.Data.GameData;
import Logic.Data.RedSector;
import Logic.Data.WhiteSector;

public class InOrbit extends Adapter {
    public InOrbit(GameData data) {
        super(data);
        createNewSector();
    }

    private void applyEvent() {
        applyEvent(getData().randomD6());
    }

    private void applyEvent(int idEvent) {
        switch (idEvent) {
            case 1:
                getData().killCrew();
                break;
            case 2:
                getData().addResourceToShip(getData().randomD6(), getData().getRandomColor());
                break;
            case 3:
                getData().loseResourcesInShip();
                break;
            case 4:
                getData().loseFuel();
                break;
            case 5:
                break;
            case 6:
                getData().hireCrew();
                break;
        }
    }

    private void goToNextSector() {
        if(!getData().inWinCondition() || getData().getCrewMembers() > 0)
            createNewSector();
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
