package ru.skillbench.tasks.basics.math;


import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Map;

public class ArrayVectorImpl implements ArrayVector {
    //private ArrayVectorImpl arVector;
    private double[] vector;

    ArrayVectorImpl() {
        vector = new double[100];
    }
     
     /*
     private ArrayVectorImpl(){
         ArrayVectorImpl ar=new ArrayVectorImpl();
         this.vector=ar.get();
     }
     
      */

    @Override
    public void set(double... elements) {
        for (int i = 0; i < elements.length; i++) {
            vector[i] = elements[i];
        }
        vector = Arrays.copyOf(vector, elements.length);

    }

    @Override
    public double[] get() {
        return vector;
    }


    @Override
    public ArrayVector clone() {
        ArrayVectorImpl arVector = new ArrayVectorImpl();
        arVector.vector = get();

        // aV= (ArrayVector) Arrays.clone(vector);
        return (ArrayVector) arVector;
    }


    @Override
    public int getSize() {
        return vector.length;
    }


    @Override
    public void set(int index, double value) {
        if (index >= 0 && index < vector.length) {
            vector[index] = value;
        } else if (index > vector.length) {
            vector = Arrays.copyOf(vector, index + 1);
            vector[index] = value;
        } else
            ;
    }

    @Override
    public double get(int index) throws ArrayIndexOutOfBoundsException {
        double getIndex;
        if (index < vector.length && index >= 0) {
            getIndex = vector[index];
        } else
            throw new ArrayIndexOutOfBoundsException();
        return getIndex;
    }

    @Override
    public double getMax() {
        Arrays.sort(vector);
        return vector[vector.length - 1];
    }

    @Override
    public double getMin() {
        Arrays.sort(vector);
        return vector[0];
    }

    @Override
    public void sortAscending() {
        Arrays.sort(vector);
    }

    @Override
    public void mult(double factor) {
        for (int i = 0; i < vector.length; i++) {
            vector[i] *= factor;
        }
    }

    @Override
    public ArrayVector sum(ArrayVector anotherVector) {

        if (vector.length == anotherVector.get().length) {
            for (int i = 0; i < vector.length; i++) {
                vector[i] += anotherVector.get()[i];
            }
        } else if (vector.length < anotherVector.get().length) {
            for (int i = 0; i < vector.length; i++) {
                vector[i] += anotherVector.get()[i];
            }
        } else {
            //int tmp= vector.length-anotherVector.get().length;
            //int count=0;
            for (int i = 0; i < anotherVector.get().length; i++) {
                vector[i] += anotherVector.get()[i];
            }
        }

        ArrayVectorImpl arVec = new ArrayVectorImpl();
        arVec.vector = vector;
        return (ArrayVector) arVec;
    }

    @Override
    public double scalarMult(ArrayVector anotherVector) {
        double scalar = 0;
        if (vector.length == anotherVector.get().length) {
            for (int i = 0; i < vector.length; i++) {
                scalar += vector[i] * anotherVector.get()[i];
            }
        } else if (vector.length > anotherVector.get().length) {
            for (int i = 0; i < anotherVector.get().length; i++) {
                scalar += vector[i] * anotherVector.get()[i];
            }
        } else {
            for (int i = 0; i < vector.length; i++) {
                scalar += vector[i] * anotherVector.get()[i];
            }
        }
        return scalar;
    }

    @Override
    public double getNorm() {
        ArrayVector CLONE = clone();
        return Math.sqrt(CLONE.scalarMult(CLONE));
    }

    public static void main(String[] args) {
        double[] r;
        //test SET
        ArrayVectorImpl a = new ArrayVectorImpl();
        a.set(1, 45, 1.7, 9);
        //test CLONE
        ArrayVector arvect = a.clone();
        r = arvect.get();

        for (int i = 0; i < r.length; i++) {
            System.out.println(r[i]);
        }
        System.out.println();
        //SET INDEX
        a.set(5, 6.8);
        r = a.get();
        for (int i = 0; i < r.length; i++) {
            System.out.println(r[i] + " " + r.length);
        }

        //GET INDEX
        System.out.println(a.get(2));

        //GET MAX
        System.out.println();
        System.out.println(a.getMax());

        //MULTI
        a.mult(5);
        r = a.get();
        for (int i = 0; i < r.length; i++) {
            System.out.println(r[i]);
        }

        //SUM
        ArrayVectorImpl ar1 = new ArrayVectorImpl();
        ar1.set(1, 1, 1);
        ArrayVectorImpl ar2 = new ArrayVectorImpl();
        ar2.set(2.0, 2.3);
        ar1.sum(ar2);
        for (int i = 0; i < ar1.get().length; i++) {
            System.out.print(ar1.get()[i] + "\t");
        }

        System.out.println();
        System.out.println(ar1.scalarMult(ar2));

        //SCALAR
        ArrayVectorImpl ar3 = new ArrayVectorImpl();
        ar3.set(1.0, 1.0, 1.0);
        ArrayVectorImpl ar4 = new ArrayVectorImpl();
        ar4.set(1.0, 2.4, 1.0);
        double res = ar3.scalarMult(ar4);
        System.out.println(res);
        System.out.println();
        //NORMA
        ArrayVectorImpl ar5 = new ArrayVectorImpl();
        ar5.set(1, 9, 3);
        System.out.println(ar5.getNorm());
    }
}
