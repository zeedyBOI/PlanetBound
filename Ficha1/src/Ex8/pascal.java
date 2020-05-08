package Ex8;
import java.util.*;

public class pascal {
    int index = 0,maxN = 10;
    int[][] triangle;

    public pascal() {
        triangle = new int[maxN][];
    }

    public int getN() {
        return maxN;
    }

    void build() {
        for (int i = 0; i < getN(); i++) {
            index++;
            triangle[i] = new int[index];
            for (int j = 0; j < triangle[i].length; j++) {
                if(i == 0 || j == 0 || j == index - 1)
                    triangle[i][j] = 1;
                else
                    triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
            }
        }
    }

    void list() {
        for (int i = 0; i < triangle.length; i++) {
                System.out.println(Arrays.toString(triangle[i]));
        }
    }

    public static void main(String[] args) {
        pascal p = new pascal();
        p.build();
        p.list();
    }
}
