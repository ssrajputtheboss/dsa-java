package main.datastructures.tree.bst;

import main.datastructures.core.DataStructure;
import main.datastructures.tree.treenode.TreeNode;
import main.datastructures.tree.treenode.TreeNodeInterface;

import java.util.Comparator;
import java.util.Stack;

public class BinarySearchTree<T> extends DataStructure {
    protected TreeNode<T> root = null;
    protected final Comparator<T> comparator;
    public BinarySearchTree(Comparator<T> comparator){
        this.comparator = comparator;
    }

    public TreeNode<T> getRoot(){
        return root;
    }

    synchronized public void insert(T value){
        TreeNode<T> node = new TreeNode<>(value, comparator);
        if(root == null){
            root = node;
        }else {
            TreeNode<T> cur = root;
            // prevent infinite recursion
            int maxTries = BinarySearchTree.maxTries;
            while(maxTries > 0){
                maxTries--;
                // go left
                if(node.compareTo(cur) <0){
                    if(cur.hasLeft()){
                        cur = cur.getLeft();
                    }else {

                        cur.setLeft(node);
                        break;
                    }
                }else{
                    if(cur.hasRight()){
                        cur = cur.getRight();
                    }else {
                        cur.setRight(node);
                        break;
                    }
                }
            }
            if(maxTries<=0)
                logger.log("Infinite recursion found");
        }
    }

    synchronized public TreeNode<T> find(T value){
        if(root == null)return null;
        TreeNode<T> node = new TreeNode<>(value, comparator);
        TreeNode<T> cur = root;
        // prevent infinite recursion
        int maxTries = BinarySearchTree.maxTries;
        while(maxTries > 0){
            maxTries--;
            // go left
            if (node.compareTo(cur) == 0)return cur;
            if(node.compareTo(cur) <0){
                if(cur.hasLeft()){
                    cur = cur.getLeft();
                }else {
                    break;
                }
            }else{
                if(cur.hasRight()){
                    cur = cur.getRight();
                }else {
                    break;
                }
            }
        }
        if(maxTries<=0)
            logger.log("Infinite recursion found");
        return null;

    }

    synchronized private TreeNode<T> deleteUtil(TreeNode<T> cur, TreeNode<T> delNode){
        if(cur == null)return null;
        int compValue = cur.compareTo(delNode);
        if(compValue == 0){
            if(cur.isLeaf()){
                return null;
            }else{
                // find largest in left subtree
                TreeNode<T> parent = cur , child = cur.getLeft();
                // if no left subtree return right node
                if(child==null){
                    return cur.getRight();
                }
                // if no right return left
                if(cur.getRight() == null){
                    return child;
                }

                if(child.getRight() == null){
                    cur.setValue(child.getValue());
                    cur.setLeft(child.getLeft());
                    return cur;
                }
                while (child.getRight()!=null){
                    parent = child;
                    child = child.getRight();
                }
                cur.setValue(child.getValue());
                parent.setRight(null);
            }
        }else{
            if(compValue < 0 ){
                // cur < del , del> cur, search del in right
                if(cur.hasRight()){
                    cur.setRight(deleteUtil(cur.getRight() , delNode));
                }
            }else{
                if(cur.hasLeft()){
                    cur.setLeft(deleteUtil(cur.getLeft() , delNode));
                }
            }
        }
        return cur;
    }

    public void delete(T value){
        root = deleteUtil(root, new TreeNode<>(value, comparator));
    }

    synchronized protected void print(TreeNodeInterface<T> root){
        if(root == null){
            System.out.println("Empty Tree");
            return;
        }
        Stack<TreeNodeInterface<T>> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNodeInterface<T> node = stack.pop();
            System.out.println(node.getValue());
            if(node.hasLeft()){
                stack.push(node.getLeft());
            }
            if(node.hasRight()){
                stack.push(node.getRight());
            }
        }
    }

    public void print(){
        print(root);
    }

}
