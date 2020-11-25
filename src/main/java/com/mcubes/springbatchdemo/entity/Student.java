package com.mcubes.springbatchdemo.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Student {


    @Id
    private int id;
    private String name;
    private String address;
    private String department;
    private float cgpa;
    private String modified;

}
