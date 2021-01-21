package main;

import main.fsm.OrderEvent;
import main.fsm.OrderStateFSM;

public class OrderProducer implements Producer<OrderEvent, Order> {

    OrderStateFSM orderStateFSM;

    MessageBroker messageBroker;

    public OrderProducer(OrderStateFSM orderStateFSM, MessageBroker messageBroker) {
        this.orderStateFSM = orderStateFSM;
        this.messageBroker = messageBroker;
    }

    @Override
    public synchronized void send(OrderEvent event, Order entity) throws Exception {
        orderStateFSM.changeState(entity, event);
        messageBroker.notifySubscribers(event, entity.toString());
    }
}
