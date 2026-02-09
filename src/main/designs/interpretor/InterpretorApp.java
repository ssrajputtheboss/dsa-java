package main.designs.interpretor;

public class InterpretorApp {

    public static void main(String[] args) {
        TerminalExpression e1 = new TerminalExpression("John"),
                e2 = new TerminalExpression("Man");
        System.out.println(new OrExpression(e1,e2).interpret("John"));
        System.out.println(new AndExpression(e1,e2).interpret("JohnisMan"));
    }
}
