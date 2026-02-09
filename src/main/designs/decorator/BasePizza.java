package main.designs.decorator;

public class BasePizza implements Pizza{
    @Override
    public String bake() {
        return "Base Pizza";
    }
}
