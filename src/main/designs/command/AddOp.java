package main.designs.command;

public class AddOp implements Operation{
    private final Operand operand;

    public AddOp(Operand operand) {
        this.operand = operand;
    }

    @Override
    public void operation(String s) {
        operand.add(s);
    }

    @Override
    public void undo() {
        operand.undo();
    }
}
