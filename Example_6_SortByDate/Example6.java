package Example_6_SortByDate;

import java.time.LocalDate;
import java.util.List;
import java.util.Collections;
import java.util.ArrayList;

class Event implements Comparable<Event> {
    String title;
    LocalDate date;

    Event(String title, LocalDate date) {
        this.title = title;
        this.date = date;
    }

    @Override
    public int compareTo(Event other) {
        return this.date.compareTo(other.date);   // earliest first
    }

    @Override
    public String toString() {
        return title + " on " + date;
    }
}

public class Example6 {
    public static void main(String[] args) {
        List<Event> list = new ArrayList<>();
        list.add(new Event("Christmas", LocalDate.of(2026, 12, 25)));
        list.add(new Event("New Year", LocalDate.of(2026, 1, 1)));
        list.add(new Event("Exam", LocalDate.of(2026, 10, 9)));

        Collections.sort(list);
        System.out.println(list);
    }
}