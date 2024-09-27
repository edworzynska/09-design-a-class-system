import java.util.ArrayList;
import java.util.List;


public class ToDo {

    public String task;

    public List<String> toDoList = new ArrayList<>();
    public List<String> completed = new ArrayList<>();

    public void addTask(String task){
        if (task.isEmpty()){
            throw new RuntimeException("Task cannot be empty!");
        }
        else {
            toDoList.add(task);
        }
    }
    public String displayTasks(){
        if (toDoList.isEmpty()){
            return "No tasks to do! Enjoy your free time.";
        }
        else {
            String tasks = String.join(", ", toDoList);
            return "Tasks to do: " + tasks;
        }
    }
    public void markAsCompleted(String task){
        if (completed.contains(task)){
            throw new RuntimeException("Task has already been completed!");
        }
        else if (!toDoList.contains(task)){
            throw new RuntimeException("Unable to locate the task.");
        }
        toDoList.remove(task);
        completed.add(task);
    }
    public String displayCompleted(){
        if (completed.isEmpty()){
            return "No tasks completed! Do something.";
        }
        else {
            String tasks = String.join(", ", completed);
            return "Completed tasks: " + tasks;
        }
    }
}

