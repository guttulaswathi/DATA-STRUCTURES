import java.util.*;

public class MergeSort {
    public static void mergesort(int arr[], int low, int high) {
        if (low >= high) { // base condition
            return;
        }

        int mid = low + (high - low) / 2; // Correct mid calculation
        mergesort(arr, low, mid);
        mergesort(arr, mid + 1, high);
        merge(arr, low, high, mid);
    }

    public static void merge(int arr[], int low, int high, int mid) {
        int n1 = mid - low + 1;
        int n2 = high - mid;

        int[] leftarray = new int[n1];
        int[] rightarray = new int[n2];

        System.arraycopy(arr, low, leftarray, 0, n1);
        System.arraycopy(arr, mid + 1, rightarray, 0, n2);

        int i = 0, j = 0, k = low;
        while (i < n1 && j < n2) {
            if (leftarray[i] <= rightarray[j]) {
                arr[k++] = leftarray[i++];
            } 
            else
            {
                arr[k++] = rightarray[j++];
            }
        }

        // Copy remaining elements if any
        while (i < n1) {
            arr[k++] = leftarray[i++];
        }
        while (j < n2) {
            arr[k++] = rightarray[j++];
        }
    }

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        System.out.println("enter number of elements:");
        int n = s.nextInt();

        int[] arr = new int[n];
        System.out.println("enter elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }

        mergesort(arr, 0, arr.length - 1);
        System.out.println("sorted array:");
        for (int num : arr) {
            System.out.print(num + " "); 
        }
    }
}

