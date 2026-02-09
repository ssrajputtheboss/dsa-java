package main.designs.state;

import java.util.Arrays;

public class StateMachine {
    public static void main(String[] args) {
        IterableState startState = new IterableState() {};
        startState.setData(Arrays.asList(-1,-2,-3,1,2,3));
        Context context = new Context(startState);
        FilterState filterState = new FilterState();
        filterState.execute(context);
        ReducerState reducerState = new ReducerState();
        reducerState.execute(context);
    }
}
