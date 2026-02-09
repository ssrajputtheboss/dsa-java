package main.designs.chainofres;

public class SnippetOption extends Option{

    @Override
    public void handle(String text, String apiKey, OptionType optionType) throws APIKeyNotFoundException{
        super.handleDefault(apiKey);
        if(optionType == OptionType.snippet){
            // create a snippet
            System.out.println("Snippet : "+text );
        }else {
            next.handle(text,apiKey,optionType);
        }
    }
}
