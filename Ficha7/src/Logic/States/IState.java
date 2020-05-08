package Logic.States;

public interface IState {
    IState start();
    IState exit();
    IState bet();
    IState bet(int nBalls);
    IState remove2FromBag();
    IState remove1WhiteFromPoints();
}
