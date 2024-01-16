package lesson20240116;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FindOptimalTasks {

// Дано n заданий, где каждое задание имеет крайний срок и стоимость.
//Также известно, что каждое задание занимает одну единицу времени,
//поэтому минимально возможный крайний срок для любого задания равен 1.
//Как максимизировать общую прибыль, если единовременно может быть запланировано только одно задание?
// Input: Four Jobs with following deadlines and profits
//JobID  Deadline  Profit
//  a      	4       20
//  b      	1       10
//  c      	1       40
//  d     	1	    30
//Output: Following is maximum profit sequence of job -> c, a

    public static void main(String[] args) {
        List<Task> tasks = Arrays.asList(
                new Task("a", 20, 4),
                new Task("b", 100, 3),
                new Task("c", 40, 1),
                new Task("d", 30, 1),
                new Task("e", 80, 3)
        );

        List<Task> optimalChoice = findOptimalTasks(tasks);
        optimalChoice.forEach(System.out::println);
    }

    public static List<Task> findOptimalTasks(List<Task> tasks) {
        int lastDay = tasks.stream().mapToInt(task -> task.deadline).max().getAsInt();
        boolean[] isNotFree = new boolean[lastDay];

        tasks.sort((o1, o2) -> o2.cost - o1.cost);

        List<Task> optimalChoice = new ArrayList<>();
        for (Task task : tasks) {
            for (int i = task.deadline; i > 0; i--) {
                if (!isNotFree[i - 1]) {
                    optimalChoice.add(task);
                    isNotFree[i - 1] = true;
                    break;
                }
            }
        }
        optimalChoice.sort(Comparator.comparingInt(o -> o.deadline));
        return optimalChoice;
    }


    static class Task {
        String name;
        int cost;
        int deadline;

        public Task(String name, int cost, int deadline) {
            this.name = name;
            this.cost = cost;
            this.deadline = deadline;
        }

        @Override
        public String toString() {
            return "Task{" +
                    "name='" + name + '\'' +
                    ", cost=" + cost +
                    ", deadline=" + deadline +
                    '}';
        }
    }

}
