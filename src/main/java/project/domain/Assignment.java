package project.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import java.math.BigInteger;

@Data
@EqualsAndHashCode(of = "id")
@Builder
@Entity(name = "assignments")
@NoArgsConstructor
@AllArgsConstructor
public class Assignment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "assignment_ids_gen")
    @SequenceGenerator(name = "assignment_ids_gen", sequenceName = "assignment_id_seq", allocationSize = 1)
    private BigInteger id;

    @Column(nullable = false)
    private BigInteger employeeId;

    @Column(nullable = false)
    private BigInteger taskId;

}
