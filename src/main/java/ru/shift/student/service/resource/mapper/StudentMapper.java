package ru.shift.student.service.resource.mapper;

import ru.shift.student.service.core.model.Student;
import ru.shift.student.service.resource.dto.CreateUserDto;
import ru.shift.student.service.resource.dto.PatchStudentDto;
import ru.shift.student.service.resource.dto.UpdateStudentDto;
import ru.shift.student.service.resource.dto.StudentDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    Student toStudent(CreateUserDto createUserDto);

    Student toStudent(UpdateStudentDto updateStudentDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Student toStudent(PatchStudentDto patchStudentDto);

    StudentDto toStudentDto(Student student);

    List<StudentDto> toStudentDtoList(List<Student> students);
}
