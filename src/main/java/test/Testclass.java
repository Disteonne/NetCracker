package test;

public class Testclass {
    public static void main(String[] args) {
        lol l1;
        test t1;
        Track track=new Track();
        l1= (lol) track;
        t1=new Crane();
        t1=(test) l1;
    }
}
