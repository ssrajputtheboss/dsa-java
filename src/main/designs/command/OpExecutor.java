package main.designs.command;

import java.util.ArrayList;
import java.util.Stack;

public class OpExecutor {
    private Stack<Operation> st = new Stack<>();
    private ArrayList<Operation> ops = new ArrayList<>();
    public void addOperation(Operation op){
        st.push(op);
        ops.add(op);
    }
    public void undo(){
        if(ops.isEmpty())return;
        ops.remove(ops.size()-1);
        st.pop().undo();
    }
    public void execute(String s){
        for(Operation op  : ops){
            op.operation(s);
        }
    }
    public static void test(){
        OpExecutor executor = new OpExecutor();
        executor.addOperation(new AddOp(new Operand()));
        executor.addOperation(new DeleteOp(new Operand()));
        executor.execute("j");
    }
}
