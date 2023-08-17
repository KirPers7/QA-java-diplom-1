package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    Burger burger;
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient, ingredient2;

    @Before
    public void forBurger() {
        burger = new Burger();
    }

    //Проверка, что метод setBuns() устанавливает введенные значения
    @Test
    public void testSetBuns() {

        burger.setBuns(bun);

        Assert.assertEquals(bun.getName(), burger.bun.getName());
    }

    //Проверка, что метод addIngredient() добавил конкретный объект данных в список ingredients
    @Test
    public void testAddIngredient() {

        burger.addIngredient(ingredient);

        Assert.assertTrue(burger.ingredients.contains(ingredient));

    }

    //Проверка, что метод removeIngredient() удаляет ингредиент по указанному индексу
    @Test
    public void testRemoveIngredient() {

        burger.addIngredient(ingredient);

        burger.removeIngredient(0);

        Assert.assertFalse(burger.ingredients.contains(ingredient));

    }

    //Проверка, что метод moveIngredient() перемещает ингредиент с одного указанного индекса на другой
    @Test
    public void testMoveIngredient() {

        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);

        burger.moveIngredient(0,1);

        Assert.assertEquals(ingredient, burger.ingredients.get(1));
    }



    @Test
    public void testGetReceipt() {

        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);
        burger.setBuns(bun);

        Mockito.when(bun.getName()).thenReturn("Краторная булка N-200i");
        Mockito.when(ingredient.getName()).thenReturn("Говяжий метеорит (отбивная)");
        Mockito.when(ingredient2.getName()).thenReturn("Биокотлета из марсианской Магнолии");
        Mockito.when(bun.getPrice()).thenReturn(1255F);
        Mockito.when(ingredient.getPrice()).thenReturn(3000F);
        Mockito.when(ingredient2.getPrice()).thenReturn(424F);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient2.getType()).thenReturn(IngredientType.FILLING);

        String actualReceipt = burger.getReceipt();
        String expectedReceipt = "(==== Краторная булка N-200i ====)\r\n= filling Говяжий метеорит (отбивная) =\r\n" +
                "= filling Биокотлета из марсианской Магнолии =\r\n(==== Краторная булка N-200i ====)\r\n\r\nPrice: 5934,000000\r\n";
        Assert.assertEquals(expectedReceipt, actualReceipt);
    }
}
