package main.designs.command;

public class DeleteOp implements Operation{
    private final Operand operand;

    public DeleteOp(Operand operand) {
        this.operand = operand;
    }

    @Override
    public void operation(String s) {
        operand.delete(s);
    }

    @Override
    public void undo() {
        operand.undo();
    }
}
