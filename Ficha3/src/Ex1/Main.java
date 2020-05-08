package Ex1;

public class Main {
    public static void main(String[] args) {
        Factory f = new Factory("Colep");
        f.addProduct(123);
        System.out.println(f.toString());
        f.addProduct(111);
        f.addProduct(222);
        f.addProduct(333);
        f.testProducts();
        f.removeProduct(111);
        f.removeReproved();
        System.out.println(f.toString());
    }
}
