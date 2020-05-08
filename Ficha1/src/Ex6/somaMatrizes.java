package Ex6;
import java.util.*;
public class somaMatrizes {
    int [][] matrix;
    private int askSize() {
        int lado;
        System.out.print("Tamanho do lado da matriz: ");
        Scanner kb = new Scanner(System.in);
        lado = kb.nextInt();
        return lado;
    }

    private int getElement() {
        int elem;
        Scanner kb = new Scanner(System.in);
        System.out.print("Elemento: ");
        elem = kb.nextInt();
        return elem;
    }

    private void makeMatrix() {
        int side = askSize();
        matrix = new int [side][side];
        for (int i = 0; i < side; i++) {
            for (int j = 0; j < side; j++) {
                matrix[i][j] = getElement();
            }

        }
    }

    int[][] somaMatrix(somaMatrizes other) {
        int[][] soma = new int [matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                soma[i][j] = matrix[i][j] + other.matrix[i][j];
            }
        }
        return soma;
    }

    void list() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        somaMatrizes a = new somaMatrizes();
        somaMatrizes b = new somaMatrizes();
        somaMatrizes s = new somaMatrizes();
        a.makeMatrix();
        b.makeMatrix();
        s.matrix = a.somaMatrix(b);
        s.list();
    }
}
