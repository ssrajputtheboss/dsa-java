package main.datastructures.tree.treenode.redblack;
import main.datastructures.tree.treenode.TreeNode;
import main.datastructures.tree.treenode.TreeNodeInterface;
import java.util.Comparator;

public class RedBlackNode<T> extends TreeNode<T> implements RedBlackNodeInterface<T> {
    private boolean isBlack;
    private RedBlackNode<T> parent;

    public RedBlackNode(T value, Comparator<T> comparator) {
        super(value, comparator);
        isBlack = false;
        parent=null;
    }

    @Override
    synchronized public void setLeft(TreeNodeInterface<T> left) {
        this.left = (RedBlackNode<T>) left;
    }

    @Override
    synchronized public void setRight(TreeNodeInterface<T> right) {
        this.right = (RedBlackNode<T>) right;
    }


    @Override
    public RedBlackNode<T> getLeft() {
        return (RedBlackNode<T>) left;
    }

    @Override
    public RedBlackNode<T> getRight() {
        return (RedBlackNode<T>)  right;
    }

    public RedBlackNode<T> getParent(){
        return parent;
    }

    public void setParent(RedBlackNode<T> node){
        parent=node;
    }

    @Override
    public boolean isBlack() {
        return isBlack;
    }

    @Override
    public boolean isRed() {
        return !isBlack;
    }

    @Override
    public void setBlack() {
        isBlack=true;
    }

    @Override
    public void setRed() {
        isBlack=false;
    }

    public void setIsBlack(boolean isBlack){
        this.isBlack=isBlack;
    }

    @Override
    public boolean isLeftChild() {
        if(!hasParent())return false;
        return this.compareTo(parent.getLeft()) == 0;
    }

    @Override
    public boolean hasParent() {
        return parent != null;
    }

    @Override
    public String toString() {
        return (isBlack?"B":"R") + "=>" + value;
    }
}
