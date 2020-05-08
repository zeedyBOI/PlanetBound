package Ex1.Logic.States;

import Ex1.Logic.Data.*;

public class RC extends Adapter {

    //String name = "RC";
    public RC(EDados dados) {
        super("RC", dados);
    }

    @Override
    public IEstado up() {
        getDados().click();
        return new Andar1(getDados());
    }

    @Override
    public IEstado down() {
        getDados().click();
        return this;
    }

    /*
    @Override
    public String getName() {
        return name;
    }
     */
    @Override
    public boolean canGoUp() {
        return true;
    }
    
    @Override
    public IEstado erro(){
        return new EstadoErro(getDados(), this);
    }
}
