//import java.io.File;
//import java.io.FileNotFoundException;
//import java.util.Scanner;
//import java.util.stream.IntStream;
//
//public class Histogram {
//
//    private static int[] values = new int[10];
//    private static int others;
//
//    public static void main(String[] args) throws FileNotFoundException {
//        readData(new File("/tmp/data.dat"));
//        printHistogram();
//    }
//
//    private static void readData(File path) throws FileNotFoundException {
//        System.out.println("Läser heltal från filen: " + path);
//        Scanner scanner = new Scanner(path);
//        while (scanner.hasNextInt()) {
//            int i = scanner.nextInt();
//            if (i < 100) {
//                values[i / 10]++;
//            } else {
//                others++;
//            }
//        }
//    }
//
//    private static void printHistogram() {
//        System.out.println("Antal i intervallet [1,100]: " + IntStream.of(values).sum());
//        System.out.println("Övriga: " + others);
//        System.out.println("Histogram");
//        for(int i = 0; i < 10; i++) {
//            System.out.printf("%2d - %-3d | ", i * 10 + 1, (i + 1) * 10);
//            for(int j = 0; j < values[i]; j++) {
//                System.out.print("*");
//            }
//            System.out.println();
//        }
//    }
//}

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Histogram {

    static List<Integer> numbers = new ArrayList<>();
    private static int others;

    public static void main(String[] args) throws FileNotFoundException {
        readData(new File("/tmp/data.dat"));
        printHistogram();
    }

    private static void readData(File path) throws FileNotFoundException {
        System.out.println("Läser heltal från filen: " + path);
        Scanner scanner = new Scanner(path);
        while (scanner.hasNextInt())
            numbers.add(scanner.nextInt());
    }

    private static void printHistogram() {
//        int included = IntStream.generate(numbers.iterator())
//                .filter(x -> x < 100)
//                .mapToInt(Integer::intValue)
//                .sum();
//
//        System.out.println("Antal i intervallet [1,100]: " + included);
//        System.out.println("Övriga: " + (numbers.size() - included));
//        System.out.println("Histogram");
//        for(int i = 0; i < 10; i++) {
//            System.out.printf("%2d - %-3d | ", i * 10 + 1, (i + 1) * 10);
//            for(int j = 0; j < values[i]; j++) {
//                System.out.print("*");
//            }
//            System.out.println();
//        }
    }
}
