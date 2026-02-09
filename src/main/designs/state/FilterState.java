package main.designs.state;

import java.util.List;

public class FilterState extends IterableState{
    @Override
    public void execute(Context context) {
        IterableState iterableState = (IterableState) context.getState();
        iterableState.setData(iterableState.getData().stream().filter(x -> x > 0).toList());
        context.setState(iterableState);
    }
}
