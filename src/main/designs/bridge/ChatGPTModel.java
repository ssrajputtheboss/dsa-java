package main.designs.bridge;

import main.designs.chainofres.APIKeyNotFoundException;
import main.designs.chainofres.Option;

public class ChatGPTModel extends AIModel{
    public ChatGPTModel(Option option, String apiKey, String modelName) {
        super(option, apiKey, modelName);
    }

    @Override
    protected String generate(String prompt) {
        return modelName + " -> " + prompt;
    }

    @Override
    public void generate(String text, Option.OptionType optionType) throws APIKeyNotFoundException {
        String prompt = generatePrompt(optionType) + text;
        option.handle(generate(prompt), apiKey,optionType);
    }
}
