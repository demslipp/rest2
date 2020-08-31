package project.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import project.dto.SearchEmployee;
import project.model.Employee;
import project.service.EmployeeDao;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeDao employeeService;

    @DeleteMapping("/delete}")
    public void retireEmployee(@PathParam("id") Long id) {
        //TODO delete by id
    }

    @PostMapping("/search")
    public List<Employee> findEmployee(@RequestBody SearchEmployee searchEmployee) {
        return employeeService.findEmployee(searchEmployee);
    }

    @GetMapping("/all")
    public List<Employee> findAllEmployees() {
        return employeeService.getAllEmployee();
    }
    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable("id") Integer id) {
        return employeeService.getById(id);
    }
}

