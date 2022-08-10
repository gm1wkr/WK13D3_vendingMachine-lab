import java.util.ArrayList;

public class VendingMachine {

    private ArrayList<Items> stockedItems;
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

            this.totalMoneyEntered += coin.getCoinValue();

    }

    public boolean enoughMoneyEnteredForItem(Items product) {
        return this.getTotalMoneyEntered() >= product.getPrice();
    }

    public boolean isCoinAccepted(Coins coin) {
        return coin.isCoinAccepted();
    }
}
