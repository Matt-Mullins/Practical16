//Matthew Mullins
//4397399
//16 March 2026
//Practical16

import java.util.*;

void main() {

     class tryHeapsort {
        static int heapSize;
        static void swap(String[] A, int i, int j) {
            String temp = A[i];
            A[i] = A[j];
            A[j] = temp;
        }
     }

     void heapify(String[] A, int i) {

        int left = 2*i + 1;
        int right = 2*i + 2;
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
}
