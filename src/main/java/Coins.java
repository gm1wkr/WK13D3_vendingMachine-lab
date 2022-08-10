public enum Coins {

    ONE(1, false),
    TWO(2, false),

    FIVE(5, true),
    TEN(10, true),
    TWENTY(20, true),
    FIFTY(50, true),
    ONE_HUNDRED(100, true);

    private int value;
    private boolean isAccepted;

    Coins(int value, boolean isAccepted){
        this.value = value;
        this.isAccepted = isAccepted;
    }

    public int getCoinValue(){
        return this.value;
    }

    public boolean isCoinAccepted() {
        return this.isAccepted;
    }
}
