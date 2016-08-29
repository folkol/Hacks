import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;

/**
 * ppgift 11
 * Skriv ett program OmvandOrding.java som läser ett godtyckligt antal positiva
 * heltal från tangentbordet och sedan skriver ut dem baklänges. Inmatningen
 * sker fram tills det att användaren matar in ett negativt tal. En körning
 * kan se ut enligt följande:
 * Mata in positiva heltal. Avsluta med ett negativt.
 * tal 1: 5
 * tal 2: 10
 * tal 3: 15
 * tal 4: 20
 * tal 5: -7
 * <p>
 * Antal positiva: 4
 * Baklänges: 20, 15, 10, 5
 * Notera: Man skall inte behöva ange hur många tal man ämnar mata in.
 */
public class OmvandOrdning {
/*    static int[] heltal = new int[2];
    static int antal;*/

/*    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mata in positiva heltal. Avsluta med ett negativt.");
        while (true) {
            int i = scanner.nextInt();
            if (i < 0) {
                break;
            }
            add(i);
        }
        System.out.println("Antal positiva: " + antal);
        System.out.println("Baklänges: ");
        for (int i = antal - 1; i >= 0; i--) {
            System.out.printf("%d, ", heltal[i]);
        }
    }*/

    /*private static void add(int i) {
        if (antal == heltal.length) {
            int[] newHeltal = new int[heltal.length * 2];
            for (int c = 0; c < antal; c++) {
                newHeltal[c] = heltal[c];
            }
            heltal = newHeltal;
        }
        heltal[antal++] = i;
    }*/

/*    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();

        System.out.println("Mata in positiva heltal. Avsluta med ett negativt.");
        for(int i = scanner.nextInt(); i >= 0; i = scanner.nextInt()) {
            numbers.add(i);
        }

        Collections.reverse(numbers);
        String commaSeparated = numbers.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", "));
        System.out.println("Antal positiva: " + numbers.size());
        System.out.print("Baklänges: " + commaSeparated);
    }
}*/

    /**
     * Created by Elias on 2015-11-29.
     */
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int count = 0;
//        int[] myArray = new int[10];
//        System.out.println("Mata in positiva heltal. Avsluta med ett negativt.");
//        while (true) {
//            int inPut = sc.nextInt();
//            if (inPut < 0) {
//                break;
//            }
//            myArray[count] = inPut;
//            count++;
//
//            if (count == myArray.length) {
//                int newArray[] = new int[count];
//                for (int c = 0; c < myArray.length; c++) {
//                    newArray[c] = myArray[c];
//                }
//                myArray = newArray;
//            }
//        }
//
//        for (int i = count - 1; i > -1; i--) {
//            System.out.println(myArray[i]);
//        }
//    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count  = 0;
        int[] myArray = new int[10];
        System.out.println("Mata in positiva heltal. Avsluta med ett negativt.");
        while(true){
            int inPut = sc.nextInt();
            if(inPut<0){
                break;
            }
            if(count == myArray.length) {
                int newArray[] = new int[count * 2];
                for(int c = 0; c < myArray.length; c++){
                    newArray[c] = myArray[c];
                }
                myArray = newArray;
            }
            myArray[count]=inPut;
            count++;

        }

        for(int i = count -1; i > -2; i--){
            System.out.println(myArray[i]);
        }
    }

}