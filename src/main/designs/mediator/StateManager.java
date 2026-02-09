package main.designs.mediator;

import java.util.ArrayList;
import java.util.List;

public class StateManager {
    private final List<UI> listeners;

    public StateManager() {
        this.listeners = new ArrayList<>();
    }

    public void addListener(UI ui){
        listeners.add(ui);
    }
    public void removeListener(UI ui){
        listeners.remove(ui);
    }
    public void start(){
        listeners.forEach(UI::build);
    }
    public void notifyListeners(State state){
        listeners.forEach(ui -> ui.refreshState(state));
    }
}
