package ej222up_assign3;

/**
 * Created by Elias on 2016-02-21.
 */
public class EuclideanMain {
    public static void main(String[] args) {

        System.out.println(GDC(18,12));
        System.out.println(GDC(0,56));
        System.out.println(GDC(0,28));

        System.out.println(GDC(30, 36) );

    }
    public static int GDC(int M, int N){ // GCD
        int returnValue = 0;
        if(M==0 || N==0) // det är väl egentligen bara N som inte får vara 0?
            System.err.println("Unable to compute with '0'.");
        else {
            int largestValue, lowestValue, multiplyValue, restValue;
            if (M >= N) {
                largestValue = M;
                lowestValue = N;
            } else {
                largestValue = N;
                lowestValue = M;
            }

            multiplyValue = largestValue / lowestValue;
            restValue = largestValue % lowestValue;
            int temp = 2; // Du använder aldrig denna?
            while (restValue != 0) {
                largestValue = lowestValue * multiplyValue + restValue; // Du skriver alltid över denna på nästa rad
                largestValue = lowestValue;
                lowestValue = restValue;
                restValue = largestValue % lowestValue;
                temp = lowestValue; // Här sparar du i temp, men den används aldrig.
            }
            returnValue = lowestValue;
        }
        return returnValue;
    }
}