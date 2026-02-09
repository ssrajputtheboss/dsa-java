package main.designs.decorator;

public class Main {
    public static void main(String[] args) {
//        Pizza pizza = new ChickenDecorator(
//                new CheeseBurstDecorator(
//                        new BasePizza()
//                )
//        );
//        System.out.println(pizza.bake());
        Pizza base = new BasePizza();
        PizzaProcessor processor = new PizzaProcessor();
        processor.pizza = base;
        processor.addToppings(base);
    }
}
