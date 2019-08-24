package com.draptors.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class TestEntity {
    @Id
    private int id;
    private String name;
}
