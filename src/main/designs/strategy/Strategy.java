package main.designs.strategy;

import main.datastructures.core.ArrayOperations;


public class Strategy {
    public static void main(String[] args) {
        Integer[] a = new Integer[]{1,2,3,4};
        if(a.length > 16){
            ArrayOperations.mergeSort(a,Integer::compare);
        }else {
            ArrayOperations.insertionSort(a,Integer::compare);
        }
    }
}
