import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class IngredientParametrizedTest {
    private final IngredientType type;

    public IngredientParametrizedTest(IngredientType type){
        this.type = type;
    }

    @Parameterized.Parameters
    public static Object[][] getIngredientTypeData(){
        return new Object[][]{
                {IngredientType.SAUCE},
                {IngredientType.FILLING}
        };
    }

    @Test
    public void typeShouldBeAsInConstructor(){
        String ingredientName = "IngredientName";
        float ingredientPrice = 123.4f;
        Ingredient ingredient = new Ingredient(type, ingredientName, ingredientPrice);

        assertEquals(type, ingredient.getType());
    }
}
