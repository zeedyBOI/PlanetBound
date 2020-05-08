package Ex3;
import java.util.*;
import org.w3c.dom.ls.LSOutput;

public class usersArray {
    int getHighest(int[] a, int size) {
        int maior = 0;
        for (int i = 0; i < size; i++) {
            System.out.println("Elemento " + i + ": " + a[i]);
        }
        for (int i = 0; i < size; i++) {
            if(a[i] > maior)
                maior = a[i];
        }
        return maior;
    }

    void asksForArray() {
        int tam, higher;
        Scanner kb = new Scanner(System.in);
        System.out.println("Qual o tamanho do array:");
        tam = kb.nextInt();
        int [] array = new int [tam];
        for (int i = 0; i < tam; i++) {
            System.out.println("Introduza o elemento do array: ");
            array[i] = kb.nextInt();
        }
        higher = getHighest(array, tam);
        System.out.println("O maior elemento do array e: " + higher);
    }

    public static void main(String[] args) {
        usersArray ua = new usersArray();
        ua.asksForArray();
    }
}
