package Blatt04;

public class testLine {
    public static void main(String[] args){

        Point p1 = new Point(1,1);
        Point p2 = new Point(2,2);

        Line l = new Line(p1, p2);

        System.out.println(p1.toString());
        System.out.println(l.toString());

        System.out.println(l.side(p1));
    }
}