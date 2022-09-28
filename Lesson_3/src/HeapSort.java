/*
Реализовать алгоритм пирамидальной сортировки (HeapSort)
 */

public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {7,2,4,9,6,5,1,0,3};
        HeapSort sorted = new HeapSort();
        sorted.sort(arr);
        System.out.println("Sorted array is: ");
        printArray(arr);
    }

    public void sort(int[] arr) {
        int n = arr.length;

        for (int i = n / 2; i >= 0; i--) {
            heapify(arr, n, i);
        }
            for (int i = n - 1; i >= 0; i--) {
                int temp = arr[0];
                arr[0] = arr[i];
                arr[i] = temp;
                heapify(arr, i, 0);
            }
    }
    void heapify(int[] arr, int n, int i) {
        int biggest = i;
        int k = 2 * i + 1;
        int l = 2 * i + 2;
        if (k < n && arr[k] > arr[biggest]) {
            biggest = k;
        }
        if (l < n && arr[l] > arr[biggest]) {
            biggest = l;
        }
        if (biggest != i) {
            int swap = arr[i];
            arr[i] = arr[biggest];
            arr[biggest] = swap;
            heapify(arr, n, biggest);
        }
    }
    static void printArray(int[] arr) {
        int n = arr.length;
        for (int i : arr) {
            System.out.println(i + " ");
        }
        System.out.println();
    }
}
