package project.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.dto.EmployeeDTO;
import project.service.EmployeeService;

import javax.websocket.server.PathParam;
import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @DeleteMapping("/delete}")
    public void retireEmployee(@PathParam("id") Long id) {
        //TODO delete by id
    }


    @GetMapping("/all")
    public List<EmployeeDTO> findAllEmployees() {
        return employeeService.findAll();
    }

    @GetMapping("/{id}")
    public EmployeeDTO getEmployee(@PathVariable("id") BigInteger id) {
        return employeeService.findById(id);
    }
}

