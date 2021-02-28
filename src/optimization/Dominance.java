package optimization;

import java.util.ArrayList;
import java.util.List;

public class Dominance {
    public static List<ParetoVector> findNonDominatedVertices( List<ParetoVector> vertices) {
        List<ParetoVector> result = new ArrayList<>();
        for (ParetoVector a : vertices) {
            boolean flag = false;
            for (ParetoVector b : vertices) {
                if (a != b) {
                    flag = areNoneDominated(a,b,false);
                }
                if (flag) break;
            }
            if (!flag) result.add(a);
        }
        return result;
    }

    private static boolean areNoneDominated( ParetoVector a, ParetoVector b, boolean isMaximizeProblem) {
        if (isMaximizeProblem) return a.getX() <= b.getX() && a.getY() <= b.getY();
        else return a.getX() >= b.getX() && a.getY() >= b.getY();
    }
}