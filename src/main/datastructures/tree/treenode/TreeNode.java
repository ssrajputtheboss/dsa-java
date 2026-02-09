package main.datastructures.tree.treenode;


import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.function.Function;

public class TreeNode<T> implements Comparator<TreeNode<T>>,Comparable<TreeNode<T>>, TreeNodeInterface<T>{

    protected T value;
    protected final Comparator<T> comparator;
    protected TreeNode<T> left,right;
    public TreeNode(T value, Comparator<T> comparator){
        this.value = value;
        this.comparator = comparator;
        left=right=null;
    }
    synchronized public void setLeft(TreeNodeInterface<T> node){
        this.left = (TreeNode<T>) node;
    }
    synchronized public void setRight(TreeNodeInterface<T> node){
        this.right = (TreeNode<T>) node;
    }

    public void setValue(T value){
        this.value = value;
    }

    public T getValue(){
        return value;
    }

    @Override
    public TreeNode<T> getLeft() {
        return left;
    }

    @Override
    public TreeNode<T> getRight() {
        return right;
    }

    public boolean hasLeft(){
        return left!=null;
    }
    public boolean hasRight(){
        return right!=null;
    }
    public boolean isLeaf(){
        return !hasLeft() && !hasRight();
    }

    @Override
    public int compare(TreeNode<T> o1, TreeNode<T> o2) {
        if(o1 == null && o2 == null)return 0;
        if(o1 == null)return -1;
        if(o2 == null)return 1;
        return comparator.compare(o1.getValue(),o2.getValue());
    }


    @Override
    public int compareTo(TreeNode<T> o) {
        return compare(this, o);
    }
    private void inOrderRecursive(TreeNode<T> node, TreeNodeOperation<T> operation){
        if(node == null)return;
        inOrderRecursive(node.getLeft(),operation);
        operation.operation(node);
        inOrderRecursive(node.getRight(),operation);
    }
    public Void inOrderRecursive(TreeNodeOperation<T> operation){
        inOrderRecursive(this , operation);
        return null;
    }
    private void preOrderRecursive(TreeNode<T> node, TreeNodeOperation<T> operation){
        if(node == null)return;
        operation.operation(node);
        preOrderRecursive(node.getLeft(),operation);
        preOrderRecursive(node.getRight(),operation);
    }
    public Void preOrderRecursive(TreeNodeOperation<T> operation){
        preOrderRecursive(this , operation);
        return null;
    }

    private void postOrderRecursive(TreeNode<T> node, TreeNodeOperation<T> operation){
        if(node == null)return;
        postOrderRecursive(node.getLeft(),operation);
        postOrderRecursive(node.getRight(),operation);
        operation.operation(node);
    }
    public Void postOrderRecursive(TreeNodeOperation<T> operation){
        postOrderRecursive(this , operation);
        return null;
    }

    public Void preOrder(TreeNodeOperation<T> operation){
        Stack<TreeNode<T>> st = new Stack<>();
        st.push(this);
        while (!st.isEmpty()){
            TreeNode<T> node = st.pop();
            operation.operation(node);
            if(node.hasLeft()){
                st.push(node.getLeft());
            }
            if(node.hasRight()){
                st.push(node.getRight());
            }
        }
        return null;
    }
    public Void inOrder(TreeNodeOperation<T> operation){
        Stack<TreeNode<T>> st = new Stack<>();
        TreeNode<T> node = this;
        while (node!=null || !st.isEmpty()){
            while (node!=null){
                st.push(node);
                node = node.getLeft();
            }
            node = st.pop();
            operation.operation(node);
            node = node.getRight();
        }
        return null;
    }

    public Void postOrder(TreeNodeOperation<T> operation){
        Stack<TreeNode<T>> st = new Stack<>(), st2 = new Stack<>();
        st.push(this);
        while (!st.isEmpty()){
            TreeNode<T> node = st.pop();
            st2.push(node);
            if(node.hasLeft()){
                st.push(node.getLeft());
            }
            if(node.hasRight()){
                st.push(node.getRight());
            }
        }
        while (!st2.isEmpty()){
            operation.operation(st2.pop());
        }
        return null;
    }

    public void reverse(Function<TreeNodeOperation<T> , Void> method, TreeNodeOperation<T> operation){
        Stack<TreeNode<T>> st = new Stack<>();
        method.apply(st::push);
        while (!st.isEmpty()){
            operation.operation(st.pop());
        }

    }

    @Override
    public String toString() {
        return value == null ? null :value.toString();
    }
}
