package Ex2_w_Map.UI;

import Ex2_w_Map.Logic.*;

import java.util.*;

public class Interface {
    private static int lib_code;
    private int code_lib;
    private String[] options = {"Add Library", "Add Book", "Remove Library", "Remove Book", "List Lib", "List Books", "Exit"};
    private Map<Integer, Library> store;

    public Interface() {
        store = new HashMap<>();
    }

    public void start() {
        boolean stop;
        do {
            clearScreen();
            stop = menu();
        } while (!stop);
    }

    int getOptionsLength() {
        return options.length;
    }

    public boolean menu() {
        String name, aut;
        int opt = -1;
        for (int i = 0; i < getOptionsLength() - 1; i++) {
            System.out.println((i + 1) + " - " + options[i]);
        }
        System.out.println("0 - " + options[getOptionsLength() - 1]);
        System.out.println("Option: ");
        opt = getOpt();

        switch (opt) {
            case 0: {
                return true;
            }
            case 1: {
                clearScreen();
                System.out.println("Name of Library: ");
                do {
                    name = getAtr();
                } while (checkLibraryName(name) != -1);
                code_lib = lib_code++;
                store.put(code_lib,new Library(name));
                break;
            }
            case 2: {
                clearScreen();
                System.out.println("Name of the Book: ");
                name = getAtr();
                System.out.println("Author: ");
                aut = getAtr();
                listLibrary();
                System.out.println("Add book to: ");
                opt = getOpt();
                getLib(--opt).addBook(name, aut);
                break;
            }
            case 3: {
                clearScreen();
                System.out.println("Libraries: ");
                listLibrary();
                System.out.println("Choose which one you want to delete: ");
                opt = getOpt();
                deleteLibrary(--opt);
                break;
            }
            case 4: {
                clearScreen();
                System.out.println("Books: ");
                listBooks();
                System.out.println("Choose which one you want to delete: ");
                opt = getOpt();
                deleteBook(opt);
                break;
            }
            case 5: {
                clearScreen();
                System.out.println("Libraries: ");
                listLibrary();
                break;
            }
            case 6: {
                clearScreen();
                System.out.println("Books: ");
                listBooks();
                break;
            }
            default: {
                System.out.println("Not an option, try again!");
                break;
            }
        }
        return false;
    }

    private String getAtr() {
        Scanner kb = new Scanner(System.in);
        return kb.nextLine();
    }

    public int getOpt() {
        Scanner kb = new Scanner(System.in);
        return kb.nextInt();
    }

    public Library getLib(int index) {
        Integer mapKey;
        Set<Integer> key = store.keySet();
        Iterator<Integer> it = key.iterator();
        while(it.hasNext()) {
            mapKey = it.next();
            if(store.get(mapKey).getCode_lib() == index)
                return store.get(mapKey);
        }
        return null;
    }

    public void listLibrary() {
        int j = 1;
        Set<Integer> key = store.keySet();
        Iterator<Integer> it = key.iterator();
        while(it.hasNext()) {
            System.out.println("# " + j + " " + it.next().toString());
            j++;
        }
    }

    public void listBooks() {
        Set<Integer> key = store.keySet();
        Iterator<Integer> it = key.iterator();
        while(it.hasNext()){
            store.get(it.next()).listBooks();
        }
    }

    public Integer checkLibraryName(String libName) {
        Set<Integer> key = store.keySet();
        Iterator<Integer> it = key.iterator();
        while(it.hasNext()) {
            if (store.get(it.next()).getName() == libName) {
                System.out.println("That Library already exists! Insert other name: ");
                return it.next();
            }
        }
        return -1;
    }

    public void deleteLibrary(int index) {
        store.remove(index);
    }

    public void deleteBook(int book_code) {
        /*for (Library lib : store) {
            lib.removeBook(book_code);
        }*/
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
