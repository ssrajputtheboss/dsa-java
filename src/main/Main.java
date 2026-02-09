package main;

import main.datastructures.core.ArrayOperations;
import main.datastructures.core.QueueAlgorithms;
import main.datastructures.core.StackAlgorithms;
import main.datastructures.tree.bst.avl.AVLTree;
import main.datastructures.tree.bst.redblack.RedBlackTree;
import main.datastructures.tree.cst.CompleteBinaryTree;
import main.datastructures.tree.segmenttree.SegmentTree;
import main.datastructures.tree.bst.BinarySearchTree;
import main.datastructures.tree.treenode.TreeNode;
import main.datastructures.tree.treenode.avlnode.AVLNode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Map;
import java.util.Stack;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void segmentTree(){
        //        CustomLogger.getInstance().enable();
        Integer[] x = {7,8,800,90,2,4,10,24,78,10,220,4,8768,65,65,65,67,7,6,76,767};
        SegmentTree<Integer> segmentTree = new SegmentTree<>(
                x.length,
                Integer.MIN_VALUE,
                Integer::max
        );

        segmentTree.setDefaultCollectionValue(0);
        segmentTree.initialize(x);
        System.out.println(segmentTree.query(0,10));
        segmentTree.update(1,30000);
        System.out.println(segmentTree.query(0,10));
//        segmentTree.print();
    }

    public static void bst(){
        BinarySearchTree<Integer> bTree = new BinarySearchTree<>(Integer::compare);
        bTree.insert(10);
        bTree.insert(5);
        bTree.insert(15);
        bTree.insert(2);
        bTree.insert(8);
        bTree.insert(12);
        bTree.insert(16);
        TreeNode<Integer> root = bTree.getRoot();
        root.inOrder((node -> System.out.println(node.getValue())));
        System.out.println(bTree.find(5).getValue());
        bTree.delete(10);
        System.out.println("------");
        bTree.print();
    }

    public static void avl(){
//        CustomLogger.getInstance().enable();
        AVLTree<Integer> avlTree = new AVLTree<>(Integer::compare);
        avlTree.insert(1);
        avlTree.insert(100);
        avlTree.insert(0);
        avlTree.insert(5);
        avlTree.insert(99);
        avlTree.insert(80);
        avlTree.insert(19);
        avlTree.insert(190);
        avlTree.insert(20);
        avlTree.delete(19);
        System.out.println(avlTree.find(19));
//        avlTree.print();
        AVLNode<Integer> root = avlTree.getRoot();
//        root.inOrder((node -> System.out.println(node.getValue())));
        root.reverse(root::inOrder,(node -> System.out.println(node.getValue())));
    }

    public static void rbt(){
        RedBlackTree<Integer> rbTree = new RedBlackTree<>(Integer::compare);
        rbTree.insert(10);
        rbTree.insert(20);
        rbTree.insert(30);
        rbTree.getRoot().postOrder(System.out::println);
        System.out.println(rbTree.find(100));
    }

    public static void cbt(){
        CompleteBinaryTree<Integer> completeBinaryTree = new CompleteBinaryTree<>(
                (x,y)->Integer.compare(y,x)
        );
        completeBinaryTree.insert(10);
        completeBinaryTree.insert(100);
        completeBinaryTree.insert(50);
        completeBinaryTree.insert(1);
        System.out.println(completeBinaryTree.poll());
        System.out.println(completeBinaryTree.poll());
        completeBinaryTree.print();
    }

    public static void sorting(){
        Integer[] a = new Integer[]{10,9,8,7,6,5,4};
        ArrayOperations.mergeSort(a,Integer::compare);
        ArrayOperations.print(a);
    }

    public static void queueStack(){
    }

    public static void main(String[] args) {
//        bst();
//        avl();
//        rbt();
//        cbt();
//        sorting();
//        segmentTree();

    }
}