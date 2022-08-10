import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class VendingMachineTest {

    Items cola;
    Items crisps;
    Items sweets;
    Items sweetsOutOfStock;
    VendingMachine vendingMachine;

    @Before
    public void before(){
        cola = new Items("Cola", 100, 10, 1);
        crisps = new Items("Crisps", 50, 10,2);
        sweets = new Items("Sweets", 65, 10,3);
        vendingMachine = new VendingMachine();
    }

    @Test
    public void machineStartsWithNoStock(){
        assertEquals(0, vendingMachine.getNumberOfProducts());
    }

    @Test
    public void canAddProduct(){
        vendingMachine.addProduct(cola);
        assertEquals(1, vendingMachine.getNumberOfProducts());
    }

    @Test
    public void canGetNumberOfItems(){
        assertEquals(10, vendingMachine.getItemsRemaining(cola));
    }

    @Test
    public void canReduceStockByOne(){
        vendingMachine.removeItemFromStock(cola);
        assertEquals(9 , vendingMachine.getItemsRemaining(cola));
    }

    @Test
    public void canSelectProductByCode(){
        vendingMachine.addProduct(cola);
        assertEquals(cola, vendingMachine.getProductByCode(1));
    }

    @Test
    public void doesProductHaveStockTrue(){
        assertTrue(vendingMachine.hasStock(cola));
    }
    @Test
    public void doesProductHaveStockFalse(){
        Items colaNoStock = new Items("Cola", 100, 0, 1);
        assertFalse(vendingMachine.hasStock(colaNoStock));
    }

    @Test
    public void canEnterMoney(){
        vendingMachine.addMoney(Coins.FIFTY);
        vendingMachine.addMoney(Coins.FIFTY);
        assertEquals(100, vendingMachine.getTotalMoneyEntered());
    }

    @Test
    public void canPayForItemTrue(){
        vendingMachine.addMoney(Coins.FIFTY);
        vendingMachine.addMoney(Coins.FIFTY);
        assertTrue(vendingMachine.enoughMoneyEnteredForItem(cola));
    }
    @Test
    public void canPayForItemFalse(){
        vendingMachine.addMoney(Coins.FIFTY);
        vendingMachine.addMoney(Coins.TEN);
        assertFalse(vendingMachine.enoughMoneyEnteredForItem(cola));
    }

    @Test
    public void canAcceptValidCoins(){
        assertTrue(vendingMachine.isCoinAccepted(Coins.FIFTY));
    }

    @Test
    public void canRejectInvalidCoins(){
        assertFalse(vendingMachine.isCoinAccepted(Coins.ONE));
    }

}
