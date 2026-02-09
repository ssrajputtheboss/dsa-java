package main.designs.observer;

import main.designs.mediator.State;

import java.util.ArrayList;
import java.util.List;

public class OApp {
    private State state;
    private final List<OUI> listeners;
    public OApp(State state){
        this.state = state;
        listeners = new ArrayList<>();
    }
    public void updateState(State state){
        this.state = state;
        notifyListeners();
    }

    public void addListener(OUI ui){
        listeners.add(ui);
    }

    public void removeListener(OUI ui){
        listeners.remove(ui);
    }
    private void notifyListeners(){
        listeners.forEach(ui -> ui.refreshState(state));
    }

}
