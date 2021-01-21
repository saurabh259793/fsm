package main;

public class OrderState extends State {

    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public OrderState(String name, String description) {
        super(name);
        this.description = description;

    }

    String description;
}
