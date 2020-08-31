package project.logic;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import project.model.Assignment;
import project.service.AssignmentDao;
import project.service.EmployeeDao;
import project.service.TaskDao;

import static java.util.Objects.isNull;

@Component
@RequiredArgsConstructor
public class AssingmentOperation {

    private final EmployeeDao employeeDao;
    private final TaskDao taskDao;
    private final AssignmentDao assignmentDao;

    public void process( Assignment assignment) {
        if (isNull(assignment.taskId()) && (isNull(assignment.employeeId())))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "task id & employee id must be not NULL");
        var employee = employeeDao.getById(assignment.employeeId());
        if (isNull(assignment.employeeId()))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "this employee doesn't exist");
        var task = taskDao.getById(assignment.taskId());
        if (isNull(assignment.taskId())) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "this task doesn't exist");
        switch (employee.grade()) {
            case JUNIOR:
                if (task.difficult() > 1)
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "incorrect difficult");
                break;
            case MIDDLE: if (task.difficult()>2) throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"incorrect difficult");
                break;
        }
        assignmentDao.createAssignment(assignment);
    }

}
