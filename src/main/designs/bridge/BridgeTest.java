package main.designs.bridge;

import main.designs.chainofres.APIKeyNotFoundException;
import main.designs.chainofres.NoteOption;
import main.designs.chainofres.Option;
import main.designs.chainofres.SnippetOption;

public class BridgeTest {
    static void test(){
        SnippetOption op1 = new SnippetOption();
        NoteOption op2 = new NoteOption();
        AIModel gemini = new GeminiModel(
                op1,
                "test",
                "1.5"
        ), chatGPT = new ChatGPTModel(
                        op2,"tss","o3"
                );
        try {
            gemini.generate("hello", Option.OptionType.none);
        } catch (APIKeyNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
