package main.designs.decorator;

public class ChickenDecorator extends PizzaDecorator{

    public ChickenDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String bake() {
        return pizza.bake() + " With Chicken ";
    }
}
