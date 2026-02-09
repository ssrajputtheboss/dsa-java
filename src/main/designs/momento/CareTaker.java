package main.designs.momento;

import main.designs.mediator.State;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CareTaker {
    private final List<State> momentoList;
    public CareTaker(){
        momentoList = new ArrayList<>();
    }
    public void add(State state){
        momentoList.add(state);
    }
    public State undoState(int i){
        return momentoList.get(i);
    }
}
