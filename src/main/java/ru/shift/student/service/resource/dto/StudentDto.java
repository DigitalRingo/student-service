package ru.shift.student.service.resource.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentDto {

    long id;
    String firstName;
    String lastName;
    String description;
    Boolean hasPortfolio;
}