package com.draptors.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
@Data
public class UserDetailsEntity {

    @Id
    private String userId;
    private String role;
    private Timestamp createdDate;
}
