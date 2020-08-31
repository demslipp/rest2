package project.service;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import project.dto.SearchRequest;
import project.model.Task;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class TaskDao {

    public final NamedParameterJdbcTemplate jdbcTemplate;

    public void createTask(Task task) {
        jdbcTemplate.update(
                "INSERT INTO public.task (task_name, difficult, time, cost) VALUES (:task_name, :difficult, :time, :cost)",
                task.asCreateParams()
        );
    }

    public Task getById(Integer id) {
        return jdbcTemplate.queryForObject(
                "SELECT id, task_name, difficult, time, cost FROM public.task WHERE id = :id",
                Map.of("id", id), Task.ROW_MAPPER
        );
    }

    public List<Task> getAllTasks() {
        return jdbcTemplate.query(
                "SELECT id, task_name, difficult, time, cost FROM public.task",
                Collections.emptyMap(), Task.ROW_MAPPER
        );
    }

    public List<Task> findTasks(SearchRequest request) {
        return jdbcTemplate.queryForList(request.toSql(),
                Collections.emptyMap(), Task.class);
    }

    public void deleteTask() {

    }
}
