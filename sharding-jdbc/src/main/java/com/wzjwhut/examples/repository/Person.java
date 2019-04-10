package com.wzjwhut.examples.repository;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Data
@Table
@Entity
public class Person {
    @Id
    private String name;
}