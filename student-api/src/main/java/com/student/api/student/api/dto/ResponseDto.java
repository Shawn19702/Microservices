package com.student.api.student.api.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ResponseDto {
    private StudentDto student;
    private  SchoolDto school;
}
