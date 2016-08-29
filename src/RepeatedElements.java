import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;

public class RepeatedElements
{

    public static final int N = 10_000_000;
    public static final int BOUND = 10_000_000;

    public static void main(String[] args)
    {
        Random rng = new Random();
        Integer[] xs = new Integer[N];
        for (int i = 0; i < xs.length; ++i) {
            xs[i] = rng.nextInt(BOUND);
        }

        {
            double begin = System.nanoTime();
            Stream.of(xs)
//                .boxed()
                .collect(Collectors.groupingBy(identity(), counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() > 1)
                .map(Map.Entry::getKey);
//            .forEach(System.out::println);
            double elapsed = (System.nanoTime() - begin) / 1e9;
            System.out.printf("Stream: %f%n", elapsed);
        }

        {
            long begin = System.nanoTime();
            Integer[] seen = new Integer[N];
            for(int i = 0; i < seen.length; ++i) {
                seen[i] = 0;
            }
            for (int x : xs) {
                ++seen[x];
            }

            //3,9,5
            for (int i = 0; i < seen.length; ++i) {
                if (seen[i] > 1) {
//                System.out.println(i);
                }
            }
            double elapsed = (System.nanoTime() - begin) / 1e9;
            System.out.printf("For: %f%n", elapsed);
        }

    }
}
