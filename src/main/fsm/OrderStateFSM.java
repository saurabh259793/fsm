package main.fsm;

import javafx.util.Pair;
import main.Order;
import main.OrderState;

import java.util.HashMap;

public class OrderStateFSM implements FSM<OrderState, OrderEvent, Order> {


    private HashMap<String, OrderState> eventMap;

    private HashMap<Pair<OrderState, OrderState>, Boolean> allowedTransition;

    public OrderStateFSM() {
        eventMap = new HashMap<>();
        allowedTransition = new HashMap<>();
    }

    @Override
    public boolean isTransitionPossible(OrderState orderState, OrderEvent event) {

        if (!eventMap.containsKey(event.getEventName()))
            return false;

        OrderState dest = eventMap.get(event.getEventName());

        if (!allowedTransition.getOrDefault(new Pair<>(orderState, dest), false))
            return false;

        return true;
    }

    @Override
    public void changeState(Order order, OrderEvent event) throws Exception {

        if (isTransitionPossible(order.getOrderState(), event)) {
            order.setOrderState(eventMap.get(event));
            return;
        }

        throw new Exception("Transition not possible");

    }

    public synchronized void addEventStateMap(OrderEvent orderEvent, OrderState orderState) {
        eventMap.put(orderEvent.getEventName(), orderState);
        return;
    }

    @Override
    public synchronized void addTransition(OrderState initial, OrderState desst) {

        allowedTransition.put(new Pair<>(initial, desst), true);

        return;
    }
}
