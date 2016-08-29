import java.util.Random;

/**
 * Uppgift 12
 Skriv ett program Frekvenstabell.java som simulerar 6000 tärningskast.
 För att visa att sannolikheten att få en etta, tvåa, trea, fyra, femma
 eller sexa är ungefar lika stor, skall man skapa en frekvenstabell som
 lagrar hur många ettor, tvåor, o.s.v. som slumpats fram. (Använd en
 array för att lagra hur många ettor, tvåor, o.s.v. som slumpats fram.)
 En körning kan se ut enligt följande:
 Frequencies when rolling a dice 6000 times.
 1: 1025
 2: 996
 3: 980
 4: 1006
 5: 1035
 6: 958
 */
public class Frekvenstabell {

    public static void main(String[] args) {
        Random random = new Random();
        int[] kast = new int[6];
        for(int i = 0; i < 6000; i++) {
            int t = random.nextInt(6);
            kast[t]++;
        }
        System.out.printf("Frequencies when rolling a dice %d times.%n", 6000);
        for(int i = 0; i < 6; i++) {
            System.out.printf("%d: %d (%.2f%%) e: %f%n", i, kast[i], kast[i] / 60.0, (100/6.0 - kast[i] / 60.0));
        }
    }
}
