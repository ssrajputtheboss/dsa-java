package main.datastructures.tree.treenode;

import java.util.Comparator;

public interface TreeNodeInterface<T>{
    public void setLeft(TreeNodeInterface<T> node);
    public void setRight(TreeNodeInterface<T> node);

    public void setValue(T value);
    public T getValue();

    public TreeNodeInterface<T> getLeft();

    public TreeNodeInterface<T> getRight();

    public boolean hasLeft();
    public boolean hasRight();
    public boolean isLeaf();
}
