package main.designs.bridge;

import main.designs.chainofres.APIKeyNotFoundException;
import main.designs.chainofres.Option;

abstract public class AIModel {
    protected final String apiKey,modelName;
    protected Option option;
    public AIModel(Option option,String apiKey,String modelName){
        this.option = option;
        this.apiKey = apiKey;
        this.modelName = modelName;
    }
    protected String generatePrompt(Option.OptionType optionType){
        return "Create a " +
                switch (optionType) {
                    case task -> "task";
                    case snippet -> "snippet";
                    default -> "note";
                } +
                " with the given text : ";
    }
    abstract protected String generate(String prompt);
    abstract public void generate(String text, Option.OptionType optionType) throws APIKeyNotFoundException;
}
