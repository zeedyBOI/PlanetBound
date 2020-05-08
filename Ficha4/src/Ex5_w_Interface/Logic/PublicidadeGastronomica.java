package Ex5_w_Interface.Logic;

import Ex5_w_Interface.Interfaces.*;
import java.util.List;

public class PublicidadeGastronomica
{
    protected List <MenuGeral> menusGerais;
    protected List <MenuDieta> menusDieta;
    protected List <MenuFastFood> menusFastFood;
    protected List <MenuItaliano> menusItalianos;
    protected List <MenuVegetariano> menusVegetarianos;
    
    public PublicidadeGastronomica()
    {
        //...
        throw new UnsupportedOperationException("TODO Falta implementar."); // TODO : Falta implementar
    }
    
    public void addRestaurante(Restaurante restaurante)
    {
        
        if(restaurante == null)
            return;
            
        if(restaurante instanceof MenuGeral)
            addGeral((MenuGeral)restaurante);
        
        if(restaurante instanceof MenuDieta)
            addDieta((MenuDieta)restaurante);
        
        if(restaurante instanceof MenuFastFood)
            addFastFood((MenuFastFood)restaurante);
        
        if(restaurante instanceof MenuItaliano)
            addItaliano((MenuItaliano)restaurante);
        
        if(restaurante instanceof MenuVegetariano)
            addVegetariano((MenuVegetariano)restaurante);                

    }
    
    public boolean addGeral(MenuGeral restaurante)
    {                 
        if(restaurante == null)
            return false;
        
        if(restaurante.getMenusGerais().length > 0 && !menusGerais.contains(restaurante)){
            menusGerais.add(restaurante);
            return true;
        }
        return false;
    }
    
    public boolean addDieta(MenuDieta restaurante)
    {                    
        //...
        throw new UnsupportedOperationException("TODO Falta implementar."); // TODO : Falta implementar
    }
    
    public boolean addFastFood(MenuFastFood restaurante)
    {                    
       //...
        throw new UnsupportedOperationException("TODO Falta implementar."); // TODO : Falta implementar
    }
    
    public boolean addItaliano(MenuItaliano restaurante)
    {                    
        //...
        throw new UnsupportedOperationException("TODO Falta implementar."); // TODO : Falta implementar
    }
    
    public boolean addVegetariano(MenuVegetariano restaurante)
    {                    
        //...
        throw new UnsupportedOperationException("TODO Falta implementar."); // TODO : Falta implementar
    }
    
    public String divulgaGerais()
    {
        String s = "Menus gerais:";
    
        for(MenuGeral r:menusGerais){
            
            s += "\r\n\r\n\t" + r.getNome() + ": ";
            
            for(String m:r.getMenusGerais())
                s += "\r\n\r\n\t\t" + m.toString();
        
        }
        
        return s;
    }
    
    public String divulgaDietas()
    {
        //...
        throw new UnsupportedOperationException("TODO Falta implementar."); // TODO : Falta implementar
    }
    
    public String divulgaFastFood()
    {
        //...
        throw new UnsupportedOperationException("TODO Falta implementar."); // TODO : Falta implementar
    }
    
    public String divulgaItalianos()
    {
        //...
        throw new UnsupportedOperationException("TODO Falta implementar."); // TODO : Falta implementar
    }
    
    public String divulgaVegetarianos()
    {
        //...
        
        throw new UnsupportedOperationException("TODO Falta implementar."); // TODO : Falta implementar
    }

     
    
}