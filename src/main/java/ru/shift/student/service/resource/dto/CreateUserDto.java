package ru.shift.student.service.resource.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateUserDto {

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