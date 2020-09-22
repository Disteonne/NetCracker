package ru.skillbench.tasks.basics.control;

public class ControlFlowStatements2Impl implements ControlFlowStatements2 {
    @Override
    public int getFunctionValue(int x) {
        if (x < -2 || x > 2) {
            return 2 * x;
        } else
            return -3 * x;
    }

    @Override
    public String decodeMark(int mark) {
        String str = null;
        switch (mark) {
            case 1:
                str = "Fail";
                break;
            case 2:
                str = "Poor";
                break;
            case 3:
                str = "Satisfactory";
                break;
            case 4:
                str = "Good";
                break;
            case 5:
                str = "Excellent";
                break;
            default:
                str="Error";
                break;
        }
        return str;
    }

    @Override
    public double[][] initArray() {
        double[][] array = new double[5][8];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 8; j++) {
                array[i][j] = Math.pow(i, 4) - Math.sqrt(j);
            }
        }
        return array;
    }

    @Override
    public double getMaxValue(double[][] array) {
        double[] maxArr = new double[5];
        for (int i = 0; i < 5; i++) {
            double max1 = array[i][0];
            for (int j = 0; j < 7; j++) {
                if (max1 < array[i][j + 1])
                    max1 = array[i][j + 1];
            }
            maxArr[i] = max1;
        }
        double max = 0;
        for (int i = 0; i < maxArr.length - 1; i++) {
            if (maxArr[i] < maxArr[i + 1]) {
                max = maxArr[i + 1];
            }
        }
        return max;
    }

    @Override
    public Sportsman calculateSportsman(float P) {
        Sportsman sportsman = new Sportsman();
        float distance = 10;
        while (sportsman.getTotalDistance() < 200) {
            sportsman.addDay(distance);
            distance += distance * P / 100.0;
        }
        return sportsman;
    }
}

class Test{
    public static void main(String[] args) {
        ControlFlowStatements2 c=new ControlFlowStatements2Impl();
        double[][] a=c.initArray();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(a[i][j]+"\t");
            }
            System.out.println();
        }
        double MAX=c.getMaxValue(a);
        System.out.println(MAX);

        ControlFlowStatements2.Sportsman sportsman= c.calculateSportsman(12.5f);
        System.out.println(sportsman);
    }


}