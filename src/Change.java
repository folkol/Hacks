public class Change {
    enum Denomination {
        TUSEN(1000),
        FEMHUNKA(500),
        HUNDRING(100),
        FEMTIOLAPP(50),
        TJUGA(20),
        TIA(10),
        FEMMA(5),
        KRONA(1);

        private int value;

        Denomination(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public static void main(String[] args) {
        printChange(Math.random() * 10000);
//        printChange(628);
    }

    private static void printChange(double v) {

        for (Denomination d : Denomination.values()) {
            int n = 0;
            while (v > d.getValue()) {
                n++;
                v -= d.getValue();
            }
            System.out.printf("%s: %d%n", d.name(), n);
        }
    }
}
