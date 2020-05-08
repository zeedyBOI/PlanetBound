package Ex1;

import java.util.ArrayList;
import java.util.List;

public class Factory {
    String name;
    static int nProducts;
    static int serialN;
    List<Product> inventory;

    public Factory(String name) {
        this.name = name;
        inventory = new ArrayList<>();
        nProducts = 0;
        serialN = 0;
    }

    public boolean addProduct(int sNum) {
        if(searchProduct(sNum) != null) {
            serialN++;
            return inventory.add(new Product(sNum));
        }
        return false;
    }

    public Product searchProduct(int sNum) {
        Product x;
        for (int i = 0; i < inventory.size(); i++) {
            if((x = inventory.get(i)).getSerialN() == sNum)
                return x;
        }
        return null;
    }

    public boolean removeProduct(int sNum) {
        return inventory.remove(searchProduct(sNum));
    }

    public void testProducts() {
        for (int i = 0; i < inventory.size(); i++) {
            inventory.get(i).testProduct();
        }
    }

    public void removeReproved() {
        for (int i = 0; i < inventory.size(); i++) {
            if(inventory.get(i).getState().equalsIgnoreCase("REPROVED"))
                inventory.remove(i);
        }
    }

    public String listProducts() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < inventory.size(); i++) {
            sb.append(inventory.get(i).toString());
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return "Factory{" +
                "name='" + name + '\'' +
                ", inventory=" + listProducts() +
                '}';
    }
}
