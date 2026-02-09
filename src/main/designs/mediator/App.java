package main.designs.mediator;

public class App {
    public static void main(String[] args) {
        State state = new State("initialState");
        UI button = new UI("Button",state),
                input = new UI("Input",state);
        StateManager stateManager= new StateManager();
        stateManager.addListener(button);
        stateManager.addListener(input);
        stateManager.start();
        state.update("state2");
        stateManager.notifyListeners(state);
    }
}
