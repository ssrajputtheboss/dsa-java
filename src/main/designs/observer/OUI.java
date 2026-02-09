package main.designs.observer;

import main.designs.mediator.State;
import main.designs.mediator.UI;

public class OUI extends UI {
    public OUI(String s, State state) {
        super(s, state);
    }
}
