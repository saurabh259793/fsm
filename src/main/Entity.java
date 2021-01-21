package main;

public class Entity {
    public Entity(OrderState  state) {
        this.state = state;
    }

    OrderState state;

    public OrderState getOrderState() {
        return state;
    }

    public void setOrderState(OrderState state) {
        this.state = state;
    }
}
