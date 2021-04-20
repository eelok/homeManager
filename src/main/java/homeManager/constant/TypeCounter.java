package homeManager.constant;

public enum TypeCounter {
    cold(0),
    hot(1),
    electricity(2);

    private final int countersType;

    TypeCounter(int countersType) {
        this.countersType = countersType;
    }

    public int getCountersType(){
        return this.countersType;
    }
}
