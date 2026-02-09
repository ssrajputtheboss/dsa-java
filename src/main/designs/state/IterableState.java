package main.designs.state;


import java.util.List;
public abstract class IterableState implements State {
    private List<Integer> data;

    protected List<Integer> getData() {
        return data;
    }

    protected void setData(List<Integer> data) {
        this.data = data;
    }

    @Override
    public void execute(Context context) {
        context.setState(this);
    }
}
