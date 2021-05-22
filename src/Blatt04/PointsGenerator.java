package Blatt04;
import java.util.ArrayList;


public class PointsGenerator {


    java.util.Random generator = new java.util.Random();
    double min = 0;
    double max = 1.00;
    int n;




    public PointsGenerator(double min, double max){
        min = this.min;
        max = this.max;
        generate(n);
    }




    //返回一个随机多个Point的ArrayList，并且每个点已经根据x从小到大排好序了
    public ArrayList<Point> generate(int n) {

        ArrayList<Point> points = new ArrayList<Point>();

        for(int i=0; i<n; i++) {
            double x = min + ((max - min) * generator.nextDouble());
            double y = min + ((max - min) * generator.nextDouble());
            Point P = new Point(x, y);

            points.add(P);
        }
        return points;
    }















}
