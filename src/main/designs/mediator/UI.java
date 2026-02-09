package main.designs.mediator;

public class UI {
    private final String s;
    private State state;

    public UI(String s, State state) {
        this.s = s;
        this.state = state;
    }

    public void refreshState(State state){
        this.state = state;
        build();
    }

    public State getState(){
        return state;
    }

    public void build(){
        System.out.println(s);
        System.out.println(state);
        System.out.println("----");
    }
}
