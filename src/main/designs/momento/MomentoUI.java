package main.designs.momento;

import main.designs.mediator.State;
import main.designs.mediator.UI;

public class MomentoUI extends UI {
    public MomentoUI(String s, State state) {
        super(s, state);
    }

    public State saveMomento(){
        return super.getState().clone();
    }
}
