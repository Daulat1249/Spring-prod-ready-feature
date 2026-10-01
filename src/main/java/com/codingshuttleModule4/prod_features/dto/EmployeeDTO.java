package com.codingshuttleModule4.prod_features.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmployeeDTO {
    Long id;

    String name;

    String email;

    Integer age;

    String role; //role can only be ADMIN OR USER

    Double salary;

    LocalDate dateOfJoining;

    Boolean active;
}
