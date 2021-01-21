package main;

public interface Broker<T, D> {

    void addSubscriber(T event, D consumer);

    void notifySubscribers(T event, String message);
}
