import java.util.Timer;
import java.util.TimerTask;

public class TimerTest {
    static int counter;

    public static void main(String[] args) {
        Timer timer = new Timer();
        for (int i = 0; i < 4000; i++) {
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    int id = ++counter;
                    if (id % 100 == 0) {
                        System.out.println("Task: " + ++counter);
                    }
                    if (counter == 4000) {
                        System.out.println("Done!");
                        timer.cancel();
                    }
                }
            }, 1000);
        }
    }
}
