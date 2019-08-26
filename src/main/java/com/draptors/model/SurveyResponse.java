package com.draptors.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class SurveyResponse {
    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("survey_id")
    @Expose
    private String surveyId;
}
