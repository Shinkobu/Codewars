public class TimeElapsed {

    public static void main(String[] args) {
        long now = System.currentTimeMillis();
        somemethod();
        System.out.println("Time elapsed " + (System.currentTimeMillis() - now) + " ms");
    }
    static void somemethod(){
        for (double i = 0; i < 1000000000; i++) {

        }
    }
}
