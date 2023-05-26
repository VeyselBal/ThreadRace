package ThreadRace;

import java.util.ArrayList;
import java.util.List;
public class SharedArrayList {
    List<Integer> evenList = new ArrayList<>();
    List<Integer> oddList = new ArrayList<>();

    synchronized void addNumber(int number) {
        if (number % 2 == 0) {
            evenList.add(number);
        } else {
            oddList.add(number);
        }
    }
}

