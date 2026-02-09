package main.datastructures.tree.cst;

import main.datastructures.core.DataStructure;

import java.util.ArrayList;
import java.util.Comparator;

public class CompleteBinaryTree<T> extends DataStructure {
    protected ArrayList<T> data;
    protected int lastIndex;
    protected Comparator<T> comparator;
    public CompleteBinaryTree(Comparator<T> comparator){
        this.comparator = comparator;
        data = new ArrayList<>();
        data.add(null); // 0 index = null
        lastIndex=0;
    }

    public boolean isEmpty(){
        return lastIndex==0;
    }
    public T getRoot(){
        return data.get(lastIndex);
    }

    private void swap(int i, int j){
        T x = data.get(i);
        data.set(i, data.get(j));
        data.set(j,x);
    }
    public void insert(T value){
        lastIndex++;
        data.add(value);
        int c = lastIndex;
        while (c > 1){
            int p = c /2;
            if(comparator.compare(data.get(c), data.get(p)) < 0){
                swap(c,p);
                c=p;
            }else {
                break;
            }
        }
    }

    private T get(int index){
        return index < data.size() ? data.get(index) : null;
    }

    // O(1) for root
    private int findIndex(int i,T value){
        if(i>=data.size())return -1;
        if(comparator.compare(get(i) , value) == 0){
            return i;
        }
        int ret = -1;
        if(comparator.compare(get(2*i ),value) >= 0){
            ret = findIndex(2*i , value);
        }
        if(ret!=-1)return ret;
        if(comparator.compare(get(2*i + 1),value) >= 0){
            ret = findIndex(2*i+1 , value);
        }
        return ret;
    }

    public void delete(T value){
        int index = findIndex(1,value);
        if(index<1)return;
        data.set(index,data.get(lastIndex));
        data.remove(lastIndex--);
        int i = index;
        T v = data.get(index);
        while (i < data.size()){
            int li = 2*i,ri = li+1;
            T l = get(li),r = get(ri);
            if(l!=null && r!=null) {
                if(comparator.compare(l,r) < 0){
                    swap(li,i);
                    i=li;
                }else {
                    swap(ri,i);
                    i=ri;
                }
            } else if(l!=null && comparator.compare(l,v) < 0){
                swap(li,i);
                i=li;
            }else if (r!=null && comparator.compare(r,v) < 0){
                swap(ri,i);
                i=ri;
            }else break;
        }
    }

    public T poll(){
        T ret = get(1);
        delete(ret);
        return ret;
    }

    public void print(){
        data.forEach(System.out::println);
    }

}
