package eu.karols.todolist.repository;

import eu.karols.todolist.model.Task;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, Long> {
}
