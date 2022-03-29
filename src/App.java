public class App {
    void sum(int a, long b) {
        System.out.println("a method invoked");
    }

    void sum(long a, int b) {
        System.out.println("b method invoked");
    }

    public static void main(String args[]) {
        //App obj = new App();
        //obj.sum(20, 20);// now ambiguity
    }
}