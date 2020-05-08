package Ex2.UI;
import Ex2.Logic.Document;
import java.util.*;
public class UITextDoc {
    Document doc;
    boolean exit = false;

    public UITextDoc(Document doc) {
        this.doc = doc;
    }

    public void run() {
        while (!exit) {
            int option = getOption();
            switch (option) {
                case 1:
                    System.out.println(doc.getText());
                case 2: {
                    System.out.println("Qual o Autor a adicionar");
                    Scanner s = new Scanner(System.in);
                    String a = s.nextLine();
                    doc.addAuthor(a);
                }
                break;
                case 3: {
                    System.out.println("Qual o Autor a remover");
                    Scanner s = new Scanner(System.in);
                    String a = s.nextLine();
                    doc.removeAuthor(a);
                }
                break;
                case 5:
                    addLine();
                    break;
            }
        }
    }

    private void addLine() {
        System.out.println("Qual o texto a adicionar");
        Scanner s = new Scanner(System.in);
        String a = s.nextLine();
        doc.addLine();
    }

    private void showOptions() {

    }

    private int getOption() {
        return 1;
    }

    private int getOption(String[] options) {
        int option;
        do {
            for (int i = 0; i < options.length; i++) {
                System.out.println("" + (i + 1) + "-" + options[i]);
            }
            Scanner s = new Scanner(System.in);
            while (!s.hasNextInt())
                s.next();
            option = s.nextInt();
        }while (option < 1 || option >= options.length);
        return option;
    }
}
