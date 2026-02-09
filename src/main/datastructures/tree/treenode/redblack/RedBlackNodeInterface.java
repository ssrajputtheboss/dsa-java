package main.datastructures.tree.treenode.redblack;

import main.datastructures.tree.treenode.TreeNodeInterface;

public interface RedBlackNodeInterface<T> extends TreeNodeInterface<T> {
    public boolean isBlack();
    public boolean isRed();
    public void setBlack();
    public void setRed();
    public boolean isLeftChild();
    public boolean hasParent();

}
