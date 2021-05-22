package Blatt01;

public class Euclid {


    public static int EUCLID(int a, int b){
        if(b==0){
            return a;
        }
        else{
            return EUCLID(b, a%b);
        }
    }




    public static void main(String[] args) {
        try{
            if(args.length!=2){
                throw new IllegalArgumentException();
            }
            else{
                try{
                    int x = Integer.parseInt(args[0]);
                    int y = Integer.parseInt(args[1]);
                    System.out.println(EUCLID(x, y));
                }
                catch (Exception e){
                    System.out.println("Falscher Parameter - Nur Zahlen sind erlaubt!");
                    error();
                }
            }
        }
        catch (Exception e){
            System.out.println("Falsche Parameteranzahl!");
            error();
        }

    }


    public static void error(){
        System.out.println("Aufruf mit: java Euclid a b");
        System.out.println("Dabei muessen a und b natuerliche Zahlen groesser 0 sein.");
        System.out.println("Beispiel: java Euclid 24 896");
    }









}
