package main.designs.decorator;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class PizzaProcessor {
    @Toppings(chicken = true,cheeseBurst = true)
    public Pizza pizza;

    public void addToppings(Pizza pizza){
        Class<?> c = this.getClass(),cPizza;
        for(Field field : c.getDeclaredFields()){
            field.setAccessible(true);
            if(field.isAnnotationPresent(Toppings.class) ){
                cPizza = pizza.getClass();
                try {
                    Method method = cPizza.getMethod("bake");
                    Object ret = method.invoke(pizza);
                    String base = ret.toString();
                    Annotation annotation = field.getAnnotation(Toppings.class);
                    boolean chicken = (boolean) annotation.annotationType().getMethod("chicken").invoke(annotation);
                    boolean cheeseBurst = (boolean)annotation.annotationType().getMethod("cheeseBurst").invoke(annotation);
                    if(cheeseBurst){
                        base += " With Cheese Burst ";
                    }
                    if(chicken){
                        base += " With Chicken";
                    }
                    System.out.println(base);
                }catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e){
                    System.out.println(e);
                }
            }
        }
    }

}
