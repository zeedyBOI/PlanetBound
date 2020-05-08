package Ex5_w_Interface.Logic.Restaurantes;
import Ex5_w_Interface.Interfaces.*;
import Ex5_w_Interface.Logic.PublicidadeGastronomica;

public class BurgerKing implements MenuFastFood, MenuVegetariano {
    protected String nome = "Burger King";
    protected static String [] MENUS_BASE_FAST_FOOD = {
            "FishBurger",
            "ChickenBurger", 
            "Tarte de maca com gelado"};
    protected static String [] MENUS_BASE_VEGETARIANOS = {
            "BeanBurger", 
            "TofuBerger", 
            "Sorvete de maca"};
        
    public BurgerKing(PublicidadeGastronomica agenciaPub)
    {             

            //...
        throw new UnsupportedOperationException("TODO Falta implementar."); // TODO : Falta implementar
    }
        
    //...
      
    public String [] getMenusVegetarianos()
    {
        return MENUS_BASE_VEGETARIANOS;
    }
    
    @Override
    public boolean equals(Object o)
    {
        if(o == null)
            return false;
        
        if(!(o instanceof Restaurante))
            return false;
        
        return nome.equalsIgnoreCase(((Restaurante)o).getNome());
    }

    @Override
    public String[] getMenusFastFood() {
        return MENUS_BASE_FAST_FOOD;
    }

    @Override
    public String getNome() {
        return null;
    }
}