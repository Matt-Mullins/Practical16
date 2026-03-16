//Matthew Mullins
//4397399
//16 March 2026
//Practical16

import java.util.*;

public class Main {

        static int heapSize;
        static void swap(String[] A, int i, int j) {
            String temp = A[i];
            A[i] = A[j];
            A[j] = temp;
        }

     static void heapify(String[] A, int i) {

        int left = 2*i ;
        int right = 2*i + 1;
        int largest = i;

        if (left < heapSize && A[left].compareTo(A[largest]) > 0)
            largest = left;

        if (right < heapSize && A[right].compareTo(A[largest]) > 0)
            largest = right;

        if (largest != i) {
            swap(A,i,largest);
            heapify(A,largest);
        }
    }
    // building heap from bottom-up
     static void buildBottomUp(String[] A) {
        heapSize = A.length;
        for (int i = heapSize/2 - 1; i >= 0; i--) {
            heapify(A,i);
        }
     }
    //inserting for top-down heap
      static void insert(String[] heap, int index) {
        int child = index;
        while (child > 0) {
            int parent = (child-1)/2;
            if (heap[child].compareTo(heap[parent]) > 0) {
                swap(heap,child,parent);
                child = parent;
            }
            else
                break;
        }
     }
     static void buildTopDown(String[] A) {
        heapSize = A.length;
        for (int i = 1; i < heapSize; i++) {
            insert(A,i);
        }
    }
    //heap sorting
    static void heapSort(String[] A) {
        buildBottomUp(A);
        for (int i = A.length-1; i > 0; i--) {
            swap(A,0,i);
            heapSize--;
            heapify(A,0);
        }
    }
    //heapsort after top -> down build
    static void heapSortTopDown(String[] A) {
        buildTopDown(A);
        for (int i = A.length-1; i > 0; i--) {
            swap(A,0,i);
            heapSize--;
            heapify(A,0);
        }
    }
    public static void main(String[] args) {

        String[] words = {"pear","apple","orange","banana", "grape","kiwi","lemon","mango"};
        heapSort(words);

        for(String w : words){System.out.print(w + " ");}

        String[] bottomTest = words.clone();
        String[] topTest = words.clone();

        // bottom-up timing
        long start1 = System.nanoTime();
        heapSort(bottomTest);
        long end1 = System.nanoTime();

        // top-down timing
        long start2 = System.nanoTime();
        heapSortTopDown(topTest);
        long end2 = System.nanoTime();

        System.out.println();
        // results
        System.out.println("Sorted (Bottom-Up):");
        printArray(bottomTest);

        System.out.println("\nSorted (Top-Down):");
        printArray(topTest);

        System.out.println("\nTiming Results");
        System.out.println("Bottom-Up Time: " + (end1-start1) + " ns");
        System.out.println("Top-Down Time: " + (end2-start2) + " ns");
    }

    private static void printArray(String[] a) {
        for(String w : a){System.out.print(w + " ");}
        }
    }