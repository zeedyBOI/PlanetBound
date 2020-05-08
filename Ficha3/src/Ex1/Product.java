package Ex1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Product {
    private String state;
    private String dateMade;
    final int serialN;

    public Product(int serialN) {
        this.state = "NOT TESTED";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        this.dateMade = dtf.format(now);
        this.serialN = serialN;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public String getDateMade() {
        return dateMade;
    }

    public int getSerialN() {
        return serialN;
    }

    public boolean testProduct() {
        int x = (int)(Math.random() * 100) + 1;
        if(getState().equals("NOT TESTED")) {
            if (x > 10) {
                setState("APPROVED");
                return true;
            }
            else {
                setState("REPROVED");
                return false;
            }
        }
        else if(getState().equals("APPROVED"))
            return true;
        else if(getState().equals("REPROVED"))
            return false;
        return false;
    }

    @Override
    public String toString() {
        return "Product{" +
                "state='" + state + '\'' +
                ", dateMade='" + dateMade + '\'' +
                ", serialN=" + serialN +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if(this.getSerialN() == ((Product) obj).getSerialN())
            return true;
        return false;
    }

    @Override
    public int hashCode() {
        return this.hashCode();
    }
}
