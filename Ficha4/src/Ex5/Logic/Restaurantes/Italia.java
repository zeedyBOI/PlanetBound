package Ex5.Logic.Restaurantes;

import Ex5.Logic.PublicidadeGastronomica;
import Ex5.Logic.Restaurante;

public class Italia extends Restaurante {
    protected static final String NOME = "Italia";
    protected final String[] MENUS_BASE_GERAIS = {
            "Lulas recheadas com presunto",
            "Leite creme"};
    protected final String[] MENUS_BASE_ITALIANOS = {
            "Lasanha dourada com mozarella",
            "Lasanha do mar",
            "Tiramisu"};

    public Italia(PublicidadeGastronomica agenciaPub)
    {
        super(NOME);
        setMenusGerais(MENUS_BASE_GERAIS);
        setMenusItalianos(MENUS_BASE_ITALIANOS);

        agenciaPub.addRestaurante(this);
    }

}
