package project.mapper;

import org.mapstruct.Mapper;
import project.domain.Employee;
import project.dto.EmployeeDTO;

import java.util.List;

@Mapper
public interface EmployeeMapper {


    EmployeeDTO employeeToDto(Employee employee);

    Employee dtoToEmployee(EmployeeDTO employeeDTO);

    List<EmployeeDTO> employeeToDto(List<Employee> employees);

    List<Employee> dtoToEmployee(List<EmployeeDTO> employeeDTO);

}
