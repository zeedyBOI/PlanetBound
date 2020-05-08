package F4.Ex5IntF.Incompleto;

import F4.Ex5IntF.Incompleto.Interfaces.Restaurante;
import F4.Ex5IntF.Incompleto.Restaurantes.BurgerKing;
import F4.Ex5IntF.Incompleto.Restaurantes.GaleriaSabores;
import F4.Ex5IntF.Incompleto.Restaurantes.Italia;


public class Main
{
    public static void main(String args[])
    {
        PublicidadeGastronomica pub = new PublicidadeGastronomica();
                        
        Restaurante ri = new Italia(pub);
        Restaurante rbk = new BurgerKing(pub);
        Restaurante rgs = new GaleriaSabores(pub);                
                
        System.out.println();
        System.out.println();
        System.out.println(pub.divulgaGerais());
        
        System.out.println();
        System.out.println();
        System.out.println(pub.divulgaDietas());
        
        System.out.println();
        System.out.println();
        System.out.println(pub.divulgaFastFood());
        
        System.out.println();
        System.out.println();
        System.out.println(pub.divulgaItalianos());
        
        System.out.println();
        System.out.println();
        System.out.println(pub.divulgaVegetarianos());
    }
}