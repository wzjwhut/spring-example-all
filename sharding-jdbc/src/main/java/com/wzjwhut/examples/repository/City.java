package com.wzjwhut.examples.repository;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Data
@Table
@Entity
public class City {
    @Id
    private String name;
    private String state;
    private String country;
}