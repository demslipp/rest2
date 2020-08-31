package project.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import project.dto.SearchRequest;
import project.model.Task;
import project.service.TaskDao;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/task")
@RequiredArgsConstructor
public class TaskController {

    private final TaskDao taskService;

    @PostMapping("/")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createTask(@RequestBody Task task) {
        taskService.createTask(task);
    }

    @DeleteMapping("/delete")
    public void deleteTask(@PathParam("id") Long id) {
        //TODO delete by id
    }

    @GetMapping("/{id}")
    public Task getTask(@PathVariable("id") Integer id) {
        return taskService.getById(id);
    }

    @GetMapping("/all")
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @PostMapping("/search")
    public List<Task> findTasks(@RequestBody SearchRequest request) {
        return taskService.findTasks(request);
    }
}
