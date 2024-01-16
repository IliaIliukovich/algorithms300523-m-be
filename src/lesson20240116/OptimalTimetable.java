package lesson20240116;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class OptimalTimetable {

// Задача. Даны заявки на проведение активити в некоторой аудитории.
// В каждой заявке указаны начало и конец активити. Нужно из всех заявок оставить как можно больше таким образом,
// чтобы они не пересекались.
    public static void main(String[] args) {
        // room open 10:00 - 20:00
        List<Event> events = Arrays.asList(
                new Event(11.0, 12.0),
                new Event(13.5, 15.5),
                new Event(10.0, 19.0),
                new Event(17.0, 19.5),
                new Event(19.0, 20.0)
                );
        List<Event> eventsInTheRoom = findOptimalTimetable(10.0, 20.0, events);
        eventsInTheRoom.forEach(System.out::println);
    }

    public static List<Event> findOptimalTimetable(double startOfDay, double endOfDay, List<Event> events) { // O (n log n)
        events.sort(Comparator.comparingDouble(o -> o.end)); // O(n log n)

        List<Event> eventsInTheRoom = new ArrayList<>();
        double previousEnd = startOfDay;
        for (Event e : events) { // O(n)
            if (e.start >= previousEnd && e.end <= endOfDay) {
                eventsInTheRoom.add(e);
                previousEnd = e.end;
            }
        }
        return eventsInTheRoom;
    }


    static class Event {
        double start;
        double end;

        public Event(double start, double end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "Event{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }

}
