package main.designs.state;

public class ReducerState implements State{
    @Override
    public void execute(Context context) {
        IterableState iterableState = (IterableState) context.getState();

        System.out.println(iterableState.getData().stream().reduce(0, Math::addExact));
    }

}
