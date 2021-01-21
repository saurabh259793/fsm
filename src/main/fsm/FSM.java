package main.fsm;

public interface FSM<T, D, G> {

    boolean isTransitionPossible(T state, D event);

    void addTransition(T state, T dest);

    void changeState(G entity, D event) throws Exception;
}
