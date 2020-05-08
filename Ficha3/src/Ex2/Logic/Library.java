package Ex2.Logic;

import java.util.*;

public class Library {
    String name;
    List<Book> books;

    public Library(String name) {
        this.name = name;
        books = new ArrayList<>();
    }

    public String getName() {
        return name;
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
        for (Book b : books) {
            if(b.getCode_book() == code_book)
                return b;
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
        if(this == obj)
            return true;
        if(obj == null)
            return false;
        if(getClass() != obj.getClass())
            return false;
        final Library other = (Library) obj;
        if(!Objects.equals(this.name, other.name))
            return false;
        if(!Objects.equals(this.books, other.books))
            return false;
        return true;
    }
}
