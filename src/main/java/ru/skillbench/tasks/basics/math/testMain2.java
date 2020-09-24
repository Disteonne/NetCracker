package ru.skillbench.tasks.basics.math;

public class testMain2 {
    public static void main(String[] args) {
        //SET
        /*
        ComplexNumberImpl c1 = new ComplexNumberImpl("-1.0-3.5i");
        System.out.println(c1.re);
        System.out.println(c1.im);
        c1.set("1+i");
        System.out.println(c1.re);
        System.out.println(c1.im);

        System.out.println();

         */

        //COPY
        /*
        ComplexNumber c2=new ComplexNumberImpl();
        c2=c1.copy();
        System.out.println(c1.re);
        System.out.println(c1.im);
        System.out.println(c2==c1);
        System.out.println(c1.copy().equals(c1));

        System.out.println();


         */
        //toSTRING
        //System.out.println(c1);
        /*
        ComplexNumber c3 = new ComplexNumberImpl();
        c3.set("-3-i");
        System.out.println(c3);

        //COMPARETO

        ComplexNumber c4 = new ComplexNumberImpl();
        c4.set(3, 8);
        ComplexNumber c5 = new ComplexNumberImpl();
        c5.set(17, 20);
        System.out.println(c5.compareTo(c4));

        //SORT
        ComplexNumber[] array = new ComplexNumberImpl[4];
        array[0] = c4;
        array[1] = c5;
        ComplexNumber c6 = new ComplexNumberImpl(2, 2);
        ComplexNumber c7 = new ComplexNumberImpl(10, 10);
        array[2] = c6;
        array[3] = c7;
        ComplexNumber c8=new ComplexNumberImpl();
        c8.sort(array);
        for (ComplexNumber i:array
             ) {
            System.out.println(i);
        }

        System.out.println();

        //NEGATIVE
        ComplexNumber c9=new ComplexNumberImpl(3,-6);
        c9.negate();
        System.out.println(c9);

        System.out.println();

        //ADD
        ComplexNumber c10=new ComplexNumberImpl(5,-9);
        ComplexNumber c11=new ComplexNumberImpl("i");
        c10.add(c11);
        System.out.println(c10);


         */
        //MULTIPLAY
        ComplexNumber c12=new ComplexNumberImpl(5,-9);
        ComplexNumber c13=new ComplexNumberImpl("i");
        c12.multiply(c13);
        System.out.println(c12);
    }
}
