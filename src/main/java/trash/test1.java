package trash;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class test1 {
    public static void main(String[] args) {
        Integer[] array={1,3,4,6,2,3,1,2,5,8,92,7,-35,8};
        Set<Integer> set=new HashSet<>();
        List<Integer> list=new LinkedList<>();
        for (int x:array
             ) {
            if(set.contains(x)){
                list.add(x);
            }
            else
                set.add(x);
        }

        for (int x:list
             ) {
            System.out.println(x);
        }
    }
}
