package com.draptors.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class QuestionsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int quesId;
    private String quesDesc;
    private int timeLapse;
    @Transient
    private List<OptionsEntity> optionsList;
    @Transient
    private int surveyId;
}
