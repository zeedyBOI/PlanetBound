package Ex1.Logic;

import Ex1.Logic.Data.EDados;
import Ex1.Logic.States.*;

public class MaqElevador {

    private EDados dados;
    private IEstado estado;

    public MaqElevador() {
        this.dados = new EDados();
        this.estado = new RC(dados);
    }

    public IEstado getEstado() {
        return estado;
    }

    public void setEstado(IEstado estado) {
        this.estado = estado;
    }

    public void up() {
        setEstado(estado.up());
    }

    public void down() {
        setEstado(estado.down());
    }

    public String getAndar() {
        return estado.getName();
    }

    public int getNClicks() {
        return dados.getNClicks();
    }
    
    public void erro(){
        setEstado(estado.erro());
    }
    
    public void safeKey(int code){
        if(dados.isCorrect(code))
            setEstado(estado.safeKey(code));
    }

    public boolean canGoUp() {
        return (!(this.getEstado() instanceof RC));
    }
}
