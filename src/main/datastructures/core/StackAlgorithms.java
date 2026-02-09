package main.datastructures.core;

import java.util.*;
import java.util.stream.Collectors;

public class StackAlgorithms{
    public static class P<K,V>{
        K first;
        V second;

        public P(K first, V second) {
            this.first = first;
            this.second = second;
        }
    }
    private static <T extends Comparable<T>> Stack<T> minStack(List<T> list){
        Stack<T> stack = new Stack<>();
        for (T i:list) {
            while (!stack.isEmpty() && stack.peek().compareTo(i) > 0){
                stack.pop();
            }
            stack.push(i);
        }
        return stack;
    }
    public static <T extends Comparable<T>> Stack<T> arrayToMinStack(T[] arr){
        return minStack(Arrays.stream(arr).collect(Collectors.toList()));
    }
    public static <T extends Comparable<T>> Stack<T> arrayToMinStack(List<T> list){
        return minStack(list);
    }

//    public static <T extends Comparable<T>> Stack<T> minOfRange(List<T> list, int range,T min){
//        Stack<T> stack = new Stack<>();
//        Stack<T> mins = new Stack<>();
//        for (int i = 0; i < list.size(); i++) {
//            T obj = list.get(i);
//            if(i<range){
//                if(stack.isEmpty()){
//                    min = obj;
//                }else if (stack.peek().compareTo(obj) > 0){
//                    min = stack.peek();
//                }
//            }
//            stack.push(min);
//        }
//    }
}
