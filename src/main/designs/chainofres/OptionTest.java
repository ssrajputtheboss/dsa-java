package main.designs.chainofres;

public class OptionTest {
    public void test() throws APIKeyNotFoundException {
        SnippetOption op1 = new SnippetOption();
        NoteOption op2 = new NoteOption();
        TaskOption op3 = new TaskOption();
        op1.setNext(op2);
        op2.setNext(op3);
        op1.handle("test","api", Option.OptionType.none);
    }
}
