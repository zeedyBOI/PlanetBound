package Ex5;

import Ex5.Logic.*;
import Ex5.Logic.Restaurantes.*;

public class Main {
    public static void main(String[] args) {
        PublicidadeGastronomica pub = new PublicidadeGastronomica();

        Restaurante ri = new Italia(pub);
        Restaurante rbk = new BurgerKing(pub);
        Restaurante rgs = new GaleriaSabores(pub);

        System.out.println();
        System.out.println(pub.divulgaGerais());

        System.out.println();
        System.out.println(pub.divulgaDietas());

        System.out.println();
        System.out.println(pub.divulgaFastFood());

        System.out.println();
        System.out.println(pub.divulgaItalianos());

        System.out.println();
        System.out.println(pub.divulgaVegetarianos());
    }
}
