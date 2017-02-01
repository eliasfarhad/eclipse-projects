//Bucket Sort

import java.util.*;

class BucketSort {

    public static void main(String[] args) {
        //initializing array
        double arr[] = {0.987, 0.678, 0.123, 0.887, 0.665, 0.432, 0.342};
        System.out.print("Initial Array  :");
        printArray(arr);
        bucketsort(arr);
    }
    
    
    public static void printArray(double[] arr) {
        System.out.print("[");

        for(int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + ", ");
        }

        System.out.println(arr[arr.length - 1] + "]");
    }
    
    
    @SuppressWarnings("unchecked")
    public static void bucketsort(double arr[]) {
        int N = arr.length;
        LinkedList<Double> bucket[] = new LinkedList[N];

        for(int i = 0; i < N; i++)
            bucket[i] = new LinkedList<>();

        for(int i = 0; i < N; i++) {
            int index = (int)(N * arr[i]);
            bucket[index].add(arr[i]);
        }

        System.out.println("After sorting " + N + " buckets");

        for(int i = 0; i < N; i++) {
            Collections.sort(bucket[i]);
            System.out.println(bucket[i]);
        }

        int k = 0;
        System.out.println("After concatenating " + N + " buckets");

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < bucket[i].size(); j++) {
                arr[k++] = bucket[i].get(j);
            }
        }

        printArray(arr);
    }
}