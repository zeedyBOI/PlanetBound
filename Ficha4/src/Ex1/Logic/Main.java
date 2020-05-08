package Ex1.Logic;
import Ex2.OldBook;
public class Main {
    public static void main(String[] args) {
        Library l1 = new Library("Lib1");
        Book b1 = new Book("Book1", "aut1 aut2");
        l1.addBook(b1);
        OldBook ob1 = new OldBook("ob1", "aut3 aut4");
        System.out.println(ob1.toString());
    }
}
