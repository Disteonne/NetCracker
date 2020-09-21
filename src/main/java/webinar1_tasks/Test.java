package webinar1_tasks;

public class Test {
    public static void main(String[] args) {

        Integer i=2;
        Integer j=2;
        boolean b=(i==j);
        System.out.println(i+" = "+j+" : "+ (i==j));

        i=142;//-128 до 127 кэш.а дальше о=созд новые объекты
        j=142;
        boolean bb=(i==j);
        System.out.println(i+" = "+j+" : "+ (i==j));
        System.out.println(i.equals(j));
    }
}
