package trash;

public class test2 {
    public static void main(String[] args) {
        String str="FN:Forrest Gump\r\nORG:Bubba Gump Shrimp Co.\r\nGENDER:M\r\nTEL;TYPE=HOME:4951234567";
       String str2=str.replace("\r\n"," ");
        /*
        String[] string=str.split("\\r\\n");
        for (String x:string
             ) {
            System.out.println(x);

        }
        System.out.println(string[1]);

         */
        System.out.println(str2);

        String str3="Hello  pip";
        System.out.println(str3.indexOf(':'));

        String str4="FN=HOME:4951234567";
        String[] strArray=str4.split(":");
        System.out.println(strArray[1]);
        char[] strtochar=strArray[1].toCharArray();
        System.out.println(strtochar.length);

        System.out.println(str4.startsWith("F"));
    }
}
