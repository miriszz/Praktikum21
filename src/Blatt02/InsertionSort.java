package Blatt02;

import java.util.Random;
import java.util.Arrays;

public class InsertionSort {
    private static int count = 0;
    private static int[] array;

    public static void insertionSort(int[] array) {
        int n = array.length;
        if (n <= 1)
            return;
        for (int i = 1; i < n; ++i) {
            int value = array[i];
            int j = i - 1;
            for (; j >= 0; --j) {
                increment();
                if (array[j] > value) {
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }
            array[j + 1] = value;
        }
        assert isSorted(array) : "Its not sorted.";
    }

    //Anzahl der Vergleiche zwischen zwei Elementen des Arrays
    public static void increment() {
        count++;
    }

    public static int getCount() {
        return count;
    }

    //aufsteigend sortiert?
    public static boolean isSorted(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static void ausdrucken() {
        // ordentliche Ausdruck
        // Ausdrucken der unsortierten Array
        int[] arr = array.clone();
        for (int j = 0; j < arr.length; j++) {
            System.out.print(arr[j] + " ");
        }
        System.out.println();
        // Sortierung
        insertionSort(array);
        if (!isSorted(array)) {
            System.out.println("FEHLER: Feld ist NICHT sortiert!");
            System.out.println("Aufruf mit: java InsertionSort n [auf|ab|rand]");
            System.out.println("Beispiel: java InsertionSort 10000 rand");
            System.exit(0);
        }
        // Ausdrucken der sortierten Array
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
        System.out.println("Feld ist sortiert!");
        System.out.println("Das Sortieren des Arrays hat " + getCount() + " Vergleiche benoetigt.");
    }

    public static void ausdrucken1(){
        insertionSort(array);
        if (!isSorted(array)) {
            System.out.println("FEHLER: Feld ist NICHT sortiert!");
            System.out.println("Aufruf mit: java InsertionSort n [auf|ab|rand]");
            System.out.println("Beispiel: java InsertionSort 10000 rand");
            System.exit(0);
        }
        System.out.println("Feld ist sortiert!");
        System.out.println("Das Sortieren des Arrays hat " + getCount() + " Vergleiche benoetigt.");
    }




    public static void main(String[] args) {

        // Fehler ueber Parameteren
        if (args.length == 1 || args.length == 2) {
            // Der erste Parameter muss eine natuerliche Zahl sein.
            try {
                int lang = Integer.parseInt(args[0]);
            } catch (IllegalArgumentException e) {
//                System.out.println(args[0]);
                System.out.println("FEHLER: Der erste Parameter muss eine natuerliche Zahl sein.");
                System.out.println("Aufruf mit: java InsertionSort n [auf|ab|rand]");
                System.out.println("Beispiel: java InsertionSort 10000 rand");
                System.exit(0);
            }
            int lang = Integer.parseInt(args[0]);
            if (lang < 0) {
//                System.out.println(args[0]);
                System.out.println("FEHLER: Der erste Parameter muss eine natuerliche Zahl sein.");
                System.out.println("Aufruf mit: java InsertionSort n [auf|ab|rand]");
                System.out.println("Beispiel: java InsertionSort 10000 rand");
                System.exit(0);
            }

            // Erzeugen von Array
            String Befüllungsart;
            // Falls es keine zweite Parameter gibt.
            if (args.length == 1) {
                // Erzeugen mit zufällige Zahl
                array = new int[lang];
                Random rand = new Random(951);
                for (int i = 0; i < lang; i++) {
                    array[i] = Math.abs(rand.nextInt());
                }
                Befüllungsart = "rand";
                if (lang > 100) {
                    ausdrucken1();
                } else {
                    ausdrucken();
                }
            } else {
                // Falls die zweite Parameter 'auf', 'ab' oder 'rand' ist.
                Befüllungsart = args[1];
                array = new int[lang];
                if (Befüllungsart.equals("auf")) {
                    for (int i = 0; i < array.length; i++) {
                        array[i] = i+1;
                    }
                } else if (Befüllungsart.equals("ab")) {
                    int j = 0;
                    int i = array.length;
                    for (; i > 0; i--) {
                        array[j] = i;
                        j++;
                    }
                } else if (Befüllungsart.equals("rand")) {
                    Random rand = new Random(951);
                    for (int i = 0; i < lang; i++) {
                        array[i] = rand.nextInt();
                    }
                } else {
                    // Unbekanntes Vorsortierverfahren
                    System.out.println("FEHLER: Unbekanntes Vorsortierverfahren: " + Befüllungsart);
                    System.out.println("Aufruf mit: java InsertionSort n [auf|ab|rand]");
                    System.out.println("Beispiel: java InsertionSort 10000 rand");
                    System.exit(0);
                }
                if (lang > 100) {
                    ausdrucken1();
                } else {
                    ausdrucken();
                }
            }
        } else {
            System.out.println("FEHLER: Es muessen zwischen 1 und 2 Parameter angegeben werden.");
            System.out.println("Aufruf mit: java InsertionSort n [auf|ab|rand]");
            System.out.println("Beispiel: java InsertionSort 10000 rand");
            System.exit(0);
        }
    }
}

