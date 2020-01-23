package eu.karols.todolist.service;

import eu.karols.todolist.exception.TaskNotFoundException;
import eu.karols.todolist.model.Task;
import eu.karols.todolist.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElseThrow(TaskNotFoundException::new);
    }

    public Iterable<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    public Task replaceTask(Task newTask, @PathVariable Long id) {
        return taskRepository.findById(id)
                .map(task -> {
                    task.setName(newTask.getName());
                    task.setDescription(newTask.getDescription());
                    return taskRepository.save(task);
                })
                .orElseGet(() -> {
                    newTask.setId(id);
                    return taskRepository.save(newTask);
                });
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

}
