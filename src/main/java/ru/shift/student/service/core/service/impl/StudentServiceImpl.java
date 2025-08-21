package ru.shift.student.service.core.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.shift.student.service.core.model.Student;
import ru.shift.student.service.core.repository.StudentRepository;
import ru.shift.student.service.core.service.StudentService;
import ru.shift.student.service.core.service.exception.ObjectNotFoundException;

import java.util.List;

@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repository;

    @Override
    public Student add(Student student) {
        return repository.save(student);
    }

    @Override
    public Student getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Student with id " + id + " not found"));
    }

    @Override
    public Student update(long id, Student updatedStudent) {
        Student student = new Student();
        student.setId(id);
        student.setFirstName(updatedStudent.getFirstName());
        student.setLastName(updatedStudent.getLastName());
        student.setDescription(updatedStudent.getDescription());
        student.setHasPortfolio(updatedStudent.getHasPortfolio());
        return repository.save(student);
    }

    @Transactional
    @Override
    public Student updatePartially(long id, Student updatedStudent) {
        Student existingStudent = getById(id);
        if (updatedStudent.getFirstName() != null) {
            existingStudent.setFirstName(updatedStudent.getFirstName());
        }
        if (updatedStudent.getLastName() != null) {
            existingStudent.setLastName(updatedStudent.getLastName());
        }
        if (updatedStudent.getDescription() != null) {
            existingStudent.setDescription(updatedStudent.getDescription());
        }
        if (updatedStudent.getHasPortfolio() != null) {
            existingStudent.setHasPortfolio(updatedStudent.getHasPortfolio());
        }

        return repository.save(existingStudent);
    }

    @Override
    public List<Student> get(Pageable pageable) {
        return repository.findAll(pageable).stream().toList();
    }
}
