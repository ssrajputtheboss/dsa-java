package main.datastructures.tree.segmenttree;

import main.datastructures.core.DataStructure;

import java.util.ArrayList;
import java.util.List;
public class SegmentTree<T> extends DataStructure {
   private final List<T> data;
   private final SegmentOperation<T> operation;
   private final int size,arrSize;
   private final T operationDefaultValue;

   public int getSize(){
       return size;
   }
   public SegmentTree(int size, T operationDefaultValue, SegmentOperation<T> operation){
       this.operationDefaultValue = operationDefaultValue;
       arrSize = size;

        data = new ArrayList<>(size*2);
        size = 2;
        while (size<=arrSize){
            size*=2;
        }
        this.size = size*2;
        this.operation = operation;
   }
   synchronized public void setDefaultCollectionValue(T value){
//       Collections.fill(data,value);
       for(int i =0;i<size*2;++i){
           data.add(value);
       }
   }
   synchronized public void initialize(T[] arr){
       assert arrSize == arr.length;
       int n = size/2;
       for(int i = 0;i<arr.length ;++i){
           data.set(n+i,arr[i]);
       }
       for(int i=n-1;i>0;--i){
           data.set(i, operation.operation(data.get(2*i), data.get(2*i+1)));
       }
   }

   public T get(int index){
       return data.get(size +index);
   }

    synchronized private T queryInternal(int l, int r, int node, int rl, int rr) {
       logger.log(node,rl,rr);
        if (r < rl || rr < l) {
            return operationDefaultValue; // No overlap
        }

        if ( rl >= l && rr <= r) {
            return data.get(node); // Complete overlap
        }

        int mid = (rl+rr) / 2;
        T leftResult = queryInternal(l, r, 2 * node, rl, mid);
        T rightResult = queryInternal(l, r, 2 * node + 1, mid + 1, rr);

        return operation.operation(leftResult, rightResult);
    }


    public T query(int l, int r){
        return queryInternal(l,r,1,0,(size/2)-1);
    }

    synchronized public void update(int index, T newValue){
       int dataIndex = index + size;
       data.set(dataIndex,newValue);
       if(dataIndex == 1)return;
       for(int i = dataIndex; i>1;){
           int parentIndex = i/2;
           int pairIndex = i%2 == 0 ? i+1 : i - 1;
           data.set(parentIndex , operation.operation(data.get(i) , data.get(pairIndex)));
           i = parentIndex;
       }
    }

    synchronized public void print(){
       int i =1,s = 1;
       while(i<size){
//           System.out.print(" ".repeat(size/s));
           for(int j=0;j<s && i<size;++j,i++)
            System.out.printf("%s ", data.get(i).toString());
           System.out.println();
           s*=2;
       }
    }


}
