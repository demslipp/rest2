package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.domain.Assignment;

import java.math.BigInteger;

@Repository
public interface AssignmentRepository extends JpaRepository<Assignment, BigInteger> {
}
