package trash;

public class array {
    public static void main(String[] args) {
        int[][] array=new int[8][5];
        System.out.println(array[0].length);
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                array[i][j]=(i+5)*(j-3);
            }
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.print(array[i][j]+"\t");
            }
            System.out.println();
        }

        int[] ar = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            int min = array[i][0];
            for (int j = 0; j < array[0].length; j++) {
                if (min > array[i][j]) {
                    min = array[i][j];
                }
            }
            ar[i] = min;
        }
        int minimum=ar[0];
        for (int i = 0; i < ar.length - 1; i++) {
            if (minimum > ar[i + 1]) {
                minimum = ar[i + 1];
            }
        }
        System.out.println(minimum);
    }
}
