package main.designs.momento;


import main.designs.mediator.State;

public class MomentoApp {
    public static void main(String[] args) {
        CareTaker careTaker = new CareTaker();
        State state1 = new State("state1"),state2 = new State("state2");
        MomentoUI button = new MomentoUI("button",state1);
        button.build();
        careTaker.add(button.saveMomento());
        button.refreshState(state2);
        careTaker.add(state2);
        // undo to state 1
        button.refreshState(careTaker.undoState(0));
    }
}
