package Logic.States;

import Logic.Data.GameData;

public class InOrbit extends Adapter {
    public InOrbit(GameData data) {
        super(data);
    }

    public void applyEvent() {
        applyEvent(getData().randomD6());
    }

    public void applyEvent(int idEvent) {
        switch (idEvent) {
            case 1:
                getData().killCrew();
                break;
            case 2:
                getData().addResourceToShip(getData().randomD6(), getData().getRandomResource());
                break;
            case 3:

                break;
            case 4:
                //TODO:Fuel Loss
                break;
            case 5:
                //TODO:No Event
                break;
            case 6:
                //TODO:Crew Rescue
                break;
        }
    }

    public void goToNextSector() {
        if(!getData().inWinCondition())
            getData().createNewSector();
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
        return new OnPlanet(getData());
    }
}
