package com.draptors.domain;

import lombok.Data;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
@Data
public class OptionsEntity {
    @EmbeddedId
    private OptionsId optionsId;
    private String optionDesc;
}
