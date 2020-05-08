package Ex1;

import Ex1.Logic.MaqElevador;
import Ex1.UI.UiElevador;

public class Main {
    public static void main(String[] args) {
        MaqElevador elevador = new MaqElevador();
        UiElevador ui = new UiElevador(elevador);

        ui.run();
    }

}