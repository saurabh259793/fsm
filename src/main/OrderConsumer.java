package main;

import main.fsm.Event;

public class OrderConsumer extends Consumer {

    Event event;

    public OrderConsumer(Event event) {
        super(event);
    }

    @Override
    public void handle(String order) {
        System.out.println(order + " event consumed");
    }
}
