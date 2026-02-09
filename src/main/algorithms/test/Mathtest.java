package main.algorithms.test;

import main.algorithms.math.MathAlgo;

import java.util.Arrays;

public class Mathtest {
    public static void mathTests() {
        System.out.println(MathAlgo.pow(2,8));
        System.out.println(MathAlgo.pow(2,5));
        System.out.println(Arrays.toString(MathAlgo.extendedEuclidean(5,3)));
        System.out.println(MathAlgo.modInverse(500,23));
        System.out.println(MathAlgo.modInvEuclidean(500,23));
        System.out.println(Arrays.toString(MathAlgo.totient_range(10)));
        System.out.println(MathAlgo.crt(new long[][]{new long[]{2,9},new long[]{5,7}}));
    }
    public static void main(String[] args) {
        mathTests();
    }
}
