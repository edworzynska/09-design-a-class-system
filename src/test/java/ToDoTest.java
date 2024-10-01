import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class ToDoTest {
    ToDo toDo;
    String task1;
    String task2;
    String task3;
    String task4;
    @BeforeEach
    void setUp(){
        toDo = new ToDo();
        task1 = "walk Gucci";
        task2 = "buy milk";
        task3 = "eat";
        task4 = "sleep";
    }
    @Test
    void addingTasksAndDisplayingListOfTodo() {
        toDo.addTask(task1);
        toDo.addTask(task2);
        toDo.markAsCompleted(task1);
        var incomplete = toDo.displayTasks();
        assertEquals("Tasks to do: buy milk", incomplete);
    }

    @Test
    void displayingCompleteTasks() {
        toDo.addTask(task1);
        toDo.addTask(task2);
        toDo.markAsCompleted(task1);
        var completed = toDo.displayCompleted();
        assertEquals("Completed tasks: walk Gucci", completed);
    }

    @Test
    void moreTasksOnTheList() {
        toDo.addTask(task1);
        toDo.addTask(task2);
        toDo.addTask(task3);
        toDo.addTask(task4);
        var incomplete2 = toDo.displayTasks();
        assertEquals("Tasks to do: buy milk, eat, sleep", incomplete2);
    }

    @Test
    void taskBeingMarkedAsCompletedNotOnList() {
        RuntimeException r = assertThrows(RuntimeException.class, ()->toDo.markAsCompleted("go shopping"));
        assertEquals("Unable to locate the task.", r.getMessage());

    }

    @Test
    void throwsAnErrorIfAddingEmptyTask() {
        RuntimeException e = assertThrows(RuntimeException.class, ()->toDo.addTask(""));
        assertEquals("Task cannot be empty!", e.getMessage());
    }

    @Test
    void returnsMessageIfAllTasksCompleted() {
        toDo.addTask(task1);
        toDo.addTask(task2);
        toDo.addTask(task3);
        toDo.addTask(task4);
        toDo.markAsCompleted(task1);
        toDo.markAsCompleted(task2);
        toDo.markAsCompleted(task3);
        toDo.markAsCompleted(task4);
        var emptyList = toDo.displayTasks();
        assertEquals("No tasks to do! Enjoy your free time.", emptyList);
    }
}