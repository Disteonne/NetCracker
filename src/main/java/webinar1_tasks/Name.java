package webinar1_tasks;

import java.util.HashSet;
import java.util.Set;

public class Name {
    private String first,last;

    public Name(String first, String last) {
        this.first = first;
        this.last = last;
    }

    @Override
    public boolean equals(Object o) {
        //if (this == o) return true;
        if (!(o instanceof  Name)) return false;
        Name n = (Name) o;
        return n.first.equals(first) && n.last.equals(last);
    }

    public static void main(String[] args) {
        Set s=new HashSet();
        //Set<Name> s=new HashSet<>();
        Name name=new Name("Brad","Pitt");
        s.add(name);
        System.out.println(s.contains(name));

    }


}
