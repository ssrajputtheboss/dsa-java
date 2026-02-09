package main.designs.chainofres;

public class TaskOption extends Option{
    @Override
    public void handle(String text, String apiKey, OptionType optionType) throws APIKeyNotFoundException {
        super.handleDefault(apiKey);
        if(optionType.equals(OptionType.task)){
            System.out.println("Task: " + text);
        }else {
            next.handle(text,apiKey,optionType);
        }
    }
}
