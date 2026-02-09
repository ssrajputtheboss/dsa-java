package main.datastructures.core;


import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class ArrayOperations {
    private static void swap(Object[] o,int x, int y){
        Object tmp = o[x];
        o[x] = o[y];
        o[y] = tmp;
    }

    public static <T> void reverse(T[] array){
        int l = 0, r = array.length-1;
        while (l < r){
            swap(array,l++,r--);
        }
    }
    public static <T> void selectionSort(T[] array, Comparator<T> c){

        for(int i = 0;i< array.length;++i){
            int minIndex = i;
            for(int j=i+1;j< array.length;++j){
                if(c.compare(array[minIndex], array[j]) > 0 ){
                    minIndex=j;
                }
            }
            swap(array,i,minIndex);
        }
    }
    public static <T> void bubbleSort(T[] array, Comparator<T> c){

        for(int i = 0;i< array.length;++i){
            boolean swapped = false;
            for(int j=0;j< array.length -i -1 ;++j){
                if(c.compare(array[j] , array[j+1]) > 0){
                    swap(array,j,j+1);
                    swapped=true;
                }
            }
            if(!swapped)break;
        }
    }

    public static <T> void insertionSort(T[] array, Comparator<T> c){
        for(int i = 1;i< array.length;++i){
            T k = array[i];
            int j = i-1;
            while (j>=0 && c.compare(array[j] , k) > 0){
                array[j+1] = array[j];
                j--;
            }
            array[j+1]=k;
        }
    }
    private static <T> int partition(T[] array, int l, int h, Comparator<T> c){
        T pivot = array[h];
        int i = l-1;
        for(int j = l;j<h;++j){
            if(c.compare(array[j] , pivot) < 0){
                swap(array,++i,j);
            }
        }
        swap(array,++i,h);
        return i;
    }

    private static <T> int partitionLow(T[] array, int l, int h, Comparator<T> c){
        T pivot = array[l];
        int i = h+1;
        for(int j = h;j>l;--j){
            if(c.compare(array[j] , pivot) < 0){
                swap(array,--i,j);
            }
        }
        swap(array,--i,l);
        return i;
    }

    private static <T> int partitionMid(T[] array, int l, int h, Comparator<T> c){
        int m = l + (h-l)/2;
        swap(array,h,m);
        T pivot = array[h];
        int i = l-1;
        for(int j = l;j<h;++j){
            if(c.compare(array[j] , pivot) < 0){
                swap(array,++i,j);
            }
        }
        swap(array,++i,h);
        return i;
    }
    public static <T> void quickSort(T[] array,int l, int r, Comparator<T> c){
        if(l >=r)return;
        int pi = partition(array,l,r,c);
        quickSort(array,l,pi-1,c);
        quickSort(array,pi+1,r,c);
    }

    public static <T> void quickSort(T[] array,Comparator<T> c){
        quickSort(array,0,array.length-1,c);
    }

    public static <T> void mergeSort(T[] array, int l, int r,Comparator<T> c){
        if(l<r){
            int m = l  + (r-l)/2;
            mergeSort(array,l,m,c);
            mergeSort(array,m+1,r,c);
            T[] lArr = Arrays.copyOfRange(array,l,m+1),
                    rArr = Arrays.copyOfRange(array,m+1,r+1);
            int i=0 ,j=0,k = l;
            while (k<=r){
                if(i>=lArr.length){
                    array[k] =rArr[j++];
                }else if( j >= rArr.length){
                    array[k] = lArr[i++];
                }else {
                    if(c.compare(lArr[i], rArr[j]) < 0 ){
                        array[k] = lArr[i++];
                    }else {
                        array[k] = rArr[j++];
                    }
                }
                ++k;
            }
        }
    }
    public static <T> void mergeSort(T[] array,Comparator<T> c){
        mergeSort(array,0,array.length-1,c);
    }

    public static <T> void print(T[] a){
        for(T x : a){
            System.out.print(" " + x);
        }
        System.out.println();
    }

}
