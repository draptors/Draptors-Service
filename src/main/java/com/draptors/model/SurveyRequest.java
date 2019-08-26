package com.draptors.model;

import lombok.Data;

@Data
public class SurveyRequest {

    private String userId;
    private int quesId;
    private int optionId;
    private int surveyId;
}
