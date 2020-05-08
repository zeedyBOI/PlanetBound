package Ex1.Logic.States;

import Ex1.Logic.Data.*;

public abstract class Adapter implements IEstado {

    String name;
    private EDados dados;

    public Adapter(String name, EDados dados) {
        this.name = name;
        this.dados = dados;
    }

    @Override
    public IEstado up() {
        return this;
    }

    @Override
    public IEstado down() {
        return this;
    }

    @Override
    public boolean canGoUp() {
        return false;
    }

    @Override
    public boolean canGoDown() {
        return false;
    }

    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public IEstado safeKey(int code){
        return this;
    }
    
    @Override
    public IEstado erro(){
        return this;
    }

    public EDados getDados() {
        return dados;
    }
}
