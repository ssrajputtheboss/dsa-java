package main.datastructures.tree.bst.avl;

import main.datastructures.tree.bst.BinarySearchTree;

import main.datastructures.tree.treenode.TreeNode;
import main.datastructures.tree.treenode.avlnode.AVLNode;

import java.util.Comparator;


public class AVLTree<T> extends BinarySearchTree<T> {
    public AVLTree(Comparator<T> comparator){
        super(comparator);
    }

    @Override
    public AVLNode<T> getRoot() {
        return (AVLNode<T>) root;
    }

    protected AVLNode<T> lRotate(AVLNode<T> cur){
        AVLNode<T> r = cur.getRight(),
                rl = r.getLeft();
        r.setLeft(cur);
        cur.setRight(rl);
        cur.setHeight();
        r.setHeight();
        return r;
    }

    protected AVLNode<T> rRotate(AVLNode<T> cur){
        AVLNode<T> l = cur.getLeft(),
                lr = l.getRight();
        l.setRight(cur);
        cur.setLeft(lr);
        cur.setHeight();
        l.setHeight();
        return l;
    }



    private AVLNode<T> deleteUtil(AVLNode<T> cur,AVLNode<T> delNode){
        if(cur == null)return null;
        int compValue = cur.compareTo(delNode);
        if(compValue == 0){
            if(cur.isLeaf()){
                return null;
            }else{
                // find largest in left subtree
                AVLNode<T> parent = cur , child = cur.getLeft();
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
        cur.setHeight();
        int bf= cur.getBalancingFactor();
        int compL = delNode.compareTo(cur.getLeft());
        int compR = delNode.compareTo(cur.getRight());
        // ll
        if(bf > 1 && compL < 0){
            return lRotate(cur.getLeft());
        }
        if(bf > 1){
            cur.setLeft(lRotate(cur.getLeft()));
            return rRotate(cur);
        }
        if(bf<-1 && compR >= 0){
            return rRotate(cur);
        }
        if(bf<-1) {
            cur.setRight(rRotate(cur.getRight()));
            return lRotate(cur);
        }
        return cur;

    }
    @Override
    public void delete(T value){
        root = deleteUtil(getRoot() , new AVLNode<>(value,comparator));
    }

    private AVLNode<T> insertUtil(AVLNode<T> cur, AVLNode<T> newNode){
        if(cur == null){
            return newNode;
        }
        int compare = newNode.compareTo(cur);
        if(compare < 0){
            cur.setLeft(insertUtil(cur.getLeft() , newNode));
        } else if (compare > 0) {
            cur.setRight(insertUtil(cur.getRight() , newNode));
        }else return cur;
        cur.setHeight();
        int bf= cur.getBalancingFactor();
        int compL = newNode.compareTo(cur.getLeft());
        int compR = newNode.compareTo(cur.getRight());
        // ll
        if(bf > 1 && compL < 0){
            return lRotate(cur.getLeft());
        }
        if(bf > 1){
            cur.setLeft(lRotate(cur.getLeft()));
            return rRotate(cur);
        }
        if(bf<-1 && compR >= 0){
            return rRotate(cur);
        }
        if(bf<-1) {
            cur.setRight(rRotate(cur.getRight()));
            return lRotate(cur);
        }
        return cur;

    }
    @Override
    public void insert(T value){
        AVLNode<T> node = new AVLNode<>(value,comparator);
        if(root == null){
            root = node;
        }else {
            root = insertUtil(getRoot(), node);
        }
    }


}
