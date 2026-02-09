package main.designs.mediator;

public class State implements Cloneable{
    private String stateName;

    public State(String stateName) {
        this.stateName = stateName;
    }

    public void update(String s){
        stateName = s;
    }

    public String getStateName() {
        return stateName;
    }

    @Override
    public String toString() {
        return "State{" +
                "stateName='" + stateName + '\'' +
                '}';
    }

    @Override
    public State clone() {
        try {
            return (State) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
