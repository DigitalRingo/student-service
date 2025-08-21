package ru.shift.student.service.core.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "student")
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@EntityListeners(AuditingEntityListener.class)
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_seq")
    @SequenceGenerator(name = "id_seq", sequenceName = "id_seq")
    long id;

    @NotBlank
    @Size(min = 2, max = 50)
    @Column(name = "first_name")
    String firstName;

    @NotBlank
    @Size(min = 2, max = 50)
    @Column(name = "last_name")
    String lastName;

    @NotBlank
    @Size(max = 2000)
    @Column
    String description;

    @NotNull
    @Column(name = "has_portfolio")
    Boolean hasPortfolio;
}
