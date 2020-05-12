package Logic.States;

public interface IState {
    IState start();
    IState selectShip(int opt);
    IState nextTurn();
    IState returnToOrbit();
    IState landOnPlanet();
    IState explore();
    IState visitSS();
    IState exit();
}
