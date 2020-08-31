package project.service;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import project.model.Assignment;

@Service
@RequiredArgsConstructor
public class AssignmentDao {
    public final NamedParameterJdbcTemplate jdbcTemplate;

    public void createAssignment(Assignment assignment) {
        jdbcTemplate.update(
                "INSERT INTO public.Assignment(task_id, employee_id) values(:task_id,:emplyee_id)", assignment.asCreateParams()
        );
    }
}
