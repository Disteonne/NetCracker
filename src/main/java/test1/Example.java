package test1;

public  class Example {
    public  static void increment(Integer N){
        N=N+1;
    }
    static void  result(int x){
        Integer X=x;
        increment(X);
        System.out.println(X);
    }

    public static void main(String[] args) {
        result(30);
    }
}
