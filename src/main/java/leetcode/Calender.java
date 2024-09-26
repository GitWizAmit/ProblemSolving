package main.java.leetcode;

import java.util.TreeMap;

public class Calender {
    TreeMap<Integer, Integer> calender;
    public MyCalendar() {
        calender = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Integer prev = calender.floorKey(start);
        Integer next = calender.ceilingKey(start);

        if ((prev == null || calender.get(prev) <= start) &&
                (next == null || next >= end)) {

            calender.put(start, end);
            return true;
        }
        return false;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
