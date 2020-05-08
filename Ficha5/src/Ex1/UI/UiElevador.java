package Ex1.UI;

import java.util.Scanner;
import Ex1.Logic.*;
import Ex1.Logic.States.Andar2;
import Ex1.Logic.States.RC;


public class UiElevador {

    MaqElevador elevador;
    boolean end = false;

    public UiElevador(MaqElevador elevador) {
        this.elevador = elevador;
    }

    public void run() {
        while (!end) {
            esperaBotao();
        }
    }

    private void esperaBotao() {
        System.out.println("### Elevador");
        System.out.println("Estou no " + elevador.getAndar());
        System.out.println("NClicks " + elevador.getNClicks());
        Scanner sc = new Scanner(System.in);
        
        if(!(elevador.getEstado() instanceof RC))
            System.out.println("D - Down");
        if(!(elevador.getEstado() instanceof Andar2))
            System.out.println("U - Up");
        
        System.out.println("E - Error");
        System.out.println("S - Safe Key");
        System.out.println("Q - Quit");
        System.out.print("Insira a opção: ");

        String op = sc.next();
        char c = op.charAt(0);
        
        switch (c) {
            case 'U':
                elevador.up();
                break;
            case 'D':
                elevador.down();
                break;
            case 'E':
                elevador.erro();
                break;
            case 'S':
                elevador.safeKey(1234);
                break;
            case 'Q':
                end = true;
                break;
        }
    }
}
