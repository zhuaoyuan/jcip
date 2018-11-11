package chapter5;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class HiddenIterator {
    private static final Set<Integer> set = new HashSet<Integer>();

    public static synchronized void add(Integer i) { set.add(i); }
    public static synchronized void remove(Integer i) { set.remove(i); }

    public static void addTenThings() {
        Random r = new Random();
        for (int i = 0; i < 10; i++)
            add(r.nextInt());
        System.out.println("DEBUG: added ten elements to " + set);
    }

    public static void main(String[] args){
        addTenThings();
    }
}