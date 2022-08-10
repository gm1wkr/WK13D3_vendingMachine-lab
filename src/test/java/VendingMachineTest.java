import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class VendingMachineTest {

    Items cola;
    Items crisps;
    Items sweets;
    Items sweetsOutOfStock;
    VendingMachine vendingMachine;
    VendingMachine vendingMachineReady;
    Coins poundCoin;
    Coins fiftyPence;
    Coins twentyPence;

    @Before
    public void before(){
        cola = new Items("Cola", 100, 10, 1);
        crisps = new Items("Crisps", 50, 10,2);
        sweets = new Items("Sweets", 65, 10,3);
        vendingMachine = new VendingMachine();
        vendingMachineReady = new VendingMachine();

        poundCoin =  Coins.ONE_HUNDRED;
        fiftyPence = Coins.FIFTY;
        twentyPence = Coins.TWENTY;
        vendingMachineReady.addProduct(cola);
        vendingMachineReady.addProduct(crisps);
        vendingMachineReady.addProduct(sweets);
        vendingMachineReady.addStartingFloat(poundCoin, 10 );
        vendingMachineReady.addStartingFloat(fiftyPence, 10 );
        vendingMachineReady.addStartingFloat(twentyPence, 10);
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

    @Test
    public void canCalculateChangeDue(){
        vendingMachine.addProduct(sweets);
        vendingMachine.addMoney(Coins.ONE_HUNDRED);
        assertEquals(35, vendingMachine.calculateChange(sweets));
    }


    @Test
    public void canAddStartingFloat(){
        assertEquals(1700, vendingMachineReady.getFloat());
    }

    @Test
    public void isCoinAddedToCoinBin(){
        vendingMachineReady.addCoinToFloat(Coins.ONE_HUNDRED);
    }


    @Test
    public void canCompleteWholeTransactionNoChange(){
        Items selectedItem = vendingMachineReady.getProductByCode(1);
        assertEquals(cola, selectedItem);
        vendingMachineReady.addMoney(Coins.ONE_HUNDRED);
        assertEquals(100, vendingMachineReady.getTotalMoneyEntered());
        assertTrue(vendingMachineReady.enoughMoneyEnteredForItem(selectedItem));
        vendingMachineReady.transact();
        assertEquals(0, vendingMachineReady.getTotalMoneyEntered());
        vendingMachineReady.addCoinToFloat(Coins.FIFTY);
        vendingMachineReady.addCoinToFloat(Coins.FIFTY);
        assertEquals(1800, vendingMachineReady.getFloat());

    }



}
