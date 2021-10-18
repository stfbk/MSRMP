package optimization;

public class ParetoVector {
    private double x;
    private double y;
    private int id;

    public ParetoVector(double x, double y, int id) {
        this.x = x;
        this.y = y;
        this.id= id;
    }

    public int getId() {
        return id;
    }

    public void setId( int id ) {
        this.id = id;
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
                ", Solution ID= " + id +
                '}';
    }
}