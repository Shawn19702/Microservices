package com.student.api.student.api.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class StudentDto {
    private Long id;

    private String name;

private Double gpa;
    private String schoolCode;


}
