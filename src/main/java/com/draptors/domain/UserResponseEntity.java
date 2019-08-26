package com.draptors.domain;

import lombok.Data;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
@Data
public class UserResponseEntity {

    @EmbeddedId
    private UserResponseId userResponseId;
}
