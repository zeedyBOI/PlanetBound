package Ex5_w_Interface.Logic.Restaurantes;

import Ex5_w_Interface.Interfaces.MenuGeral;
import Ex5_w_Interface.Interfaces.MenuItaliano;
import Ex5_w_Interface.Logic.PublicidadeGastronomica;

public class Italia implements MenuItaliano, MenuGeral {
    protected static final String nome = "Italia";
    protected final String[] MENUS_BASE_GERAIS = {
                "Lulas recheadas com presunto", 
                "Leite creme"};
    protected final String[] MENUS_BASE_ITALIANOS = {
                "Lasanha dourada com mozarella", 
                "Lasanha do mar", 
                "Tiramisu"};
        
    public Italia(PublicidadeGastronomica agenciaPub)
    {
        agenciaPub.addRestaurante(this);         
    }
        
    //...
    
    @Override
    public boolean equals(Object o)
    {
        if(o == null)
            return false;
        
        if(!(o instanceof Italia))
            return false;
        
        return nome.equalsIgnoreCase(((Italia)o).getNome());
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
    public String getNome() {
        return null;
    }
}