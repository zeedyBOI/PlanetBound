package Ex1.Logic.Data;

public class EDados {

    int nClicks = 0;
    private int codigo = 1234;

    public EDados() {
    }

    public int getNClicks() {
        return nClicks;
    }

    public void click() {
        nClicks++;
    }
    
    public boolean isCorrect(int code){
        return this.codigo == code;
    }
}
