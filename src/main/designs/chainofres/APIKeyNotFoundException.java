package main.designs.chainofres;

public class APIKeyNotFoundException extends Exception{
    @Override
    public String getMessage() {
        return "APIKeyNotFoundException: No Gemini API key provided in the request";
    }
}
