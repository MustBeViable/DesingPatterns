package algorithms;

public class MergeSort implements AlgorithmInterface {

    public String getName() {
        return "MergeSort";
    }

    // Merges two subarrays of arr[]:
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    private static void merge(int[] arr, int l, int m, int r) {

        int n1 = m - l + 1;
        int n2 = r - m;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = arr[l + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = arr[m + 1 + j];
        }

        int i = 0, j = 0;
        int k = l;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }

        while (i < n1) {
            arr[k++] = L[i++];
        }

        while (j < n2) {
            arr[k++] = R[j++];
        }
    }

    private static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;

            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);

            merge(arr, l, m, r);
        }
    }

    @Override
    public int[] sortArray(int[] sortableArray) {
        if (sortableArray == null || sortableArray.length < 2) {
            return sortableArray;
        }
        mergeSort(sortableArray, 0, sortableArray.length - 1);
        return sortableArray;
    }
}