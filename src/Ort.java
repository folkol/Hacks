import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Created by Elias on 2016-01-16.
 */
public class Ort implements Comparable<Ort> {
    public ArrayList arr = new ArrayList();
    public int postnumer = 0;
    public String ort = null;


    public Ort(String line) {
        String[] split = line.split(";");
        int temp = Integer.parseInt(split[0]);
        ort = split[0];
    }


    @Override
    public int compareTo(Ort o) {
        int returnValue = 0;
        if (this.postnumer > o.postnumer)
            returnValue = 1;
        if (this.postnumer == o.postnumer)
            returnValue = 0;
        if (this.postnumer < o.postnumer)
            returnValue = -1;
        return returnValue;
    }

    public int getPostnummmer(Object o) {
        return postnumer;
    }

    public String toString() {
        String str = "";
        str += postnumer + " " + ort;
        return str;
    }

    //Reads from the file.
    public static String readFile(File file) {
        String returnValue = "";
        try {
            Scanner sc = new Scanner(file); //Reads as UTF-8
            while (sc.hasNextLine()) {
                returnValue += sc.nextLine() + "\n";
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return returnValue;
    }

    public void addNew(String[] split) {
        for (String ord : split) {
            arr.add(ord);
        }
    }

    public void setPostnummer(int a) {
        postnumer = a;
    }

    public void setOrt(String a) {
        ort = a;
    }
}