package com.student.api.student.api.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@NoArgsConstructor
public class SchoolDto {
    private Long id;
    private String schoolName;
    private String location;
    private String schoolCode;


}
