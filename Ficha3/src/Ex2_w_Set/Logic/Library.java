package Ex2_w_Set.Logic;

import java.util.*;

public class Library {
    private static int lib_code;
    private int code_lib;
    private String name;
    private Set<Book> books;

    public Library(String name) {
        this.name = name;
        books = new HashSet<>();
        code_lib = lib_code++;
    }

    public int getCode_lib() { return code_lib; }

    public String getName() {
        return name;
    }

    public Set getBooks() {
        return books;
    }

    public int getNBooks() {
        return books.size();
    }

    public boolean addBook(Book book) {
        if(searchBook(book.getCode_book()) != null)
            return false;
        return books.add(book);
    }

    public Book searchBook(int code_book) {
        Iterator<Book> it = books.iterator();
        while(it.hasNext()){
            if(it.next().getCode_book() == code_book)
                return it.next();
        }
        return null;
    }

    public boolean searchBook(Book book) {
        return books.contains(book);
    }

    public boolean addBook(String title, String... authors) {
        return addBook(new Book(title, authors));
    }

    public boolean removeBook(int code) {
        Book b = searchBook(code);
        if(b == null)
            return false;
        return books.remove(b);
    }

    public void listBooks() {
        int j = 1;
        for (Book b : books) {
            System.out.println(b.toString());
            j++;
        }
    }

    @Override
    public String toString() {
        return "Library{ " + "name='" + name + '\'' + ", books=" + books + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null)
            return false;
        if(this.getClass() != obj.getClass())
            return false;
        final Library other = (Library) obj;
        if(this.hashCode() == obj.hashCode()) {
            if (!Objects.equals(this.name, other.getName()))
                return false;
            if (!Objects.equals(this.books, other.getBooks()))
                return false;
        }
        return true;
    }
}
