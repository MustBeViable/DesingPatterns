package context;

import algorithms.AlgorithmInterface;

public class AlgortihmProvider {
    private AlgorithmInterface algorithm;

    public void setAlgorithm(AlgorithmInterface algorithm) {
        this.algorithm=algorithm;
    }

    public void provideAlgorithm(int[] array) {
        algorithm.sortArray(array);
    }
}
