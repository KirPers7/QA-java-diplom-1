package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class BurgerPriceTest {

    @Mock
    Bun bun;

    @Mock
    List<Ingredient> ingredients;

    @InjectMocks
    Burger burger = new Burger();
    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Parameterized.Parameter
    public float ingredientFirst;

    @Parameterized.Parameter(1)
    public float ingredientSecond;

    @Parameterized.Parameter(2)
    public float ingredientThird;

    @Parameterized.Parameter(3)
    public float price;

    @Parameterized.Parameters
    public static Object[] getData() {
        return new Object[][]{
                {1337, 300, 90, 3703},
                {3000, 4400, 80, 9456}
        };
    }

    //Проверка, что метод getPrice() корректно подсчитывает стоимость бургера
    @Test
    public void testGetPrice() {

        Ingredient ingredient = new Ingredient(FILLING, "Начинка 1", ingredientFirst);
        Ingredient ingredient2 = new Ingredient(FILLING, "Начинка 2", ingredientSecond);
        Ingredient ingredient3 = new Ingredient(SAUCE, "Соус", ingredientThird);
        //Подготовить тестовые данные
        Mockito.when(bun.getPrice()).thenReturn(Float.valueOf(988));
        Mockito.when(ingredients.iterator()).thenReturn(List.of(ingredient, ingredient2, ingredient3).iterator());

        //Вызвать проверяемый метод
        float actualPrice = burger.getPrice();
        float expectedPrice = price;

        //Проверить ожидаемый результат
        Assert.assertEquals(expectedPrice, actualPrice, 0);
    }
}
