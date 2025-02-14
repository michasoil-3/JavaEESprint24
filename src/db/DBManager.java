package db;

import models.Task;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class DBManager {
    public static ArrayList<Task> tasks = new ArrayList<>();
    public static long id = 1;

    static {
        addTask("Feed dogs", "Feed my hungry and annoying dogs.");
        addTask("Write blog post on robots", "It will keep my YouTube channel alive.", "professional");
        addTask("Start reading a book", "George Orwell's 1984 is a good one.", "personal");
        addTask("Speak to principal", "Not like I would ever want to!", LocalDateTime.of(2024, 10, 11, 19, 50), "school");
        addTask("Find a website for therapy", "Don't go over your budget.", "personal");
        addTask("Do physics homework", "Copy from my friend if I get stuck", LocalDateTime.of(2024, 10, 31, 0, 0), "school");
        tasks.getFirst().setCompleted(true);
    }

    public static void addTask(String name, String description) {
        Task task = new Task(id);
        task.setName(name);
        task.setDescription(description);
        tasks.add(task);
        id++;
    }

    public static void addTask(String name, String description, LocalDateTime deadline) {
        Task task = new Task(id);
        task.setName(name);
        task.setDescription(description);
        task.setDeadline(deadline);
        tasks.add(task);
        id++;
    }

    public static void addTask(String name, String description, String category) {
        Task task = new Task(id);
        task.setName(name);
        task.setDescription(description);
        task.setCategory(category);
        tasks.add(task);
        id++;
    }

    public static void addTask(String name, String description, LocalDateTime deadline, String category) {
        Task task = new Task(id);
        task.setName(name);
        task.setDescription(description);
        task.setDeadline(deadline);
        task.setCategory(category);
        tasks.add(task);
        id++;
    }

    public static ArrayList<Task> getTasks() {
        return tasks;
    }

    public static ArrayList<Task> getTasksByCategory(String category) {
        ArrayList<Task> filtered = new ArrayList<>();
        for (Task task: tasks) {
            if (task.getCategory() != null) {
                if (task.getCategory().equals(category)) {
                    filtered.add(task);
                }
            }
        }
        return filtered;
    }

    public static void removeTask(long id) {
        Task toRemove = null;
        for (Task task : tasks) {
            if (task.getId() == id) {
                toRemove = task;
                break;
            }
        }
        if (toRemove != null)
            tasks.remove(toRemove);
    }

    public static void editTask(long id, String name, String description, LocalDateTime deadline, String category, boolean completed) {
        Task toEdit = null;
        for (Task task : tasks) {
            if (task.getId() == id) {
                toEdit = task;
                break;
            }
        }

        if (toEdit == null)
            return;

        toEdit.setName(name);
        toEdit.setDescription(description);
        toEdit.setDeadline(deadline);
        toEdit.setCategory(category);
        toEdit.setCompleted(completed);
    }
}
