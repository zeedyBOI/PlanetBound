package Ex7;
import java.util.*;

public class matrizes {
    int[][] matrix;
    int m, n;
    private void createMatrix() {
        Scanner kb = new Scanner(System.in);
        System.out.println("Dimensions: ");
        m = kb.nextInt();
        n = kb.nextInt();
        matrix = new int[m][n];
        autofill();
    }

    private void autofill() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (int) (Math.random() * 10 + 1);
            }
        }
    }

     private void changeElem () {
         Scanner kb = new Scanner(System.in);
        int m_pos, n_pos, new_elem;
        System.out.print("Position: ");
        m_pos = kb.nextInt();
        n_pos = kb.nextInt();
        System.out.print("New element: ");
        new_elem = kb.nextInt();
        matrix[m_pos - 1][n_pos - 1] = new_elem;
    }

    private int sumAll() {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                sum += matrix[i][j];
            }
        }
        return sum;
    }

    private int sumL_C(int m_line, int n_line) {
        int sum = 0;
        if(n_line == 0) {
            sum = sumLine(m_line - 1);
        }
        if(m_line == 0) {
            sum = sumColumn(n_line - 1);
        }
        return sum;
    }

    private int sumLine(int n_line) {
        int sum = 0;
        for (int i = 0; i < m; i++) {
            sum += matrix[i][n_line];
        }
        return sum;
    }

    private int sumColumn(int m_line) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += matrix[m_line][i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int sumL, sumC, sumA;
        matrizes a = new matrizes();
        a.createMatrix();
        a.changeElem();
        sumL = a.sumLine(1);
        sumC = a.sumColumn(1);
        sumA = a.sumAll();
        System.out.println("Sum of matrix: " + sumA);
    }
}
