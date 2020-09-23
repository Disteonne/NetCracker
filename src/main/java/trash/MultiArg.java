package trash;

import java.util.Arrays;

public class MultiArg {
    static double[] arr=new double[10];
    public static void main(String[] args) {
        MultiArg multiArg=new MultiArg();
        multiArg.printtt(1,2,3);
    }
    public static  void printtt(double... v){
        for (int i = 0; i < v.length; i++) {
            arr[i]=v[i];
           // System.out.println(arr[i]);
        }
        Arrays.copyOf(arr,4);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
