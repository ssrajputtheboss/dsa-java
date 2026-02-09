package main.datastructures.tree.bst.redblack;

import main.datastructures.tree.bst.BinarySearchTree;
import main.datastructures.tree.treenode.redblack.RedBlackNode;

import java.util.Comparator;

public class RedBlackTree<T> extends BinarySearchTree<T> {
    @Override
    public RedBlackNode<T> getRoot() {
        return (RedBlackNode<T>) root;
    }

    public RedBlackTree(Comparator<T> comparator) {
        super(comparator);
    }

    private void lRotate(RedBlackNode<T> node){
        RedBlackNode<T> r = node.getRight(),
                rl = r.getLeft(), parent;
        node.setRight(rl);
        if(rl!=null){
            rl.setParent(node);
        }
        r.setParent(node.getParent());
        parent = r.getParent();
        node.setParent(r);
        r.setLeft(node);
        if(parent == null){
            root = r;
        } else if (parent.getLeft().compareTo(node) == 0) {
            parent.setLeft(r);
        }else {
            parent.setRight(r);
        }
    }

    private void rRotate(RedBlackNode<T> node){
        RedBlackNode<T> l = node.getLeft(),
                lr = l.getRight(), parent;
        node.setLeft(lr);
        if(lr!=null){
            lr.setParent(node);
        }
        l.setParent(node.getParent());
        parent = l.getParent();
        node.setParent(l);
        l.setRight(node);
        if(parent == null){
            root = l;
        } else if (parent.getLeft().compareTo(node) == 0) {
            parent.setLeft(l);
        }else {
            parent.setRight(l);
        }
    }

    private void insertBalance(RedBlackNode<T> node){
        RedBlackNode<T> p,g,u;
        // only root
        if(!node.hasParent()){
            node.setBlack();
            return;
        }
        p = node.getParent();
        if(p.isBlack()){
            return;
        }
        // if parent not root grandparent != null
        g = p.getParent();
        // can be null
        u = p.isLeftChild() ? g.getRight() : g.getLeft();
        if(u!=null && u.isRed()){
            u.setBlack();
            p.setBlack();
            g.setRed();
        }else{
            if(p.isLeftChild()){
                if(!node.isLeftChild()){
                    lRotate(p);
                    // node points to parent now
                    node.setBlack();
                }else{
                    p.setBlack();
                }
                g.setRed();
                rRotate(g);
            }else{
                if(node.isLeftChild()){
                    rRotate(p);
                    // node points to parent now
                    node.setBlack();
                }else{
                    p.setBlack();
                }
                g.setRed();
                lRotate(g);
            }
        }
        if(g.hasParent()){
            insertBalance(g);
            return;
        }
        if(root!=null){
            getRoot().setBlack();
        }
    }

    @Override
    public synchronized void insert(T value) {
        RedBlackNode<T> node = new RedBlackNode<>(value,comparator),
                parent = null,
                cur = getRoot();
        if(cur == null){
            root = node;
            node.setBlack();
            return;
        }
        int comp;
        while(cur!=null ){
            comp = node.compareTo(cur);
            parent = cur;
            if(comp < 0){
                cur = cur.getLeft();
            }else {
                cur = cur.getRight();
            }
        }
        comp = node.compareTo(parent);
        if(comp < 0){
            parent.setLeft(node);
        }else{
            parent.setRight(node);
        }
        node.setParent(parent);
        insertBalance(node);
    }

    private RedBlackNode<T> min(RedBlackNode<T> node){
        while (node.hasLeft()){
            node = node.getLeft();
        }
        return node;
    }

    private void replace(RedBlackNode<T> u, RedBlackNode<T> v){
        if(!u.hasParent()){
            root = v;
        } else if (u.isLeftChild()) {
            u.getParent().setLeft(v);
        }else {
            u.getParent().setRight(v);
        }
        if(v!=null)
            v.setParent(u.getParent());
    }

    private void deleteBalance(RedBlackNode<T> node){
        throw new UnsupportedOperationException("Operation not supported");
//        if(node == null || node.isRed() || !node.hasParent())return;
//        RedBlackNode<T> s;
//        if(node.isLeftChild()){
//            s = node.getParent().getRight();
//            if(s.isRed()){
//                s.setBlack();
//                node.getParent().setRed();
//                lRotate(node.getParent());
//                s = node.getParent().getRight();
//            }
//            if((s.getLeft() == null || s.getLeft().isBlack()) && (s.getRight() == null || s.getRight().isBlack()) ){
//                s.setRed();
//                node = node.getParent();
//            }else {
//                if(s.getRight() == null || s.getRight().isBlack()){
//                    if(s.hasLeft()){
//                        s.getLeft().setBlack();
//                        s.setRed();
//                        rRotate(s);
//                        s=s.getParent().getRight();
//                    }
//                    s.setIsBlack(s.getParent().isBlack());
//                    s.getParent().setBlack();
//                    if(s.hasRight()){
//                        s.getRight().setBlack();
//                    }
//                    lRotate(s.getParent());
//                }else {
//                    s=s.getParent().getLeft();
//                    if(s.isRed()){
//                        s.setBlack();
//                        s.getParent().setRed();
//                        rRotate(s.getParent());
//                        s=s.getParent().getLeft();
//                    }
//                    if ((s.getLeft() == null || s.getLeft().isBlack()) && (s.getRight() == null || s.getRight().isBlack()) ) {
//                        s.setRed();
//                    }
//                }
//            }
//        }

    }

    private void deleteUtil(RedBlackNode<T> delNode){
        RedBlackNode<T> temp = delNode,r;
        boolean isBlack = temp.isBlack();
        if(!delNode.hasLeft()){
            r = delNode.getRight();
            replace(delNode , r);
        } else if (!delNode.hasRight()) {
            r = delNode.getLeft();
            replace(delNode,r);
        }else {
            temp = min(delNode.getRight());
            isBlack = temp.isBlack();
            // temp != null always
            r = temp.getRight();
            if(temp.getParent().compareTo(delNode) == 0){
                // temp is immediate right child of delNode
                if(r!=null){
                    r.setParent(temp);
                }
            }else {
                replace(temp,r);
                temp.setRight(delNode.getRight());
            }
            replace(delNode,temp);
            temp.setLeft(delNode.getLeft());
            if(delNode.hasLeft()){
                delNode.getLeft().setParent(temp);
            }
            if (isBlack) {
                temp.setBlack();
            } else {
                temp.setRed();
            }
        }
        if(isBlack){
            deleteBalance(r);
        }
    }

    @Override
    public void delete(T value) {
        // find if node to be deleted exists
        RedBlackNode<T> delNode= (RedBlackNode<T>) find(value);
        if(delNode == null)return;
        deleteUtil(delNode);
    }
}
