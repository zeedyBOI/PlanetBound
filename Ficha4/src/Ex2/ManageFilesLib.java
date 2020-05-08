package Ex2;
import Ex1.Logic.*;

import java.io.*;

public class ManageFilesLib {
    public static boolean saveAsCSV(Library lib, String fileName) {
        PrintStream out = null;
        try {
            out = new PrintStream(new FileOutputStream(fileName));
            out.println(lib.toStringAsCSV());
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.err.println("ERROR");
            return false;
        }
        finally {
            if(out != null)
            out.close();
        }
    }
/*
    public static boolean loadAsCSV(Library lib, String fileName) {
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(fileName));
            String nome = in.readLine();
            if(nome == null)
                return false;
            lib.setName(nome);
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }*/
}
