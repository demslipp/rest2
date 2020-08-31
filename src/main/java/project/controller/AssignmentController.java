package project.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import project.logic.AssingmentOperation;
import project.model.Assignment;
import project.service.AssignmentDao;

@RestController
@RequestMapping("/assignment")
@RequiredArgsConstructor
public class AssignmentController {


    private final AssignmentDao assignmentService;
    private final AssingmentOperation assingmentOperation;

    @PostMapping("/")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createAssignment(@RequestBody Assignment assignment) {
        assingmentOperation.process(assignment);
    }
}
