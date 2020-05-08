package Ex2_w_Map.Logic;


import Ex2.Logic.Book;

import java.util.*;

public class Library {
    private static int code_lib;
    private int lib_code;
    private String name;
    private Map<Integer, Book> books;

    public Library(String name) {
        this.name = name;
        lib_code = code_lib++;
        books = new HashMap<>();
    }

    public int getCode_lib() { return lib_code; }

    public Map getBooks() {
        return books;
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
        books.put(book.getCode_book(), book);
        return true;
    }

    public Integer searchBook(int code_book) {
        Integer mapKey;
        Set<Integer> key = books.keySet();
        Iterator<Integer> it = key.iterator();
        while(it.hasNext()){
            mapKey = it.next();
            if(books.get(mapKey).getCode_book() == code_book)
                return mapKey;
        }
        return null;
    }

    public boolean searchBook(Book book) {
        if(books.get(book) != null)
            return true;
        return false;
    }

    public boolean addBook(String title, String... authors) {
        return addBook(new Book(title, authors));
    }

    public boolean removeBook(int code) {
        Integer c = searchBook(code);
        if(c == null)
            return false;
        books.remove(c);
        return true;
    }

    public void listBooks() {
        Set<Integer> mapKey = books.keySet();
        Iterator<Integer> it = mapKey.iterator();
        while(it.hasNext()){
            System.out.println(it.next().toString());
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
