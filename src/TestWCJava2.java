import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TestWCJava2 {

    /**
     * /Library/Java/JavaVirtualMachines/jdk1.8.0_66.jdk/Contents/Home/bin/java -XX:+UnlockCommercialFeatures -XX:+FlightRecorder -XX:StartFlightRecording=duration=120m,filename=recording.jfr -Didea.launcher.port=7532 "-Didea.launcher.bin.path=/Applications/IntelliJ IDEA.app/Contents/bin" -Dfile.encoding=UTF-8 -classpath "/Library/Java/JavaVirtualMachines/jdk1.8.0_66.jdk/Contents/Home/jre/lib/charsets.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_66.jdk/Contents/Home/jre/lib/deploy.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_66.jdk/Contents/Home/jre/lib/ext/cldrdata.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_66.jdk/Contents/Home/jre/lib/ext/dnsns.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_66.jdk/Contents/Home/jre/lib/ext/jaccess.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_66.jdk/Contents/Home/jre/lib/ext/jfxrt.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_66.jdk/Contents/Home/jre/lib/ext/localedata.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_66.jdk/Contents/Home/jre/lib/ext/nashorn.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_66.jdk/Contents/Home/jre/lib/ext/sunec.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_66.jdk/Contents/Home/jre/lib/ext/sunjce_provider.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_66.jdk/Contents/Home/jre/lib/ext/sunpkcs11.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_66.jdk/Contents/Home/jre/lib/ext/zipfs.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_66.jdk/Contents/Home/jre/lib/javaws.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_66.jdk/Contents/Home/jre/lib/jce.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_66.jdk/Contents/Home/jre/lib/jfr.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_66.jdk/Contents/Home/jre/lib/jfxswt.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_66.jdk/Contents/Home/jre/lib/jsse.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_66.jdk/Contents/Home/jre/lib/management-agent.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_66.jdk/Contents/Home/jre/lib/plugin.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_66.jdk/Contents/Home/jre/lib/resources.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_66.jdk/Contents/Home/jre/lib/rt.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_66.jdk/Contents/Home/lib/ant-javafx.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_66.jdk/Contents/Home/lib/dt.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_66.jdk/Contents/Home/lib/javafx-mx.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_66.jdk/Contents/Home/lib/jconsole.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_66.jdk/Contents/Home/lib/packager.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_66.jdk/Contents/Home/lib/sa-jdi.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_66.jdk/Contents/Home/lib/tools.jar:/Users/folkol/code/Hacks/out/production/Hacks:/Applications/IntelliJ IDEA.app/Contents/lib/junit-4.12.jar:/Applications/IntelliJ IDEA.app/Contents/lib/hamcrest-core-1.3.jar:/Applications/IntelliJ IDEA.app/Contents/lib/idea_rt.jar" com.intellij.rt.execution.application.AppMain TestWCJava2
     * Started recording 1. The result will be written to:
     * <p>
     * /Users/folkol/code/Hacks/recording.jfr
     * /tmp/four lines: 2915884
     * /tmp/four lines: 2915884
     * Elapsed time: 6906597us
     */

    public static final String TMP_THREE = "/tmp/four";

    public static void main(String args[]) {
        try {
            for (int i = 0; i < 15; i++) {
                new TestWCJava2().run(new String[]{TMP_THREE});
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void run(String files[]) throws IOException {
//        wordCount(TMP_THREE); // hope JIT kicks in here (and hence we exclude timing it later).
        long t0 = System.nanoTime();
        for (String file : files) {
            System.out.println(wordCount(file));
        }
        long t1 = System.nanoTime();
        System.out.println("Elapsed time: " + (t1 - t0) / 1e9 + "s");
    }

    int wordCount(String fileName) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        boolean inWord = false;
        int wordCount = 0;
        int i;
        while ((i = bufferedReader.read()) != -1) {
            if (Character.isWhitespace(i)) {
                inWord = false;
            } else if (!inWord) {
                wordCount++;
                inWord = true;
            }
        }
        return wordCount;
    }
}