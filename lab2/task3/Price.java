package task3;

public class Price {
    private int number;
    private String currency;

    public Price() {}

    public Price(int number, String currency) {
        super();
        this.number = number;
        this.currency = currency;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

}