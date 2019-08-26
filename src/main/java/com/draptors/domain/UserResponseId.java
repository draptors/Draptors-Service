package com.draptors.domain;

import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
public class UserResponseId implements Serializable {
    private String userId;
    private int quesId;
    private int optionId;
    private int surveyId;
}
