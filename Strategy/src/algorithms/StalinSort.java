package algorithms;

import java.util.ArrayList;


import java.util.List;

import static java.util.Collections.emptyList;

public class StalinSort implements AlgorithmInterface{

    public String getName() {
        return "StalinSort";
    }

    public <T extends Comparable<T>> List<T> stalinSort(List<T> list) {
        if (list.isEmpty()) {
            return emptyList();
        }
        List<T> sorted = new ArrayList<>();
        T max = null;
        for (T candidate : list) {
            if (sorted.isEmpty() || candidate.compareTo(max) >= 0) {
                sorted.add(candidate);
                max = candidate;
            }
        }
        return sorted;
    }

    @Override
    public int[] sortArray(int[] sortableArray) {

        List<Integer> list = new ArrayList<>();
        for (int num : sortableArray) {
            list.add(num);
        }

        List<Integer> result = stalinSort(list);

        int[] output = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            output[i] = result.get(i);
        }

        return output;
    }
}
