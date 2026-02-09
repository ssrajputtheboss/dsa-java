package main.designs.chainofres;

abstract public class Option {
    protected Option next = new Option() {
        // this function is default when no option is matches
        @Override
        public void handle(String text, String apiKey, OptionType optionType) throws APIKeyNotFoundException {
            // by default choose note
            System.out.println("Note:" + text);
        }
    };
    public enum OptionType{
        none,
        snippet,
        task,
        note
    }

    public void setNext(Option option){
        next = option;
    }
    protected void handleDefault(String apiKey) throws APIKeyNotFoundException{
        if( apiKey!=null && apiKey.isEmpty()){
            throw new APIKeyNotFoundException();
        }
    }
    abstract public void handle(String text,String apiKey, OptionType optionType) throws APIKeyNotFoundException;
}
