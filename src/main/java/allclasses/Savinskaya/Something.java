package allclasses.Savinskaya;


public class Something {
    private double sideA;
    private double sideB;
    private double sideC;

    public Something(double sideA, double sideB, double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    public String getType() {
        if (sideA <= 0 || sideB <= 0 || sideC <= 0) {
            return "Invalid triangle";
        }
        if (sideA + sideB <= sideC || sideA + sideC <= sideB || sideB + sideC <= sideA) {
            return "Invalid triangle";
        }
        if (sideA == sideB && sideB == sideC) {
            return "Equilateral";
        } else if (sideA == sideB || sideA == sideC || sideB == sideC) {
            return "Isosceles";
        } else {
            return "Scalene";
        }
    }


    public double getPerimeter() {
        return sideA + sideB + sideC;
    }


    public double getArea() {
        double s = getPerimeter() / 2;
        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
    }
}

