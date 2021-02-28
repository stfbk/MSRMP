package optimization;

public class ParetoVector {
    private double x;
    private double y;

    public ParetoVector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Pareto Solution {" +
                "Data subject Risk= " + x +
                ", Data Controller Risk= " + y +
                '}';
    }
}