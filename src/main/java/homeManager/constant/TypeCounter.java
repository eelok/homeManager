package homeManager.constant;

public enum TypeCounter {
    COLD(0),
    HOT(1),
    ELECTRICITY(2);

    private final int countersType;

    TypeCounter(int countersType) {
        this.countersType = countersType;
    }

    public int getCountersType(){
        return this.countersType;
    }
}
