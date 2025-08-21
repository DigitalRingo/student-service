package ru.shift.student.service.resource.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Value;
import lombok.experimental.FieldDefaults;

@Value
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UpdateStudentDto {

    @NotBlank
    @Size(min = 2, max = 50)
    String firstName;

    @NotBlank
    @Size(min = 2, max = 50)
    String lastName;

    @NotBlank
    @Size(max = 2000)
    String description;

    @NotNull
    Boolean hasPortfolio;
}
