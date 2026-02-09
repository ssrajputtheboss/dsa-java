package main.datastructures.tree.treenode.avlnode;

import main.datastructures.tree.treenode.TreeNode;
import main.datastructures.tree.treenode.TreeNodeInterface;

import java.util.Comparator;
import static java.lang.Math.max;

public class AVLNode<T> extends TreeNode<T> implements AVLNodeInterface<T>{
    private int height;

    public AVLNode(T value, Comparator<T> comparator) {
        super(value, comparator);
        left = right = null;
        height = 1;
    }

    @Override
    synchronized public void setLeft(TreeNodeInterface<T> left) {
        this.left = (AVLNode<T>) left;
    }

    @Override
    synchronized public void setRight(TreeNodeInterface<T> right) {
        this.right = (AVLNode<T>) right;
    }


    @Override
    public AVLNode<T> getLeft() {
        return (AVLNode<T>) left;
    }

    @Override
    public AVLNode<T> getRight() {
        return (AVLNode<T>)  right;
    }

    @Override
    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public void setHeight() {
        height = max(getLeft() == null ? 0 : getLeft().getHeight(), getRight() == null ? 0 : getRight().getHeight());
    }

    @Override
    public int getBalancingFactor() {
        int l = this.left == null ? 0 : this.getLeft().getHeight();
        int r = this.right == null ? 0 : this.getRight().getHeight();
        return l-r;
    }
}
