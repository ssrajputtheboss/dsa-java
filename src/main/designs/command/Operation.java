package main.designs.command;

public interface Operation {
    void operation(String s);
    void undo();
}
