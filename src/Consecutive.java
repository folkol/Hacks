import java.util.Objects;

public class Consecutive {

    public static final int DAYS = 10;
    public static final int HOURS = 10;
    private static int hours = 24;

    public static void main(String[] args) {
        int fitness = Integer.MAX_VALUE;
        Object[][] timetable = new Object[DAYS][HOURS];
        fitness = nextFitness(fitness, timetable);
        System.out.println(fitness);
    }

    static int nextFitness(int fitness, Object[][] timetable) {
        for (Object[] day : timetable)                        // "on the same day"
            for (int hour = 0; hour < HOURS - 1; hour++)      // "consecutive"
                if (Objects.equals(day[hour], day[hour + 1])) // "equal"
                    fitness -= 100;                           // "i need to do this"
        return fitness;
    }
}
