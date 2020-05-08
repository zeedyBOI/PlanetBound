package Ex3;

public class Main {
    public static void main(String[] args) {
        MobileCo v = new MobileCo("Vodafone");
        v.addCard(123, 10);
        v.addCard(456, 2);
        v.addCard(789);
        v.addCard(111);
        v.addBalance(123, 10);
        v.removeCard(111);
        v.regCall(123, 456, 5);
        System.out.println(v.getCardData(123));
    }
}