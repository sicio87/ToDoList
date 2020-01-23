package eu.karols.todolist.controller;

import eu.karols.todolist.model.Task;
import eu.karols.todolist.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping("/{id}")
    public Task getTask(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }

    @GetMapping("/")
    public Iterable<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @PostMapping("/add")
    public Task saveTask(@RequestBody Task task) {
        return taskService.saveTask(task);
    }

    @PutMapping("/update/{id}")
    public Task replaceTask(@RequestBody Task newTask, @PathVariable Long id) {
        return taskService.replaceTask(newTask, id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }
}
