package project.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import project.dto.EmployeeDTO;
import project.mapper.EmployeeMapper;
import project.repository.EmployeeRepository;

import javax.persistence.EntityExistsException;
import java.math.BigInteger;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper = Mappers.getMapper(EmployeeMapper.class);


    public EmployeeDTO create(EmployeeDTO dto) {
        return employeeMapper.employeeToDto(
                employeeRepository.save(employeeMapper.dtoToEmployee(dto)));
    }

    public EmployeeDTO findById(BigInteger id) {
        return employeeMapper.employeeToDto(
                employeeRepository.findById(id).orElseThrow(EntityExistsException::new));
    }

    public List<EmployeeDTO> findAll() {
        return employeeMapper.employeeToDto(
                employeeRepository.findAll());
    }


}
