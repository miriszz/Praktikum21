package Blatt04;
import java.util.ArrayList;

public class ConvexHull {


    Point Eckpunkte;
    Point linkste;
    Point rechtste;
    int n;
    int min; int max;   //tmp



    //1.Aufsteigende BubbleSort durch x
    public void BubbleSort(ArrayList<Point> points){
        for(int i=1; i<points.size(); i++){
            for(int j=1; j<points.size(); j++){
                if( points.get(j - 1).get(0) > points.get(j).get(0) ){
                    Point tmp = points.get(j - 1);

                    //arr[j-1] = arr[j];
                    points.set(j-1, points.get(j));

                    //arr[j] = tmp;
                    points.set(j, tmp);
                }
            }
        }
    }








    public void delateSamePoint(ArrayList<Point> points){
        for(int i=0; i<n; i++){
            for(int j=1; j<n; j++){
                if(points.get(i).get(0)== points.get(j).get(0) && points.get(i).get(1)== points.get(j).get(1)){
                    points.set(j, null);
                }
            }
        }
    }




    //3.teile die Punkten in Q und R
    public void teileHull(ArrayList<Point> points, Line l){

        ArrayList<Point> Q = new ArrayList<Point>();
        ArrayList<Point> R = new ArrayList<Point>();


        //in Q und R hinzufügen
        for(int i=0; i<n; i++){
            if(l.side(points.get(i))==1){
                Q.add(i, points.get(i));
            }
            else if(l.side(points.get(i))==-1){
                R.add(i, points.get(i));
            }
        }
        System.out.println(Q);
        System.out.println(R);

    }



    //Winkel rechnen
    public double getAngle(Point o, Point s, Point e){
        double cosfi = 0, fi = 0, norm = 0;
        double dsx = s.get(0) - o.get(0);
        double dsy = s.get(1) - o.get(1);
        double dex = e.get(0) - o.get(0);
        double dey = e.get(1) - o.get(1);

        cosfi = dsx * dex + dsy * dey;
        norm = (dsx * dsx + dsy * dsy) * (dex * dex + dey * dey);
        cosfi /= Math.sqrt(norm);

        if (cosfi >= 1.0) return 0;
        if (cosfi <= -1.0) return Math.PI;
        fi = Math.acos(cosfi);

        if (180 * fi / Math.PI < 180){
            return 180 * fi / Math.PI;
        }
        else{
            return 360 - 180 * fi / Math.PI;
        }
    }








    public void computeHull(ArrayList<Point> points){

        int n = points.size();

        BubbleSort(points);

        //bekomme p1, pn
        Point p1 = points.get(0);
        Point pn = points.get(points.size() - 1);

        //bekomme line l1: p1pn
        Line l1 = new Line(p1, pn);
        //bekommepmax
        Point pmax = l1.getPmax(points);

        //bekomme line l2: p1pmax
        Line l2 = new Line(p1, pmax);
        //bekomme line l3: pnpmax
        Line l3 = new Line(pn, pmax);


        //Punkten in linkseite von l2 in Q hinzufügen，Punkten in rechtseite von l3 in R hinzufügen
        teileHull(points, l2);
        teileHull(points, l3);

        n--;

        if(n>3) {
            computeHull(points);
        }
        else{
            System.out.println(points);
        }










    }






}
