package eu.karols.todolist.service;

import eu.karols.todolist.model.Task;
import eu.karols.todolist.repository.TaskRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class TaskServiceTest {

    @MockBean
    private TaskRepository taskRepository;

    @Autowired
    private TaskService taskService;

    @Test
    void getTaskById() {
        Task task = new Task();
        task.setId(1L);
        task.setName("Name");
        task.setDescription("Description of task.");

        when(taskRepository.findById(1L)).thenReturn(java.util.Optional.ofNullable(task));

        Task findTask = taskService.getTaskById(1L);

        assertEquals(task, findTask);
    }

    @Test
    void getAllTasks() {
        Task task1 = new Task();
        task1.setId(1L);
        task1.setName("Name");
        task1.setDescription("Description of task.");
        Task task2 = new Task();
        task2.setId(2L);
        task2.setName("Task");
        task2.setDescription("Description of task.");
        List<Task> tasks = new ArrayList<>();
        tasks.add(task1);
        tasks.add(task2);

        when(taskRepository.findAll()).thenReturn(tasks);

        Iterable<Task> findTasks = taskService.getAllTasks();

        assertEquals(tasks, findTasks);
    }

    @Test
    void saveTask() {
        Task taskForSave = new Task();
        taskForSave.setName("Name");
        taskForSave.setDescription("Description of task.");

        Task task = new Task();
        task.setId(1L);
        task.setName("Name");
        task.setDescription("Description of task.");

        when(taskRepository.save(taskForSave)).thenReturn(task);

        Task newTask = taskService.saveTask(taskForSave);

        assertEquals(task, newTask);

    }

    @Test
    void replaceTask() {
        Task task1 = new Task();
        task1.setId(1L);
        task1.setName("Test");
        task1.setDescription("Test");

        Task requestTask = new Task();
        requestTask.setName("Name");
        requestTask.setDescription("Description of task.");

        Task replacedTask = new Task();
        replacedTask.setId(1L);
        replacedTask.setName("Name");
        replacedTask.setDescription("Description of task.");

        when(taskRepository.findById(any())).thenReturn(java.util.Optional.of(task1));
        when(taskRepository.save(any())).thenReturn(replacedTask);

        Task task = taskService.replaceTask(requestTask, 1L);

        assertEquals(task, replacedTask);
    }
}