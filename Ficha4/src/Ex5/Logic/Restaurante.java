package Ex5.Logic;

import java.util.Arrays;
import java.util.List;

public class Restaurante implements Comparable {
    protected String nome;
    protected List<String> menusGerais = null;
    protected List<String> menusDieta = null;
    protected List<String> menusFastFood = null;
    protected List<String> menusItalianos = null;
    protected List<String> menusVegetarianos = null;

    public Restaurante(String nome) {
        this.nome = nome.trim();
    }

    public String getNome() {
        return nome;
    }

    public void setMenusGerais(String[] menus) {
        menusGerais = Arrays.asList(menus);
    }

    public void setMenusDieta(String[] menus) {
        menusDieta = Arrays.asList(menus);
    }

    public void setMenusFastFood(String[] menus) {
        menusFastFood = Arrays.asList(menus);
    }

    public void setMenusItalianos(String[] menus) {
        menusItalianos = Arrays.asList(menus);
    }

    public void setMenusVegetarianos(String[] menus) {
        menusVegetarianos = Arrays.asList(menus);
    }

    public String[] getMenusGerais() {
        if (menusGerais == null) {
            return null;
        }
        return menusGerais.toArray(new String[menusGerais.size()]);
    }

    public String[] getMenusDieta() {
        if (menusDieta == null) {
            return null;
        }
        return menusDieta.toArray(new String[menusDieta.size()]);
    }

    public String[] getMenusFastFood() {
        if (menusFastFood == null) {
            return null;
        }
        return menusFastFood.toArray(new String[menusFastFood.size()]);
    }

    public String[] getMenusItalianos() {
        if (menusItalianos == null) {
            return null;
        }
        return menusItalianos.toArray(new String[menusItalianos.size()]);
    }

    public String[] getMenusVegetarianos() {
        if (menusVegetarianos == null) {
            return null;
        }
        return menusVegetarianos.toArray(new String[menusVegetarianos.size()]);
    }

    public String toString() {
        String s = nome;
        if (menusGerais.size() > 0) {
            s += "\r\n\r\nMenus gerais:";
            for (String m : menusGerais)
                s += "\r\n\t" + m;
        }
        if (menusDieta.size() > 0) {
            s += "\r\n\r\nMenus dieta:";
            for (String m : menusDieta)
                s += "\r\n\t" + m;
        }
        if (menusFastFood.size() > 0) {
            s += "\r\n\r\nMenus \"fast food\":";
            for (String m : menusFastFood)
                s += "\r\n\t" + m;
        }
        if (menusItalianos.size() > 0) {
            s += "\r\n\r\nMenus italianos:";
            for (String m : menusItalianos)
                s += "\r\n\t" + m;
        }
        if (menusVegetarianos.size() > 0) {
            s += "\r\n\r\nMenus vegetarianos:";
            for (String m : menusVegetarianos)
                s += "\r\n\t" + m;
        }
        return s;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null)                   { return false;    }
        if (!(o instanceof Restaurante)) { return false;    }
        return nome.equalsIgnoreCase(((Restaurante) o).getNome().trim());
    }

    @Override
    public int hashCode() {
        return nome.hashCode();
    }

    @Override
    public int compareTo(Object o) {
        return nome.compareTo(((Restaurante) o).getNome());
    }
}
