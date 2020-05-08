package Ex2;
import Ex1.Logic.*;
import java.util.*;

public class OldBook extends Book {
    private int nCopies;

    public OldBook(String title, String... authors) {
        super(title, authors);
        nCopies = 0;
        //super(title, authors);
        //nCopies = 0;
    }

    public OldBook(String title, List<String> authors) {
        this(title, authors, 0);
        //super(title, authors);
        //nCopies = 0;
    }
    public OldBook(String title, List<String> authors, int nCopies) {
        super(title, authors);
        this.nCopies = nCopies;
    }

    public void setNCopies(int nCopies) {
        this.nCopies = nCopies;
    }

    public void addNCopies(int nCopies) {
        this.nCopies += nCopies;
    }

    public boolean printNCopies(int nCopies) {
        if(nCopies <= 0)
            return false;
        this.nCopies += nCopies;
        return true;
    }

    public int getNCopies() {
        return nCopies;
    }

    @Override
    public String toString() {
        return "OldBook #[" + getCode_book() + "]" +getTitle() + "," + getAuthors() + ", nCopies = " + getNCopies();
    }
}
