public class LjusKvar {
    public static void main(String[] args) {
        int ljusKvar = 0, ljus = 0, box = 0;
        for (int age = 0; age < 100; age++) {
            if (ljusKvar < age) {
                ljus = ljus + 24;
                box++;
            }
            ljusKvar = ljus - age;
            System.out.printf("age: %2d, ljus: %3d, ljusKvar: %3d%n", age, ljus, ljusKvar);
        }
    }
}
