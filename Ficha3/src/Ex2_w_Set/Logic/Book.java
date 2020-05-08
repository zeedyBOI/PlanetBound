package Ex2_w_Set.Logic;

import java.util.*;

public class Book {
    private static int cod_book;
    private int code_book;
    private String title;
    private List<String> authors;

    public Book(String title, List<String> authors) {
        this.title = title;
        this.authors = authors;
        this.code_book = ++cod_book;
    }

    public Book(String title, String ... authors) {
        //public Book(String title, String[] authors) {
        this(title, Arrays.asList(authors));
    }


    public int getCode_book() {
        return code_book;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors.clear();
        this.authors.addAll(authors);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean addAuthor(String author) {
        return this.authors.add(author);
    }

    public boolean addAuthor(List<String> authors) {
        return this.authors.addAll(authors);
    }

    @Override
    public String toString() {
        return "Book #[" + getCode_book() + "]" +getTitle() + "," + authors;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null)
            return false;
        if(this.getClass() != obj.getClass())
            return false;
        if(this.getCode_book() != ((Book)obj).getCode_book())
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        return code_book;
    }
}
