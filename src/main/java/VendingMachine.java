import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class VendingMachine {

    private ArrayList<Items> stockedItems;

    private HashMap<Coins, Integer> coinBin = new HashMap<>();
    private int totalMoneyEntered;

    public VendingMachine() {
        this.stockedItems = new ArrayList<>();
        this.totalMoneyEntered = 0;
    }

    public ArrayList<Items> getStockedItems() {
        return stockedItems;
    }

     public int getTotalMoneyEntered() {
        return totalMoneyEntered;
    }

    public void setTotalMoneyEntered(int totalMoneyEntered) {
        this.totalMoneyEntered = totalMoneyEntered;
    }

    public int getNumberOfProducts() {
        return stockedItems.size();
    }

    public void addProduct(Items product) {
        this.getStockedItems().add(product);
    }

    public int getItemsRemaining(Items product) {
        return product.getQuantity();
    }

    public void removeItemFromStock(Items product) {
        product.reduceStockByOne();
    }

    public Items getProductByCode(int productCode) {
        for (Items item : stockedItems){
            if(item.getSelectionCode() == productCode){
                return item;
            }
        }
        return null;
    }


    public boolean hasStock(Items product) {
        return product.getQuantity() > 0;
    }

    public void addMoney(Coins coin) {
        if(isCoinAccepted(coin)) {
            this.totalMoneyEntered += coin.getCoinValue();
        }

    }

    public boolean enoughMoneyEnteredForItem(Items product) {
        return this.getTotalMoneyEntered() >= product.getPrice();
    }

    public boolean isCoinAccepted(Coins coin) {
        return coin.isCoinAccepted();
    }

    public int calculateChange(Items product) {
        return this.getTotalMoneyEntered() - product.getPrice();
    }

    public void addToFloat(Coins denomination, int numberOf) {
        coinBin.put(denomination, numberOf);
    }

    public int getFloat() {
        int runningTotal = 0;
        for(Map.Entry<Coins, Integer> denomination : coinBin.entrySet()){
            runningTotal += denomination.getKey().getCoinValue() * denomination.getValue();
        }
        return runningTotal;
    }



}
