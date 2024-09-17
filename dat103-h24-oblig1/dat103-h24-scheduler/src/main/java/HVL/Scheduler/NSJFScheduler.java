package HVL.Scheduler;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Optional;
import java.util.Queue;
import java.util.Comparator;
import java.util.stream.Collectors;


public class NSJFScheduler implements Scheduler {

    private Queue<Task> ready;
    private Task selected;

    NSJFScheduler() {
        this.ready = new ArrayDeque<>();
    }

    @Override
    public Optional<Integer> scheduled() {
        if(selected == null) return Optional.empty();
        return Optional.of(selected.getId());
    }

    @Override
    public List<Integer> ready() {
        return ready.stream().map(Task::getId).toList();
    }

    // Task 2: Complete the implementation of Non-preemptive Shortest Job First    
    @Override
    public void addTask(Task task) {
        ready.add(task);
        ready = ready.stream()
                .sorted(Comparator.comparingInt(Task::getSize))
                .collect(Collectors.toCollection(ArrayDeque::new));
    }

    @Override
    public void schedule() {
        if (selected == null) {
            selected = ready.poll();
            if (selected == null) {
                return;
            }
            selected.start();
        } else {
            // Task 2: Complete the implementation of Non-preemptive Shortest Job First
            if (selected.isDone()) {
                selected = null;
                schedule();
            }
        }
    }
}
