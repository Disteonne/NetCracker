package ru.skillbench.tasks.basics.math;

public class ComplexNumberImpl implements ComplexNumber {
    private double re;
    private double im;

    ComplexNumberImpl() {
        this.re = 0.0;
        this.im = 0.0;
    }

    public ComplexNumberImpl(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public ComplexNumberImpl(String complexNumber) {
        String reE = "";
        String imM = "";
        char[] coml = complexNumber.toCharArray();
        int index = -1;
        for (int i = 0; i < coml.length; i++) {
            if (coml[i] == '+' || coml[i] == '-') {
                index = i;
                break;
            }
        }

        for (int i = 0; i < coml.length; i++) {
            if (index == 0 && coml[i] == 'i' || index == -1 && coml[i] == 'i') {
                this.re = 0.0;

                if ((index == -1 )||(index==0 && coml[index]=='+')) {  //у нас есть мнимая часть.но нет знака + или -
                    //в основном-тогда.когда число положительное (не пишется + по умолчанию)
                    if(index==-1) {
                        int k = i;
                        for (int j = 0; j < coml.length - 1; j++) {
                            imM += coml[j];
                        }
                    }
                    if(index==0){
                        for (int j = 1; j < coml.length-1; j++) {
                            imM+=coml[j];
                        }
                    }
                    this.im = Double.parseDouble(imM);
                }
                if (index == 0 && coml[index] == '-') {
                    int k = i;
                    for (int j = 1; j < coml.length - 1; j++) {
                        imM += coml[j];
                    }
                    this.im = -Double.parseDouble(imM);
                }
            }
        }
    }

    public static void main(String[] args) {
        ComplexNumberImpl c1 = new ComplexNumberImpl("+4i");
        System.out.println(c1.re);
        System.out.println(c1.im);
    }
}



