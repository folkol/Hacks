import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

public class ClasspathScanner {
    public static void main(String[] args) throws IOException {
        Enumeration<URL> resources = Thread.currentThread()
                .getContextClassLoader()
                .getResources("META-INF/persistence.xml");
        while (resources.hasMoreElements()) {
            System.out.println(resources.nextElement());
        }
    }
}
