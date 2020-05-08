package Ex1.Logic;

import java.util.*;

public class Library {
    String name;
    List<Book> books;

    public Library(String name) {
        this.name = name;
        books = new ArrayList<>();
    }

    public void setName(String name) {
        this.name = name;
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

    public String toStringOrdenacaoNatural() {
        List<Book> listaOrdenada = new ArrayList<>(books);
        Collections.sort(listaOrdenada);
        StringBuilder sb = new StringBuilder();
        sb.append("###################\n");
        sb.append("Library").append(name).append("ordenacao natural \n");
        for (Book b : listaOrdenada) {
            sb.append("\n").append(b);
        }
        return sb.toString();
    }

    public String toStringOrdenacaoCodigo() {
        List<Book> listaOrdenada = new ArrayList<>(books);
        Collections.sort(listaOrdenada, new ComparadorPorCodigo());
        StringBuilder sb = new StringBuilder();
        sb.append("###################\n");
        sb.append("Library").append(name).append("ordenacao por codigo \n");
        for (Book b : listaOrdenada) {
            sb.append("\n").append(b);
        }
        return sb.toString();
    }

    public String toStringAsCSV() {
        String sep = ";";
        StringBuilder sb = new StringBuilder(name);
        sb.append("\n");
        for (Book b : books) {
            sb.append(b.getTitle()).append(sep);
            for (String aut: b.getAuthors()) {
                sb.append(aut).append(sep);
            }
        }
        return sb.toString();
    }

    class ComparadorPorCodigo implements Comparator<Book> {
        @Override
                public int compare(Book b1, Book b2) {
            return b1.getCode_book() - b2.getCode_book();
        }
    }
}
