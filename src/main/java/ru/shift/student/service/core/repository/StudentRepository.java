package ru.shift.student.service.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.shift.student.service.core.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
