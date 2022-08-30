import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.*;

public class BunTest {
    @Test
    public void nameShouldBeAsInConstructor(){
        String bunName = "BunName";
        float bunPrice = 123.4f;
        Bun bun = new Bun(bunName, bunPrice);

        assertEquals(bunName, bun.getName());
    }

    @Test
    public void priceShouldBeAsInConstructor(){
        String bunName = "BunName";
        float bunPrice = 123.4f;
        Bun bun = new Bun(bunName, bunPrice);

        assertEquals(bunPrice, bun.getPrice(), 0.0f);
    }
}
