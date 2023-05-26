package ThreadRace;

import java.util.ArrayList;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 10000; i++) {
            list.add(i);
        }
        List<Integer> list1 = list.subList(0, 2500);
        List<Integer> list2 = list.subList(2500, 5000);
        List<Integer> list3 = list.subList(5000, 7500);
        List<Integer> list4 = list.subList(7500, 10000);

        SharedArrayList sharedList = new SharedArrayList();

        Thread t1 = new Thread(new MyRunnable(list1, sharedList));
        Thread t2 = new Thread(new MyRunnable(list2, sharedList));
        Thread t3 = new Thread(new MyRunnable(list3, sharedList));
        Thread t4 = new Thread(new MyRunnable(list4, sharedList));

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Even Numbers: " + sharedList.evenList);
        System.out.println("Odd Numbers: " + sharedList.oddList);
    }
}