package Ex5.Logic.Restaurantes;

import Ex5.Logic.PublicidadeGastronomica;
import Ex5.Logic.Restaurante;

public class GaleriaSabores extends Restaurante {
    protected static final String NOME = "Galeria dos sabores";
    protected final String[] MENUS_BASE_GERAIS = {
            "Bifes de peru com molho de cenoura",
            "Bacalhau com natas",
            "Salmao grelhado",
            "Arroz doce"};
    protected final String[] MENUS_BASE_VEGETARIANOS = {
            "Empadao de tofu",
            "Requeijao com molho de ervas e mel",
            "Sorvete de maca"};
    protected final String[] MENUS_BASE_DIETA = {
            "Salada meditarranica",
            "Salada nicoise",
            "Maca acada"};
    protected final String[] MENUS_BASE_ITALIANOS = {
            "Tagliateli a la carbonara",
            "Risoto de legumes",
            "Gelado de cafe"};

    public GaleriaSabores(PublicidadeGastronomica agenciaPub) {
        super(NOME);
        setMenusGerais(MENUS_BASE_GERAIS);
        setMenusVegetarianos(MENUS_BASE_VEGETARIANOS);
        setMenusItalianos(MENUS_BASE_ITALIANOS);
        setMenusDieta(MENUS_BASE_DIETA);

        agenciaPub.addRestaurante(this);
    }

}
