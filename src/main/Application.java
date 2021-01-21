package main;

import main.fsm.OrderEvent;
import main.fsm.OrderStateFSM;

public class Application {

    public static void main(String[] args) throws Exception {
        OrderState created
                 = new OrderState("created", "created");

        OrderState cancel
                = new OrderState("CANCEL", "cancel");

        OrderState activate
                = new OrderState("ACTIVATE", "activate");

        OrderStateFSM orderStateFSM = new OrderStateFSM();


        OrderEvent createEvent = new OrderEvent("create");
        OrderEvent cancelEvent = new OrderEvent("cancel");
        OrderEvent activateEvent = new OrderEvent("activate");

        orderStateFSM.addEventStateMap(createEvent, created);
        orderStateFSM.addEventStateMap(cancelEvent, cancel);
        orderStateFSM.addEventStateMap(activateEvent, activate);

        orderStateFSM.addTransition(created, cancel);
        orderStateFSM.addTransition(created, activate);
        orderStateFSM.addTransition(activate, cancel);

        Order o1 = new Order(created, 1);
        Order o2 = new Order(cancel, 2);
        Order o3 = new Order(activate, 3);

        Consumer cancelConsumer = new OrderConsumer(cancelEvent);
        Consumer createConsumer = new OrderConsumer(createEvent);
        Consumer activateConsumer = new OrderConsumer(activateEvent);

        MessageBroker messageBroker = new MessageBroker();

        messageBroker.addSubscriber(createEvent, createConsumer);
        messageBroker.addSubscriber(cancelEvent, cancelConsumer);
        messageBroker.addSubscriber(activateEvent, activateConsumer);

        OrderProducer producer = new OrderProducer(orderStateFSM, messageBroker);

        producer.send(cancelEvent, o3);

    }
}
