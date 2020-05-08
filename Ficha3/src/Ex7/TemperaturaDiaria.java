package Ex7;

import java.util.Arrays;

public class TemperaturaDiaria {
    private int temperaturasHorarias[];
    private String responsavelMedicoes;
    private String localMedicao;
    TemperaturaDiaria(int[] temps, String resp, String local) {
        responsavelMedicoes = resp;
        localMedicao = local;
        temperaturasHorarias = new int[temps.length];
        for (int i = 0; i < temperaturasHorarias.length; i++) {
            temperaturasHorarias[i] = temps[i];
        }
    }
    @Override
    public boolean equals(Object other) {
        if(other == null)
            return false;
        if(this == other)
            return true;
        if(!(other instanceof TemperaturaDiaria))
            return false;
        TemperaturaDiaria obj = (TemperaturaDiaria) other;
        return getMaximo() == obj.getMaximo() && getMinimo() == obj.getMinimo();
    }

    @Override
    public int hashCode() {
        int s = 0;
        s += 131 * getMaximo();
        s += 7 * getMinimo();
        return s;
    }
    int getMaximo() {
        int max = temperaturasHorarias[0];
        for (int t : temperaturasHorarias) {
            if (t > max) {
                max = t;
            }
        }
        return max;
    }
    int getMinimo() {
        int min = temperaturasHorarias[0];
        for (int t : temperaturasHorarias) {
            if (t < min) {
                min = t;
            }
        }
        return min;
    }

    @Override
    public String toString() {
        return "Local: " + localMedicao  + "medido por " + responsavelMedicoes + " " + Arrays.toString((temperaturasHorarias));
    }
}

