package ru.shift.student.service.resource;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import ru.shift.student.service.core.model.Student;
import ru.shift.student.service.core.service.StudentService;
import ru.shift.student.service.resource.dto.CreateUserDto;
import ru.shift.student.service.resource.dto.PatchStudentDto;
import ru.shift.student.service.resource.dto.StudentDto;
import ru.shift.student.service.resource.dto.UpdateStudentDto;
import ru.shift.student.service.resource.mapper.StudentMapper;

import java.util.List;

@RestController
@RequestMapping("api/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;
    private final StudentMapper studentMapper;

    @PostMapping
    public StudentDto createUser(@Valid @RequestBody CreateUserDto createUserDto) {
        Student student = studentMapper.toStudent(createUserDto);
        student = studentService.add(student);
        return studentMapper.toStudentDto(student);
    }

    @GetMapping("/{id}")
    public StudentDto getUser(@PathVariable Long id) {
        Student student = studentService.getById(id);
        return studentMapper.toStudentDto(student);
    }

    @PutMapping("/{id}")
    public StudentDto updateUser(@PathVariable long id, @Valid @RequestBody UpdateStudentDto updateStudentDto) {
        Student student = studentMapper.toStudent(updateStudentDto);
        student = studentService.update(id, student);
        return studentMapper.toStudentDto(student);
    }

    @PatchMapping("/{id}")
    public StudentDto updateUserPartially(@PathVariable long id, @Valid @RequestBody PatchStudentDto updateUserDto) {
        Student student = studentMapper.toStudent(updateUserDto);
        student = studentService.updatePartially(id, student);
        return studentMapper.toStudentDto(student);
    }

    @GetMapping
    public List<StudentDto> get(@RequestParam Integer page, @RequestParam Integer size) {
        return studentMapper.toStudentDtoList(studentService.get(PageRequest.of(page, size)));
    }
}