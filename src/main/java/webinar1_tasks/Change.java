package webinar1_tasks;

import java.io.BufferedReader;

public class Change {
    public static void main(String[] args) {
        System.out.println(7.00-1.10);
        System.out.println(5.342/0);
        StringBuffer str=new StringBuffer("one");
        StringBuffer str1=new StringBuffer("two");
        swap(str,str1);
        System.out.println(str+" "+str1);

        int l=0x123F;
    }
    static void swap(StringBuffer a,StringBuffer b){
        a.append(" more");
        b=a;
    }
}
