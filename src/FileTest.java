import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileTest {

    public static void main(String[] args) throws IOException {
        int upperCase = 0;
        int lowerCase = 0;
        int whiteSpace = 0;
        int otherChar = 0;

//        File file = new File("c:\\Users\\Elias\\IdeaProjects\\Laboration4\\testtest.txt");
        File file = new File("/tmp/test.txt");
        Files.copy(Paths.get(file.getAbsolutePath()), System.out);
        String text = readFile(file);
        System.out.println(text);


        /*
        try {
            File file = new File("testtest.txt");
            Scanner scanFile = new Scanner(file);
            while(scanFile.hasNext()){
                for(int i = 0; i == has; i++) {
                    if (Character.isUpperCase(str.charAt(i))) {
                        upperCase++;
                    } else if (Character.isLowerCase(str.charAt(i))) {
                        lowerCase++;
                    } else if (Character.isWhitespace(str.charAt(i))) {
                        whiteSpace++;
                    } else {
                        otherChar++;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.printf("Uppsercase: %d\nLowercase: %d\n", upperCase,lowerCase);
        System.out.printf("Whitespaces: %d\nOther: %d", whiteSpace,otherChar);
        */

    }

    //Reads from the file.
    public static String readFile(File file) {
        System.out.println(file.getAbsolutePath());
        String returnValue = "";
        try{
            Scanner sc = new Scanner(file);
            System.out.println(file.exists());
            System.out.println(sc.hasNext());
            while(sc.hasNextLine()){
                System.out.println("Sup");
                returnValue += sc.nextLine();
            }
        }
        catch (Exception e){
            System.out.println("File not found");
        }
        return returnValue;
    }

}