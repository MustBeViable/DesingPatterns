import algorithms.*;
import context.AlgortihmProvider;
import context.Result;

import java.util.*;

public class Main {
    private static final Random random = new Random();

    public static void main(String[] args) {

        AlgortihmProvider provider = new AlgortihmProvider();

        int[] smallArray = new int[30];
        for (int i = 0; i < smallArray.length; i++) {
            smallArray[i] = random.nextInt(100);
        }

        int[] bigArray = new int[100000];
        for (int i = 0; i < bigArray.length; i++) {
            bigArray[i] = random.nextInt(1000);
        }

        List<AlgorithmInterface> algorithms = List.of(
                new BubbleSort(),
                new QuickSort(),
                new MergeSort(),
                new StalinSort()
        );

        List<Result> smallResults = benchmark(provider, algorithms, smallArray);
        List<Result> bigResults = benchmark(provider, algorithms, bigArray);

        printResults("Small array (n=30)", smallResults);
        printResults("Big array (n=100000)", bigResults);
    }

    private static List<Result> benchmark(
            AlgortihmProvider provider,
            List<AlgorithmInterface> algorithms,
            int[] original
    ) {

        List<Result> results = new ArrayList<>();

        for (AlgorithmInterface algo : algorithms) {

            int[] copy = Arrays.copyOf(original, original.length);

            provider.setAlgorithm(algo); // strategy pattern
            long start = System.nanoTime();

            provider.provideAlgorithm(copy); // suoritetaan algoritmi

            long end = System.nanoTime();

            results.add(new Result(
                    algo.getClass().getSimpleName(),
                    end - start
            ));
        }

        results.sort(Comparator.comparingLong(Result::getNanos));

        return results;
    }

    private static void printResults(String title, List<Result> results) {

        System.out.println("\n" + title + " (fastest -> slowest):");

        for (int i = 0; i < results.size(); i++) {
            Result r = results.get(i);

            System.out.printf(
                    "%d) %s: %d ns%n",
                    i + 1,
                    r.getName(),
                    r.getNanos()
            );
        }
    }
}