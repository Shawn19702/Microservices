package com.student.api.student.api.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//Pojo
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Student {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Double gpa;

    private String schoolCode;

}
