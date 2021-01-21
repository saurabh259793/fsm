package main;

public class Order extends Entity {


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Order(OrderState orderState, int id) {
        super(orderState);
        this.id = id;
    }
    private int id;
}
