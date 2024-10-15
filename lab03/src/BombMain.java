import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class BombMain {
    public static String BobSolver() {
        Random r = new Random(1337);
        Set<Integer> numbers = new HashSet<>();
        while (numbers.size() < 100000) {
            numbers.add(r.nextInt());
        }

        int targetIndex = 1337;
        int targetNumber = -1;
        int i = 0;
        for (int number : numbers) {
            if (i == targetIndex) {
                targetNumber = number;
                break;
            }
            i++;
        }

        // Construct the password
        StringBuilder password = new StringBuilder();
        for (int j = 0; j < 100000; j++) {
            if (j == targetIndex) {
                password.append(targetNumber).append(" ");
            } else {
                password.append("0 ");
            }
        }

        // Remove the trailing space
        String finalPassword = password.toString().trim();

        return finalPassword;
    }
    public static void main(String[] args) {
        int phase = 2;
        if (args.length > 0) {
            phase = Integer.parseInt(args[0]);
        }
        // TODO: Find the correct passwords to each phase using debugging techniques.
        //       Tip: if you don't know where a method is defined, hover your mouse over
        //              the method name, and CMD + click (or CTRL + click). This will
        //              take you to the method definition.
        Bomb b = new Bomb();
        if (phase >= 0) {
            b.phase0(b.shufflePassword("hello")); // Figure this out. I wonder where the phases are defined...
        }
        if (phase >= 1) {
            b.phase1(new int[]{0, 9, 3, 0, 8}); // Figure this out next
        }
        if (phase >= 2) {
            b.phase2(BobSolver());
        }


    }
}
