import Logic.Data.*;
import Logic.StateChanger;
import Logic.States.IState;
import Logic.States.InOrbit;
import Logic.States.OnPlanet;
import UI.Text.UIText;

public class Main {
    public static void main(String[] args) {
        StateChanger machine = new StateChanger();
        UIText ui = new UIText(machine);
        ui.start();
    }
}
