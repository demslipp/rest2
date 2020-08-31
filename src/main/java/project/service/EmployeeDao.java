package project.service;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import project.dto.SearchEmployee;
import project.model.Employee;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class EmployeeDao {
    public final NamedParameterJdbcTemplate jdbcTemplate;

    public void createEmployee(Employee employee) {
        jdbcTemplate.update(
                "INSERT INTO public.employee (lastname, firstname, grade) VALUES (:lastname, :firstname, :grade::public.grade)",
                employee.asCreateParams());
    }

    public Employee getById(Integer id) {
        return jdbcTemplate.queryForObject(
                "SELECT id, lastname, firstname, grade FROM public.Employee WHERE id=:id", Map.of("id", id),
                Employee.ROW_MAPPER);
    }

    public Employee getByLastname(String lastname) {
        return jdbcTemplate.queryForObject(
                "SELECT id, lastname, firstname, grade FROM public.Employee WHERE lastname=:lastname",
                Map.of("lastname", lastname), Employee.ROW_MAPPER);
    }

    public List<Employee> findEmployee(SearchEmployee searchEmployee) {
        return jdbcTemplate.queryForList(searchEmployee.toSql(), Collections.emptyMap(), Employee.class);
    }

    public List<Employee> getAllEmployee() {
        return jdbcTemplate.query(
                "SELECT id, lastname, firstname, grade FROM public.employee",
                Collections.emptyMap(), Employee.ROW_MAPPER
        );
    }
}
