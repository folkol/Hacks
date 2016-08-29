import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class FileScanner
{
    public static void main(String[] args) throws Exception
    {
        boolean append = true;
        FileOutputStream fos = new FileOutputStream("the-file-name.txt", append);
        OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
        PrintWriter writer = new PrintWriter(osw);
        writer.println("The first line");
        writer.println("The second line");
        writer.close();

        File file = new File("/tmp/test.txt");
        Scanner scanner = new Scanner(file);
        String s = scanner.nextLine();
        System.out.println(s);

        List<String> strings = Files.readAllLines(Paths.get("/tmp/test.txt"));
        System.out.println(strings);
    }
}
