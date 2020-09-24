package trash;

public class compl extends  Object{
    public static void main(String[] args) {
 String str=null;
 char[] chaR={'1','2','4'};
        for (int i = 0; i < chaR.length; i++) {
            str+=chaR[i];
        }
        System.out.println(str);
        String str2="-1";
        System.out.println(Integer.parseInt(str2));

    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
