package main;

public interface Producer<T, D> {

    void send(T event, D entity) throws Exception;
}
