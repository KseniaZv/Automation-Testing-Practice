package task3;

public class Pizza {
    private String name;
    private int weight;
    private Price cooking;
    private Price delivery;
    private String[] ingredients;

    public Pizza() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Price getCooking() {
        return cooking;
    }

    public void setCooking(Price cooking) {
        this.cooking = cooking;
    }

    public Price getDelivery() {
        return delivery;
    }

    public void setDelivery(Price delivery) {
        this.delivery = delivery;
    }

    public String[] getIngredients() {
        return ingredients;
    }

    public void setIngredients(String[] ingredients) {
        this.ingredients = ingredients;
    }

}