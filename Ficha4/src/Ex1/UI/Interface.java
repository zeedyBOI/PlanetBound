package Ex1.UI;
import Ex1.Logic.*;

import java.util.*;

public class Interface {
    String[] options = {"Add Library", "Add Book", "Remove Library", "Remove Book", "List Lib", "List Books", "Ordenacao Natural", "Exit"};
    List<Library> store;

    public Interface() {
        store = new ArrayList<>();
    }

    public void start() {
        boolean stop;
        do {
            clearScreen();
            stop = menu();
        }while(!stop);
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
                }while(checkLibraryName(name) != -1);
                store.add(new Library(name));
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
                store.get(--opt).addBook(new Book(name, aut));
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
            case 7: {
                clearScreen();
                System.out.println("List Ordenada de Livros: ");
                listAllBook();
                break;
            }
            default: {
                System.out.println("Not an option, try again!");
                break;
            }
        }
        return false;
    }

    private void listAllBook() {
        for (Library lib : store) {
            lib.toStringOrdenacaoNatural();
        }
    }

    private String getAtr() {
        Scanner kb = new Scanner(System.in);
        return kb.nextLine();
    }

    public int getOpt() {
        Scanner kb = new Scanner(System.in);
        return kb.nextInt();
    }

    public void listLibrary() {
        int j = 1;
        for (Library lib : store) {
            System.out.println("# " + j + " " + lib.toString());
            j++;
        }
    }

    public void listBooks() {
        for (Library lib : store) {
            lib.listBooks();
        }
    }

    public int checkLibraryName(String libName) {
        for (int i = 0; i < store.size(); i++) {
            if(store.get(i).getName() == libName) {
                System.out.println("That Library already exists! Insert other name: ");
                return i;
            }
        }
        return -1;
    }

    public void deleteLibrary(int index) {
        store.remove(index);
    }

    public void deleteBook(int book_code) {
        for (Library lib : store) {
            lib.removeBook(book_code);
        }
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
