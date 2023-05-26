package ThreadRace;

import java.util.List;
public class MyRunnable implements Runnable{
    List<Integer> list;
    SharedArrayList sharedList;

    MyRunnable(List<Integer> list, SharedArrayList sharedList) {
        this.list = list;
        this.sharedList = sharedList;
    }

    @Override
    public void run() {
        for (int num : list) {
            sharedList.addNumber(num);
        }
    }
}