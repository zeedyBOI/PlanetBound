package Ex5_w_Interface.Logic.Restaurantes;

import Ex5_w_Interface.Interfaces.*;
import Ex5_w_Interface.Logic.PublicidadeGastronomica;

public class GaleriaSabores implements MenuGeral, MenuVegetariano, MenuDieta, MenuItaliano {
    protected static final String nome = "Galeria dos sabores";
    protected final String[] MENUS_BASE_GERAIS = {
                "Bifes de peru com molho de cenoura", 
                "Bacalhau com natas", 
                "Salmao grelhado", 
                "Arroz doce"};
    protected final String[] MENUS_BASE_VEGETARIANOS = {
                "Empadao de tofu", 
                "Requeijao com molho de ervas e mel", 
                "Sorvete de maca"};
    protected final String[] MENUS_BASE_DIETA = {
                "Salada meditarranica", 
                "Salada nicoise", 
                "Maca acada"};
    protected final String[] MENUS_BASE_ITALIANOS = {
                "Tagliateli a la carbonara", 
                "Risoto de legumes", 
                "Gelado de cafe"};
    
    public GaleriaSabores(PublicidadeGastronomica agenciaPub)
    {
         //...        
         throw new UnsupportedOperationException("TODO Falta implementar."); // TODO : Falta implementar
   }
        
    //...
    
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
    public String[] getMenusDieta() {
        return new String[0];
    }

    @Override
    public String[] getMenusGerais() {
        return new String[0];
    }

    @Override
    public String[] getMenusItalianos() {
        return new String[0];
    }

    @Override
    public String[] getMenusVegetarianos() {
        return new String[0];
    }

    @Override
    public String getNome() {
        return null;
    }
}