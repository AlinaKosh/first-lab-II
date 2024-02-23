import java.util.Random;

public class Randomm {
    private static Random r = new Random();

    public static double randomDouble() {
        return 2 * r.nextDouble() - 1;
    }

    public static int randomInt() {
        return r.nextInt();
    }
}