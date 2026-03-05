package algorithms;

public class BubbleSort implements AlgorithmInterface {

    public String getName() {
        return "BubbleSort";
    }

    @Override
    public int[] sortArray(int[] sortableArray) {

        int n = sortableArray.length;

        for (int i = 0; i < n; i++) {
            boolean swapped = false;

            for (int j = 0; j < n - i - 1; j++) {

                if (sortableArray[j] > sortableArray[j + 1]) {

                    int temp = sortableArray[j];
                    sortableArray[j] = sortableArray[j + 1];
                    sortableArray[j + 1] = temp;

                    swapped = true;
                }
            }

            // jos mitään ei vaihdettu → array on jo järjestyksessä
            if (!swapped) {
                break;
            }
        }

        return sortableArray;
    }
}