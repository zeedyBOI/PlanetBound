package Ex2;
import java.util.*;

public class game {
	
	int randomNum(int min, int max) {
		return (int) (min + (Math.random() * (max - min)));
	}
	
	void testa() {
		int min = 1, max = 100, r;
		System.out.println("Digite o numero entre 0 e 100: ");
		while(true) {
			r = randomNum(min, max);
			System.out.println("Pensou no numero " + r + "? [Ss<>]");
			String key = getValidOption();
			switch(key) {
			case "<" : max = r;
					break;
			case ">" : min = r;
					break;
			case "s":
			case "S" : 
				System.out.println("Acertei, o numero é " + r);
				return;
			}
		}
	}
	
	
	private String getValidOption() {
		Scanner kb = new Scanner(System.in);
		while(!kb.hasNext("[Ss<>]"))
			kb.next();
		return kb.next();
	}

	public static void main(String[] args) {
		game g = new game();
		g.testa();
	}
}
