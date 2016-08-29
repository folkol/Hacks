import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class PersistentProperties
{
    public static void main(String[] args) throws IOException
    {
        Properties properties = new Properties();
        properties.put("balance", Integer.toString(100));
        List<String> log = new ArrayList<>();
        log.add("I purchased something.");
        properties.put("transactions", log.toString());
        properties.store(new FileOutputStream("/tmp/example.properties"), "Stored properties list");
    }
}
