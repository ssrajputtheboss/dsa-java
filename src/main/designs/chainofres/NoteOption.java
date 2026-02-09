package main.designs.chainofres;

public class NoteOption extends Option{
    @Override
    public void handle(String text, String apiKey, OptionType optionType) throws APIKeyNotFoundException {
        super.handleDefault(apiKey);
        if(optionType == OptionType.note){
            System.out.println("Note: " + text);
        }else {
            next.handle(text,apiKey,optionType);
        }
    }
}
