import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class ItemsTest {

    Items cola;
    Items crisps;
    Items sweets;
    Items sweetsOutOfStock;

    @Before
    public void before(){
        cola = new Items("Cola", 100, 10, 1);
        crisps = new Items("Crisps", 50, 10,2);
        sweets = new Items("Sweets", 65, 10,3);
        sweetsOutOfStock = new Items("Sweeties", 65, 0, 4);
    }

    @Test
    public void canGetItemName(){
        assertEquals("Cola", cola.getProduct());
    }

    @Test
    public void  canGetPrice(){
        assertEquals(100, cola.getPrice());
    }

    @Test
    public void canGetQuantity(){
        assertEquals(10, cola.getQuantity());
    }

    @Test
    public void canReduceStock(){
        cola.reduceStockByOne();
        assertEquals(9, cola.getQuantity());
    }

    @Test
    public void canGetSelectionCode(){
        assertEquals(1, cola.getSelectionCode());
    }
}
