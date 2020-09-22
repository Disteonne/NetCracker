package ru.skillbench.tasks.basics.control;

public class ControlFlowStatements1Impl implements ControlFlowStatements1 {
    @Override
    public float getFunctionValue(float x) {
        if (x > 0) {
            return (float) (2 * Math.sin(x));
        } else
            return (6 - x);
    }

    @Override
    public String decodeWeekday(int weekday) {
        String dayOfWeek = null;
        switch (weekday) {
            case 1:
                dayOfWeek = "Monday";
                break;
            case 2:
                dayOfWeek = "Tuesday";
                break;
            case 3:
                dayOfWeek = "Wednesday";
                break;
            case 4:
                dayOfWeek = "Thursday";
                break;
            case 5:
                dayOfWeek = "Friday";
                break;
            case 6:
                dayOfWeek = "Saturday";
                break;
            case 7:
                dayOfWeek = "Sunday";
                break;
            default:
                break;
        }
        return dayOfWeek;
    }

    @Override
    public int[][] initArray() {
        int[][] array = new int[8][5];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 5; j++) {
                array[i][j] = (i+2)*(j-1);
            }
        }
        return array;
    }

    @Override
    public int getMinValue(int[][] array) {
        int[] ar = new int[8];
        for (int i = 0; i < 8; i++) {
            int min = array[i][0];
            for (int j = 0; j < 5; j++) {
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
        return minimum;
    }

    @Override
    public BankDeposit calculateBankDeposit(double P) {
        double newSum = 1000;
        int years = 0;
        while (newSum < 5000) {
            newSum += newSum * P / 100;
            years++;
        }
        BankDeposit bankDeposit = new BankDeposit();
        bankDeposit.amount = newSum;
        bankDeposit.years = years;
        return bankDeposit;
    }

    public static void main(String[] args) {
        ControlFlowStatements1 object = new ControlFlowStatements1Impl();

        System.out.println(object.getFunctionValue(-4));

        int[][] arrayTest = object.initArray();

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(arrayTest[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println(object.decodeWeekday(3));
        System.out.println(object.getMinValue(arrayTest));
        BankDeposit bankDeposit111 = new BankDeposit();
        bankDeposit111 = object.calculateBankDeposit(100);
        System.out.println(bankDeposit111);
    }

}
