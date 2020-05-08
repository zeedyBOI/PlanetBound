package Ex5;
import java.util.*;

public class totoloto {
    int[] aposta = new int[6];

    public int getTam() {
        return aposta.length;
    }

    int getNovoNum() {
        int num;
        System.out.println("Novo Numero: ");
        Scanner kb = new Scanner(System.in);
        do {
            num = kb.nextInt();
        }while(num < 1 || num > 49);
        return num;
    }

    boolean searchNum(int n) {
        for (int i = 0; i < aposta.length; i++) {
            if(aposta[i] == n)
                return true;
        }
        return false;
    }

    void addNum() {
        int newNum;
        do {
            newNum = getNovoNum();
        }while(searchNum(newNum));
        if(!isFull()) {
            for (int i = 0; i < aposta.length; i++) {
                if (aposta[i] == 0) {
                    aposta[i] = newNum;
                    return;
                }
            }
        }
    }

    boolean isFull() {
        if(aposta[5] != 0)
            return false;
        return true;
    }

    void autoFill() {
        int n;
        for (int i = 0; i < aposta.length; i++) {
            do {
                n = (int) (Math.random() * 49 + 1);
            }while(searchNum(n));
            aposta[i] = n;
        }
    }

    void list() {
        for (int i = 0; i < aposta. length; i++) {
            System.out.print(aposta[i] + " ");
        }
    }

    boolean checkWinner(int[] winnerBet) {
        for (int i = 0; i < winnerBet.length; i++) {
            if(winnerBet[i] != aposta[i])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] chaveCerta = {4, 13, 18, 19, 44, 45};
        totoloto t = new totoloto();
        totoloto e = new totoloto();
        for (int i = 0; i < t.getTam(); i++) {
            t.addNum();
        }
        t.list();
        e.autoFill();
        e.list();
        if(t.checkWinner(chaveCerta))
            System.out.println("t ganhou!");
        if(e.checkWinner(chaveCerta))
            System.out.println("e ganhou");
    }
}
