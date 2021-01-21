package main.fsm;

public class Event {

    public Event(String eventName) {
        this.eventName = eventName;
    }

    String eventName;

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }
}
