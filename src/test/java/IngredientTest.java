import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.*;

public class IngredientTest {
    @Test
    public void nameShouldBeAsInConstructor(){
        String ingredientName = "IngredientName";
        float ingredientPrice = 123.4f;
        IngredientType type = IngredientType.FILLING;
        Ingredient ingredient = new Ingredient(type, ingredientName, ingredientPrice);

        assertEquals(ingredientName, ingredient.getName());
    }

    @Test
    public void priceShouldBeAsInConstructor(){
        String ingredientName = "IngredientName";
        float ingredientPrice = 123.4f;
        IngredientType type = IngredientType.FILLING;
        Ingredient ingredient = new Ingredient(type, ingredientName, ingredientPrice);

        assertEquals(ingredientPrice, ingredient.getPrice(), 0.0f);
    }
}
