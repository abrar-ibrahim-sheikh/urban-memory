package com.memory.urban.dsa.impl;


import com.memory.urban.dsa.Heap;

import java.util.ArrayList;

public class HeapImpl implements Heap {

    private ArrayList<Integer> arrayList;

    private int count;

    private int capacity;

    private int heapType;

    private int parentIndex;


    @Override
    public int capacity() {
        return capacity;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public void insert(int val) {
        insert(arrayList, count, val);
    }

    @Override
    public void insert(ArrayList<Integer> arrayList, int currentSize, int val) {
        int indexToInsert = ++currentSize;
        arrayList.set(indexToInsert, val);
        int temp;
        while(indexToInsert > 1) {
            parentIndex = indexToInsert/2;
            if (arrayList.get(indexToInsert) > arrayList.get(parentIndex)) {
                temp = arrayList.get(indexToInsert);
                arrayList.set(indexToInsert, arrayList.get(parentIndex));
                arrayList.set(parentIndex, temp);
                indexToInsert = parentIndex;
            }
        }
    }

    @Override
    public int delete() {
        return delete(arrayList, count);
    }

    @Override
    public int delete(ArrayList<Integer> arrayList, int count) {
        int deletedElement = arrayList.get(0);
        arrayList.set(0, arrayList.get(count));
        int lastIndex = --count;
        int currentIndex = 1;
        int largeChildIndex;
        int leftChildIndex;
        int rightChildIndex;
        int temp;

        while(currentIndex < lastIndex) {
            leftChildIndex = 2 * currentIndex;
            rightChildIndex = (2 * currentIndex) + 1;
            largeChildIndex = (arrayList.get(leftChildIndex) > arrayList.get(rightChildIndex)) ? leftChildIndex:rightChildIndex;

            if(arrayList.get(currentIndex) < arrayList.get(largeChildIndex)) {
                temp = arrayList.get(currentIndex);
                arrayList.set(currentIndex, arrayList.get(largeChildIndex));
                arrayList.set(largeChildIndex, temp);

                currentIndex = largeChildIndex;
            } else {
                break;
            }
        }
        return deletedElement;
    }
}
