package main.designs.observer;

public class ObserverAppRunner {
    public static void main(String[] args) {
        OState state = new OState("state1"),state1,state2;
        OApp app = new OApp(state);
        OUI button = new OUI("button",state),
                input = new OUI("input",state);
        app.addListener(button);
        app.addListener(input);
        button.build();
        input.build();

        state1 = (OState) state.clone();
        state1.update("state2");
        state2 = (OState) state.clone();
        state2.update("state3");
        app.updateState(state1);
        app.removeListener(input);
        app.updateState(state2);

    }
}
