package Ex5.Logic.Restaurantes;
import Ex5.Logic.PublicidadeGastronomica;
import Ex5.Logic.Restaurante;

public class BurgerKing extends Restaurante {
    protected static final String NOME = "Burger King";
    protected static String [] MENUS_BASE_FAST_FOOD = {
            "FishBurger",
            "ChickenBurger",
            "Tarte de maca com gelado"};
    protected static String [] MENUS_BASE_VEGETARIANOS = {
            "BeanBurger",
            "TofuBerger",
            "Sorvete de maca"};

    public BurgerKing(PublicidadeGastronomica agenciaPub)
    {
        super(NOME);
        setMenusFastFood(MENUS_BASE_FAST_FOOD);
        setMenusVegetarianos(MENUS_BASE_VEGETARIANOS);

        agenciaPub.addRestaurante(this);
    }

}
