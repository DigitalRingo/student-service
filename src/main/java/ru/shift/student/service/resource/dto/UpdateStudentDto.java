package ru.shift.student.service.resource.dto;

import jakarta.validation.constraints.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Value;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

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
