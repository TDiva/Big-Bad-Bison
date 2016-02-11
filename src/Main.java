import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    // Fill solvers
    private static List<Solver> solvers = Arrays.asList();

    public static void main(String[] args) {
        InOutService inOut = new InOutService("input.txt", "output.txt");
        try {

            // TODO: read input
            inOut.readLine();

            List<Result> res = new ArrayList<>();
            solvers.forEach( s -> res.add(s.run()));

            Result best = Collections.max(res);
            if (best != null)
                best.save(inOut);

            inOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
