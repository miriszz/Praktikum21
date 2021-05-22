import java.util.Arrays;
import java.util.Random;

public class test {

    //.replace("[","").replace("]","")



    public static int[] reverseArr(int[] arr) {
        int len = arr.length;
        int[] arrNew = new int[len];
        for (int i = 0; i < len; i++) {
            arrNew[i] = arr[len-i-1];
        }
        return arrNew;
    }




    public static int[] qsort(int[] arr, int start, int end) {
        int pivot = arr[start];
        int i = start;
        int j = end;
        while (i<j) {
            while ((i<j)&&(arr[j]>pivot)) {
                j--;
            }
            while ((i<j)&&(arr[i]<pivot)) {
                i++;
            }
            if ((arr[i]==arr[j])&&(i<j)) {
                i++;
            } else {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        if (i-1>start) arr=qsort(arr,start,i-1);
        if (j+1<end) arr=qsort(arr,j+1,end);
        return (arr);
    }



    public static int test1(int p, int r){
        Random rng =  new Random(1337);
        int z = rng.nextInt((r - p) + 1) + p;
        return z;
    }

    public static void test2(){
        int[] arr = {1,2,1};
        for (int j : arr) {
            if (j != 1) {
                throw new IllegalArgumentException();
            }
        }
        System.out.println("aaa");
    }

    public static void main(String[] args) {
        test2();
    }




}
