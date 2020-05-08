package Ex1.Logic.States;

import Ex1.Logic.Data.*;

public class Andar2 extends Adapter{

    //String name = "Andar 2";

    public Andar2(EDados dados) {
        super("Andar 2", dados);
    }

    @Override
    public IEstado up() {
        getDados().click();
        return this;
    }

    @Override
    public IEstado down() {
        getDados().click();
        return new Andar1(getDados());
    }

    /*@Override
    public String getName() {
        return name;
    }*/
        
    @Override
    public boolean canGoDown(){
        return true;
    }
    
    @Override
    public IEstado erro(){
        return new EstadoErro(getDados(), this);
    }
}
