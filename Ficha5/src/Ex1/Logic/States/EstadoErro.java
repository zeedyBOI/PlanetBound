package Ex1.Logic.States;

import Ex1.Logic.Data.*;

public class EstadoErro extends Adapter {
    private IEstado estadoAnterior;

    public EstadoErro(EDados dados, IEstado anterior) {
        super("Erro", dados);
        this.estadoAnterior = anterior;
    }
    
    @Override
    public IEstado safeKey(int code){
        return estadoAnterior;
    }
    
    @Override
    public IEstado erro(){
        return this;
    }
}
