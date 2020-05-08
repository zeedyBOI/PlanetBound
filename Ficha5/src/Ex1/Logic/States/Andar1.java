package Ex1.Logic.States;

import Ex1.Logic.Data.*;

public class Andar1 extends Adapter {
    //String name = "Andar 1";

    public Andar1(EDados dados) {
        super("Andar 1", dados);
    }

    @Override
    public IEstado up() {
        getDados().click();
        return new Andar2(getDados());
    }

    @Override
    public IEstado down() {
        getDados().click();
        return new RC(getDados());
    }

    /*
    @Override
    public String getName() {
        return name;
    }
     */
    @Override
    public boolean canGoDown() {
        return true;
    }
    
    @Override
    public boolean canGoUp(){
        return true;
    }
    
    @Override
    public IEstado erro(){
        return new EstadoErro(getDados(), this);
    }
}
