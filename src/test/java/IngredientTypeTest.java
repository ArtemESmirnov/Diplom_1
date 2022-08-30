import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class IngredientTypeTest {
    private final String type;

    public IngredientTypeTest(String type){
        this.type = type;
    }

    @Parameterized.Parameters
    public static Object[][] getIngredientsTypeData(){
        return new Object[][] {
                {"SAUCE"},
                {"FILLING"}
        };
    }

    @Test
    public void allTypesShouldExist(){
        assertNotNull(IngredientType.valueOf(type));
    }
}
