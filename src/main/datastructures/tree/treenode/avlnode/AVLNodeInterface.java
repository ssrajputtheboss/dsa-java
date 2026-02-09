package main.datastructures.tree.treenode.avlnode;

import main.datastructures.tree.treenode.TreeNodeInterface;

public interface AVLNodeInterface<T> extends TreeNodeInterface<T> {
    public void setHeight(int x);
    public int getHeight();
    public void setHeight();
    public int getBalancingFactor();
}
