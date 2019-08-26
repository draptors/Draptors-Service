package com.draptors.domain;

import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
public class OptionsId implements Serializable {

    private int quesId;
    private int optionId;
}
