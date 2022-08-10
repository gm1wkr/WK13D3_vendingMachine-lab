public class Items {

    private String productName;

    private int selectionCode;
    private int price;
    private int quantity;

    public Items(String product, int price, int quantity, int selectionCode) {
        this.productName = product;
        this.price = price;
        this.quantity = quantity;
        this.selectionCode = selectionCode;
    }

    public String getProduct() {
        return productName;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    public void reduceStockByOne() {
        if(this.getQuantity() >= 1){
            this.quantity -= 1;
        }
    }

    public int getSelectionCode() {
        return this.selectionCode;
    }
}
