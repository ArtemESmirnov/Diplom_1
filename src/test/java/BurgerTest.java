import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private final String bunName = "BunName";
    private final float bunPrice = 1.23f;
    private final String ingredientNameFilling = "Filling";
    private final float ingredientPriceFilling = 45.6f;
    private final IngredientType ingredientTypeFilling = IngredientType.FILLING;
    private final String ingredientNameSauce = "Sauce";
    private final float ingredientPriceSauce = 789f;
    private final IngredientType ingredientTypeSauce = IngredientType.SAUCE;


    @Mock
    Bun bunMock;
    @Mock
    Ingredient ingredientFillingMock;
    @Mock
    Ingredient ingredientSauceMock;

    @Test
    public void bunsShouldBeLikeInConstructor(){
        Bun bun = new Bun(bunName, bunPrice);
        Burger burger = new Burger();

        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredientShouldBeInList(){
        Ingredient ingredientFilling = new Ingredient(ingredientTypeFilling, ingredientNameFilling, ingredientPriceFilling);
        Burger burger = new Burger();

        burger.addIngredient(ingredientFilling);
        assertTrue(burger.ingredients.contains(ingredientFilling));
    }



    @Test
    public void removeIngredientShouldNotBeInList(){
        Ingredient ingredientFilling = new Ingredient(ingredientTypeFilling, ingredientNameFilling, ingredientPriceFilling);
        Burger burger = new Burger();

        burger.ingredients.add(ingredientFilling);
        burger.removeIngredient(0);
        assertFalse(burger.ingredients.contains(ingredientFilling));
    }

    @Test
    public void moveIngredientShouldBeOnNewPlace(){
        Ingredient ingredientFilling = new Ingredient(ingredientTypeFilling, ingredientNameFilling, ingredientPriceFilling);
        Ingredient ingredientSauce = new Ingredient(ingredientTypeSauce, ingredientNameSauce, ingredientPriceSauce);
        Burger burger = new Burger();

        burger.ingredients.add(ingredientFilling);
        burger.ingredients.add(ingredientSauce);
        burger.moveIngredient(0, 1);
        assertEquals(ingredientSauce, burger.ingredients.get(0));
        assertEquals(ingredientFilling, burger.ingredients.get(1));
    }

    @Test
    public void getPriceShouldReturnCorrectValue(){
        float expectedPrice = bunPrice * 2 + ingredientPriceFilling + ingredientPriceSauce;

        Mockito.when(bunMock.getPrice()).thenReturn(bunPrice);
        Mockito.when(ingredientFillingMock.getPrice()).thenReturn(ingredientPriceFilling);
        Mockito.when(ingredientSauceMock.getPrice()).thenReturn(ingredientPriceSauce);

        Burger burger = new Burger();
        burger.setBuns(bunMock);
        burger.ingredients.add(ingredientFillingMock);
        burger.ingredients.add(ingredientSauceMock);

        assertEquals(expectedPrice, burger.getPrice(), 0.0f);
    }

    @Test
    public void getReceiptShouldReturnCorrectValue(){
        Burger burger = new Burger();

        burger.setBuns(bunMock);
        burger.ingredients.add(ingredientFillingMock);
        burger.ingredients.add(ingredientSauceMock);

        Mockito.when(bunMock.getName()).thenReturn(bunName);
        Mockito.when(ingredientFillingMock.getName()).thenReturn(ingredientNameFilling);
        Mockito.when(ingredientSauceMock.getName()).thenReturn(ingredientNameSauce);

        Mockito.when(ingredientFillingMock.getType()).thenReturn(ingredientTypeFilling);
        Mockito.when(ingredientSauceMock.getType()).thenReturn(ingredientTypeSauce);

        Mockito.when(burger.getPrice()).thenReturn(123f);

        String receipt = String.format("(==== %s ====)%n", bunMock.getName()) + String.format("= %s %s =%n", ingredientFillingMock.getType().toString().toLowerCase(),
                ingredientFillingMock.getName()) +
                String.format("= %s %s =%n", ingredientSauceMock.getType().toString().toLowerCase(),
                        ingredientSauceMock.getName()) +
                String.format("(==== %s ====)%n", bunMock.getName()) +
                String.format("%nPrice: %f%n", burger.getPrice());

        assertEquals(receipt, burger.getReceipt());
    }
}
