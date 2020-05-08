package Ex7;
import java.util.*;

public class Temperaturas {
    private HashSet<TemperaturaDiaria> temps = new HashSet<>();

    public void acrescenta(TemperaturaDiaria td) {
        if (temps.contains(td)) {
            System.out.println("Já está registado um dia com máximos e mínimos similares");
        }
        else {
            System.out.println("Dia com novos máximos e mínimos");
            temps.add(td);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (TemperaturaDiaria temp : temps) {
            sb.append(temp).append("\n");
        }
        return sb.toString();
    }
}
