package ru.shift.student.service.resource.dto;

import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Value;
import lombok.experimental.FieldDefaults;

@Value
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PatchStudentDto {

    @Size(min = 2, max = 50)
    String firstName;

    @Size(min = 2, max = 50)
    String lastName;

    @Size(max = 2000)
    String description;

    Boolean hasPortfolio;
}
