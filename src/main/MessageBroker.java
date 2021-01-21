package main;

import com.sun.tools.corba.se.idl.constExpr.Or;
import main.fsm.Event;
import main.fsm.OrderEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MessageBroker implements Broker<OrderEvent, Consumer>{

    private HashMap<OrderEvent, List<Consumer>> eventSubscriber;

    public MessageBroker() {
        this.eventSubscriber = new HashMap<>();
    }

    @Override
    public synchronized void addSubscriber(OrderEvent event, Consumer consumer) {
        List<Consumer> consumers = eventSubscriber.getOrDefault(event, new ArrayList<>());
        consumers.add(consumer);
        eventSubscriber.put(event, consumers);
        return;
    }

    @Override
    public synchronized void notifySubscribers(OrderEvent event, String order) {
        List<Consumer> consumers = eventSubscriber.getOrDefault(event, new ArrayList<>());

        consumers.parallelStream().forEach(c -> {
            c.handle(order);
        });
    }
}
