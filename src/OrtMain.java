import java.io.File;
import java.io.FileNotFoundException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Created by Elias on 2016-01-16.
 */
public class OrtMain {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("/tmp/orter.txt");
        ArrayList<Ort> orter = new ArrayList<Ort>();
        System.out.println(Charset.defaultCharset().displayName());
        Scanner scan = new Scanner(file, StandardCharsets.UTF_8.name());
        while(scan.hasNext()){
            String line = scan.nextLine();
            Ort ort = new Ort(line);
            orter.add(ort);
        }
        System.out.println(orter);
        int counter = 0;
        for(Ort o : orter){
            counter++;
        }
        System.out.println(counter);
    }
}