package main.algorithms.test;

import main.algorithms.string.StringAlgo;

import java.util.Arrays;

public class StringTest {
    public static void main(String[] args) {
        System.out.println(StringAlgo.kmp("AACECAAAAC", "AA"));
        System.out.println(StringAlgo.lcsSubstring("lmaooo","maoyanise"));
        System.out.println(StringAlgo.lcsSequence("lmaooo","maoyaniseo"));
        String s = "AAAA";
        String rev = (new StringBuilder(s)).reverse().toString();
        System.out.println(Arrays.toString(StringAlgo.lps((s + "$" + rev ).toCharArray())));
    }
}
