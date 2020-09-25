package ru.skillbench.tasks.basics.math;

import java.util.Arrays;

public class ComplexNumberImpl implements ComplexNumber {
    private double re;
    private double im;


    public ComplexNumberImpl() {
        this.re = 0.0;
        this.im = 0.0;
    }

    public ComplexNumberImpl(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public ComplexNumberImpl(String complexNumber) {
        set(complexNumber);
    }

    @Override
    public double getRe() {
        return re;
    }

    @Override
    public double getIm() {
        return im;
    }

    @Override
    public boolean isReal() {
        if (re != 0 && im == 0)
            return true;
        else
            return false;
    }

    @Override
    public void set(double re, double im) {
        this.re = re;
        this.im = im;
    }

    @Override
    public void set(String value) throws NumberFormatException {
        String reE = "";
        String imM = "";
        char[] coml = value.toCharArray();
        char[] charRe = new char[20];
        char[] charIm = new char[20];
        //иниц массив
        // -1 <- арифм знаков нет
        int[] count = new int[2];
        for (int i = 0; i < count.length; i++) {
            count[i] = -1;
        }
        //Проверка ввода


        char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        char[] ALPHABET = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        char[] alphabetRU = {'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'э', 'ю', 'я'};
        char[] ALPHABETRU = {'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж', 'З', 'И', 'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Э', 'Ю', 'Я'};
        char[] symbols = {'*', '/', '?', ',', '{', '}', '[', ']', '|', ';', ':', '&', '%', '$', '#', '№', '@', '"', '^'};
        //Проверка на ввод
        //
        for (int i = 0; i < coml.length; i++) {
            for (int j = 0; j < alphabet.length; j++) {
                if (coml[i] == alphabet[j])
                    throw new NumberFormatException();
            }
        }
        for (int i = 0; i < coml.length; i++) {
            for (int j = 0; j < ALPHABET.length; j++) {
                if (coml[i] == ALPHABET[j])
                    throw new NumberFormatException();
            }
        }
        for (int i = 0; i < coml.length; i++) {
            for (int j = 0; j < alphabetRU.length; j++) {
                if (coml[i] == alphabetRU[j])
                    throw new NumberFormatException();
            }
        }
        for (int i = 0; i < coml.length; i++) {
            for (int j = 0; j < ALPHABETRU.length; j++) {
                if (coml[i] == ALPHABETRU[j])
                    throw new NumberFormatException();
            }
        }
        for (int i = 0; i < coml.length; i++) {
            for (int j = 0; j < symbols.length; j++) {
                if (coml[i] == symbols[j])
                    throw new NumberFormatException();
            }
        }

        int k = 0; //счетчик знаков
        //максимум два
        for (int i = 0; i < coml.length; i++) {
            if (coml[i] == '+' || coml[i] == '-') {
                count[k] = i;
                k++;
            }
        }


        //Проверка массива с индексами знаков
        /*
        for (int i = 0; i < count.length; i++) {
            System.out.println(count[i]);
        }

         */

        //Разделяем на этапы
        /*
         * 1й- если число имеет одну часть,то даже имея знак-запишется на 0й индекс count,поэтому либо так.либо число без знаков вообще
         * пример: +3i,4,-6,-10i
         * 2й- число имеет несколько частей.тогда:
         * 1) всего 1 знак (между ними)
         * 2) два знака (по знаку перед каждым числом) (второй индекс массива count ОБЯЗАТЕЛЬНО !=-1)
         */
        if (count[0] == 0 && count[1] == -1 || (count[0] == -1) && (count[1] == -1)) {
            boolean flag = false;

            for (int i = 0; i < coml.length; i++) {
                if (coml[i] == 'i') {
                    flag = true;
                }
            }

            if (flag == true) {
                for (int i = 0; i < coml.length - 1; i++) {
                    imM += coml[i];
                }
                if (coml.length == 1 && coml[0] != 'i') {
                    imM += '1';
                }
                if (coml[0] == 'i' && coml.length == 1) {
                    imM += '1';
                }
                try {
                    this.im = Double.parseDouble(imM);
                } catch (NumberFormatException ex) {

                }


            } else {
                for (int i = 0; i < coml.length; i++) {
                    reE += coml[i];
                }
                try {
                    this.re = Double.parseDouble(reE);
                } catch (NumberFormatException ex) {

                }

            }
        } else if (count[0] != -1 && count[1] != -1) { //оба числа имеют знак +4-3i
            boolean flag = false;
            for (int i = 0; i < coml.length; i++) {
                if (coml[i] == 'i') {
                    flag = true;
                }
            }
            if (flag == false) {
                throw new NumberFormatException();
            }
            //тут точно будет 2ч числа
            for (int i = 0; i < count[1]; i++) {
                charRe[i] = coml[i];
            }

            for (int i = count[1]; i < coml.length - 1; i++) {
                charIm[i] = coml[i];
            }
            /*
            for (int i = 0; i < charIm.length; i++) {
               int b= Arrays.binarySearch(charIm,'i');
                if (b==-1)
                    throw new NumberFormatException();
            }

             */
            //charIm[coml.length] = '0';
            int countTemp = 0;
            int indexOneElement = 0;
            for (int i = 0; i < charIm.length; i++) {
                if (charIm[i] != 0) {
                    indexOneElement = i;
                } else
                    countTemp++;
            }
            if (countTemp == 9) {
                charIm[indexOneElement + 1] = '1';
            }

            for (int i = 0; i < charRe.length; i++) {
                reE += charRe[i];
            }
            for (int i = 0; i < charIm.length; i++) {
                imM += charIm[i];
            }

            try {
                this.re = Double.parseDouble(reE);
                this.im = Double.parseDouble(imM);
            } catch (NumberFormatException ex) {

            }

        } else if (count[0] != -1 && count[1] == -1) {
            boolean flag = false;
            for (int i = 0; i < coml.length; i++) {
                if (coml[i] == 'i') {
                    flag = true;
                }
            }
            if (flag == false) {
                throw new NumberFormatException();
            }
            //тут точно будет 2ч числа

            for (int i = 0; i < count[0]; i++) {
                charRe[i] = coml[i];
            }
            for (int i = count[0]; i < coml.length - 1; i++) {
                charIm[i] = coml[i];
            }
            /*
            for (int i = 0; i < charIm.length; i++) {
                int b = Arrays.binarySearch(charIm, 'i');
                if (b == -1)
                    throw new NumberFormatException();
            }

             */
            //charIm[coml.length] = '0';
            int countTemp = 0;
            int indexOneElement = 0;
            for (int i = 0; i < charIm.length; i++) {
                if (charIm[i] != 0) {
                    indexOneElement = i;
                } else
                    countTemp++;
            }
            if (countTemp == 9) {
                charIm[indexOneElement + 1] = '1';
            }
            for (int i = 0; i < charRe.length; i++) {
                reE += charRe[i];
            }
            for (int i = 0; i < charIm.length - 1; i++) {
                imM += charIm[i];
            }
            if (charIm.length == 1) {
                imM += '1';
            }
            try {
                this.re = Double.parseDouble(reE);
                this.im = Double.parseDouble(imM);
            } catch (NumberFormatException ex) {

            }
        }
    }

    @Override
    public ComplexNumber copy() {
        ComplexNumberImpl complexNumber = new ComplexNumberImpl();
        complexNumber.set(this.re, this.im);
        return complexNumber;
    }

    @Override
    public ComplexNumber clone() throws CloneNotSupportedException {
        //return copy();
        ComplexNumber clone1 = new ComplexNumberImpl();
        clone1.set(re, im);
        return clone1;
    }

    @Override
    public String toString() {
        String result = "";
        if (re == 0.0) {
            result = result + im + "i";
        } else if (im == 0.0) {
            result = result + re;
        } else {
            if (im > 0) {
                result = "" + re + "+" + im + "i";
            } else result = "" + re + "" + im + "i";
        }
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ComplexNumberImpl) {
            ComplexNumber temp = (ComplexNumberImpl) obj;
            double thisRE = re;
            double thisIM = im;
            double objRE = temp.getRe();
            double objIM = temp.getIm();


            if (Math.ceil(thisIM) == Math.ceil(objRE) && Math.ceil(thisIM) == Math.ceil(objIM))
                return true;
            else {
                return false;
            }
        }
        else
            return false;

    }

    @Override
    public int compareTo(ComplexNumber other) {
        Double absOne = Math.pow(Math.abs(Math.pow(re, 2) + Math.pow(im, 2)), 2);
        Double absTwo = Math.pow(Math.abs(Math.pow(other.getRe(), 2) + Math.pow(other.getIm(), 2)), 2);
        int result = absOne.compareTo(absTwo);
        return result;
    }

    @Override
    public void sort(ComplexNumber[] array) {
        Arrays.sort(array, ComplexNumber::compareTo);
    }

    @Override
    public ComplexNumber negate() {
        double Re = this.re;
        double Im = this.im;
        this.re = -Re;
        this.im = -Im;

        return this;
    }

    @Override
    public ComplexNumber add(ComplexNumber arg2) {
        double Re = this.re;
        double Im = this.im;
        this.re = Re + arg2.getRe();
        this.im = Im + arg2.getIm();

        return this;
    }

    @Override
    public ComplexNumber multiply(ComplexNumber arg2) {
        double Re = this.re;
        double Im = this.im;
        //a+bi
        //c+di
        //(a*c-b*d)+(b*c+a*d)i
        this.re = Re * arg2.getRe() - Im * arg2.getIm();
        this.im = Im * arg2.getRe() + Re * arg2.getIm();

        return this;
    }

    public static void main(String[] args) {
        ComplexNumber c1=new ComplexNumberImpl(1,1);
        ComplexNumberImpl c2=new ComplexNumberImpl(1,1);
        Cat cat=new Cat();
        System.out.println(c1.equals(null));
    }

}
class  Cat{

}


