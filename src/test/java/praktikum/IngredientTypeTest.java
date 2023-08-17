package praktikum;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class IngredientTypeTest {

    @Test
    public void testSauce() {

        Assert.assertEquals("SAUCE", IngredientType.SAUCE.toString());
    }

    @Test
    public void testFilling() {

        Assert.assertEquals("FILLING", IngredientType.FILLING.toString());
    }
}