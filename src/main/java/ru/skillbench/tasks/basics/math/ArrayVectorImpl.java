package ru.skillbench.tasks.basics.math;

import java.util.Arrays;
public class ArrayVectorImpl implements ArrayVector {
    //private ArrayVectorImpl arVector;
    private double[] vector;

   public ArrayVectorImpl() {
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
        ArrayVectorImpl clone=new ArrayVectorImpl();
        System.arraycopy(vector,0,clone.vector,0,vector.length);
        clone.vector=Arrays.copyOf(clone.vector,vector.length);
        // 1й вариант:
        //ArrayVector arVector = new ArrayVectorImpl();
        //arVector.set(vector);
        //return (ArrayVector) arVector;
        return clone;
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
        double[] tmpArray=new double[vector.length];
        for (int i = 0; i < tmpArray.length; i++) {
            tmpArray[i]=vector[i];
        }
        Arrays.sort(tmpArray);
        return tmpArray[tmpArray.length-1];

    }

    @Override
    public double getMin() {
        double[] tmpArray=new double[vector.length];
        for (int i = 0; i < tmpArray.length; i++) {
            tmpArray[i]=vector[i];
        }
        Arrays.sort(tmpArray);
        return tmpArray[0];
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


}
