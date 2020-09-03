package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.domain.Employee;

import java.math.BigInteger;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, BigInteger> {
}
