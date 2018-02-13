package basics;

import java.util.ArrayList;

public class Iter {
    public void forLoop() {
        // equivalent to python for i in range(10)
        // print no's from 1 to 10
        for(Integer i=0; i<10; i++) {
            System.out.println(i);
        }
    }

    public void forEachLoop() {
        ArrayList<Integer> alist = new ArrayList<Integer>();
        alist.add(2016);
        alist.add(5);
        alist.add(9);

        for(Integer i : alist) {
            System.out.printf("%5d ", i);
        }

        System.out.println();
    }

    public void forEachLoopString(String name) {
        for(char c : name.toCharArray()) {
            System.out.printf("%3s", c);
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Iter it = new Iter();
        // it.forLoop();
        // it.forEachLoop();
        it.forEachLoopString("Gaurav Singh");

    }
}