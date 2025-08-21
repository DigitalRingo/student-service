package ru.shift.student.service.core.service;

import org.springframework.data.domain.Pageable;
import ru.shift.student.service.core.model.Student;

import java.util.List;

public interface StudentService {

    Student add(Student student);

    Student getById(Long id);

    List<Student> get(Pageable pageable);

    Student update(long id, Student student);


    Student updatePartially(long id, Student student);
}
