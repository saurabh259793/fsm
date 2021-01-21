package main;

import main.fsm.Event;

public abstract class Consumer {

    private Event event;

    public Consumer(Event event) {
        this.event = event;
    }

    public abstract void handle(String entity);
}
