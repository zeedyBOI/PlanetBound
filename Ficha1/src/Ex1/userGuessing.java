package Ex1;
import java.util.*;

public class userGuessing {
    int randomNum, cont = 0;

    void generatorNum() {
        randomNum = (int) (Math.random() * 100) + 1;
    }

    void guessing() {
        int guess = 0;
        Scanner kb = new Scanner(System.in);
        do {
            System.out.println("Adivinhe o numero (1-100): ");
            guess = kb.nextInt();
            if(guess != randomNum) {
                System.out.println("Errado, tente novamente!");
                cont++;
                if(cont == 5) {
                    System.out.println("Atingiu o numero maximo de tentativas erradas, a resposta certa era " + randomNum);
                    break;
                }
            }
        }while(guess != randomNum);
    }

    public static void main(String[] args) {
        userGuessing a = new userGuessing();
        a.generatorNum();
        a.guessing();
    }
}
