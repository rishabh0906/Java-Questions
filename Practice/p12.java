
import java.util.Scanner;

public class p12 {
    public static Scanner scn = new Scanner(System.in);

    public static class Circle {
        private double radius;
        private double area;

        // this is consturctor method
        public Circle(double radius) {
            setRadius(radius);
            Calculation();
        }

        private void setRadius(double radius) {
            this.radius = radius;
        }

        public double getRadius() {
            return this.radius;
        }

        private void setArea(double area) {
            this.area = area;
        }

        public double getArea() {
            return this.area;
        }

        // //
        private void Calculation() {
            double area = 3.142 * this.radius * this.radius;
            setArea(area);
        }
    }

}
