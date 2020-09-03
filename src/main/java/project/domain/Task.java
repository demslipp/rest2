package project.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(of = "id")
@Builder
@Entity(name = "tasks")
@NoArgsConstructor
@AllArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tasks_ids_gen")
    @SequenceGenerator(name = "tasks_ids_gen", sequenceName = "tasks_id_seq", allocationSize = 1)
    private BigInteger id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(length = 1000)
    private String description;

    @Column(nullable = false)
    private int difficultyLevel;

    @Enumerated(EnumType.STRING)
    private Priority priority = Priority.NORMAL;

    @Column
    private LocalDateTime estimatedTime;

    @Column(nullable = false)
    private LocalDateTime created;

    @Enumerated(EnumType.STRING)
    private TaskStatus status = TaskStatus.OPEN;

    @Column(nullable = false)
    private LocalDateTime updated;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;


}
