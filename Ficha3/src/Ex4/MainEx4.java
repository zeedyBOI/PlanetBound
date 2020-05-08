package Ex4;

public class MainEx4 {
    public static void main(String[] args) {
        Dictionary d = new Dictionary();
        d.add("ingles", "LIVRO", "Book");
        d.add("frances", "LIVRO", "livre");
        d.add("portugues", "LIVRO", "livro");
        d.add("ingles", "ANO", "year");
        d.add("frances", "ANO", "an");
        d.add("portugues", "ANO", "ano");
        d.defineLanguage("ingles");
        System.out.println(d.get("ANO")); //year
        d.defineLanguage("portugues");
        System.out.println(d.get("ANO"));//ano
        d.defineLanguage("frances");
        System.out.println(d.get("LIVRO"));//livre
    }
}
