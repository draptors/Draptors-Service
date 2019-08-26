package com.draptors.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Data
public class SurveyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int surveyId;
    private int quesId;
    private Timestamp timeStart;
    private int status;
}
