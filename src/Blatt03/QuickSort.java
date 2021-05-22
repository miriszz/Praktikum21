package Blatt03;

import java.util.Arrays;
import java.util.Random;


public class QuickSort {

    private static int partitionFeq;
    private static final Random rng = new Random(1337);


    public static void quickSort(int[] array){
        quickSort(array, 0, array.length-1);
        System.out.println(Arrays.toString( array ).replace("[","").replace("]",""));
        
    }




    private static void quickSort(int[] array, int p, int r){
        if(p < r){
            int q = partition(array, p, r);

            quickSort(array, p, q-1);
            quickSort(array, q+1, r);
        }
    }




    private static int partition(int[] array, int p, int r){

        partitionFeq++;

        int z = rng.nextInt((r - p) + 1) + p;

        int temp = array[z];
        array[z] = array[r];
        array[r] = temp;

        int pivot = array[r];
        int i = p;
        int j = r - 1;


        while (i < j){
            while (array[i] > pivot){
                i++;
            }
            while (i < j && array[j] <= pivot){
                j--;
            }
            if(i < j){
                int temp2 = array[i];
                array[i] = array[j];
                array[j] = temp2;
            }
        }
        if (array[i] < array[r]){
            int temp3 = array[i];
            array[i] = array[r];
            array[r] = temp3;
        }
        return i;
    }










    public static void main(String[] args) {

        //ueberpruefung, ob allen eingegebene Zahlen int sind.
        try {
            int len = args.length;

            //falls keine Argumente eingegeben wird.
            if(len==0){
                System.out.println("FEHLER: Es wurden keine Argumente uebergeben.");
                return;
            }
            int[] arr = new int[len];
            for (int i = 0; i < len; i++) {
                arr[i] = Integer.parseInt(args[i]);
            }

            quickSort(arr);
            System.out.println(partitionFeq);

        }catch (Exception e){
            System.out.println("FEHLER: Es koennen nur ganze Zahlen sortiert werden.");
        }










    }




}
