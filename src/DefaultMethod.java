public class DefaultMethod {
    interface I {
        default void m() {
            System.out.println("m!");
        }
    }
    static class A implements I {}
    static class B implements I {}

    public static void main(String[] args) {
        new A().m();
        new B().m();
        System.out.println(I.class.getName());
        System.out.println(int.class.getName());
        Class c = DefaultMethod.class;
    }
}
