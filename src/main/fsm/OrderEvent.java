package main.fsm;

public class OrderEvent extends Event {

    public OrderEvent(String eventName) {
        super(eventName);
    }

    public String getEventName() {
        return eventName;
    }
}
