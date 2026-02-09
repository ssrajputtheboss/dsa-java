package main.designs.annotation;


public class Main {
    public static void main(String[] args) {
        Person person = new Person(
                "John","cena","10","Palo Alto"
        );
        ObjectToJsonConverter objectToJsonConverter = new ObjectToJsonConverter();
        try {
            String s = objectToJsonConverter.convertToJson(person);
            System.out.println(s);
        }catch (JsonSerializationException e) {
            System.out.println("Error");
        }

    }
}
