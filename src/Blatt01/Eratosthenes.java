package Blatt01;

public class Eratosthenes {


    public static boolean isPrime(int n) {
        if (n < 3) {
            return n == 2;
        }
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }




    public static void printEratosthenes(int n){
        for(int i = 0; i < n; i++) {
            if(isPrime(i)){
                System.out.print(i + " ");
            }
        }
    }




    public static int getAnzahl(int n){
        int Anzahl = 0;
        for(int i = 0; i < n; i++) {
            if(isPrime(i)){
                Anzahl++;
            }
        }
        System.out.println();
        return Anzahl;
    }




    public static void main(String[] args) {

        try{
            //wenn nur eine Eingabe haben
            if(args.length==1){

                try {
                    Integer.parseInt(args[0]);
                }catch (Exception e){
                    System.out.println("Falscher Parameter! Nur Integer groesser 0 sind erlaubt.");
                }


                int x = Integer.parseInt(args[0]);
                if(x<=0){
                    System.out.println("Falscher Parameter! Nur Integer groesser 0 sind erlaubt.");
                    throw new Exception();
                }
                else{
                    System.out.println(getAnzahl(x));
                }
            }


            //wenn zwei Eingaben haben
            else if(args.length==2){

                //Vertauschte Kommandozeilenparameter
                try {
                    Integer.parseInt(args[0]);
                }catch (Exception e){
                    System.out.println("Falscher Parameter! Nur Integer groesser 0 sind erlaubt.");
                }


                int x = Integer.parseInt(args[0]);
                if(x<=0){
                    System.out.println("Falscher Parameter! Nur Integer groesser 0 sind erlaubt.");
                    throw new Exception();
                }
                else{
                    if(args[1].equals("-o")){
                        System.out.println(getAnzahl(x));
                        printEratosthenes(x);
                    }

                    //wenn die zweite Eingabe nicht -o ist: auch getZahl(x)
                    else{
                        System.out.println(getAnzahl(x));
                    }
                }
            }


            //mehrere Eingaben oder gar keine
            else{
                System.out.println("Falsche Parameteranzahl!");
                throw new Exception();
            }
        }
        catch (Exception e){
            System.out.println("Aufruf mit : java Eratosthenes n [-o]");
            System.out.println("Es wird die Anzahl der Primzahlen aus dem Bereich [2,n] berechnet.");
            System.out.println("Mit -o werden diese Zahlen auch ausgegeben.");
            System.out.println("Bsp: java Eratosthenes 100 -o");
        }
    }



}

