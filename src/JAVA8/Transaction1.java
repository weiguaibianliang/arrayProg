package JAVA8;

public class Transaction1 {
    private  Trader1 trader1;
    private  int year;
    private  int value;



    public Transaction1(Trader1 trader1, int year, int value) {
        this.trader1 = trader1;
        this.year = year;
        this.value = value;
    }

    public Trader1 getTrader1() {
        return trader1;
    }

    public int getYear() {
        return year;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Transaction1{" +
                "trader1=" + trader1 +
                ", year=" + year +
                ", value=" + value +
                '}';
    }
}
