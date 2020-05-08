package Ex4;

public class randomArray {
    int [] array = new int[20];
    int cont;
    static int max = 100, min = 1;

    int getCont() {
        return cont;
    }
    boolean check(int n, int pos) {
        for(int i = 0; i < pos; i++)
            if(n == array[i]) {
                cont++;
                return true;
            }
        return false;
    }

    boolean check(int n) {
        return check(n, array.length);
    }

    void autofill() {
        int x;
        for(int i = 0; i < array.length; i++) {
            do {
                x = (int) (min + (Math.random() * max));
            }while(check(x));
            array[i] = x;
        }
    }

    void list() {
        for(int i = 0; i < array.length; i++)
            System.out.print(array[i] + ",");
    }

    public static void main(String[] args) {
        randomArray ra = new randomArray();
        ra.autofill();
        ra.list();
        System.out.print("Quantidade de numeros a mais: " + ra.getCont());
    }
}
