package Ex2;

import Ex2.Logic.Library;
import Ex2.UI.Interface;

public class MainEx2 {
    public static void main(String[] args) {
        Library l1 = new Library("Lib1");
        System.out.println(l1.toString());
        Interface ui = new Interface();
        ui.start();
    }
}
