package Ex2;
import Ex1.Logic.*;

import java.util.List;

public class CurrentBook extends Book {
    private int price;
    private final int ISBN;

    public CurrentBook(String title, List<String> authors, int isbn, int price) {
        super(title, authors);
        this.ISBN = isbn;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return super.toString() + ", price=" + price + ", ISBN=" + ISBN + '}';
    }
}
