package main.designs.builder;

import main.designs.common.User;

public class Test {
    static void test(){
        User u1 = new User("You", "https://blah.com","1"),
                u2 = new User("Test","https://test.com","2");
        Message message =  new Message.MessageBuilder()
                .setText("Hi")
                .setFrom(u1)
                .setTo(u2)
                .setTime( Long.toString(System.currentTimeMillis()))
                .build();
        System.out.println(message.toString());
    }
}
