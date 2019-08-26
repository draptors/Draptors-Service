package com.draptors.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class SurveyResponseResult {
    @SerializedName("option_id")
    @Expose
    private int optionId;
    @SerializedName("count")
    @Expose
    private Long count;

    public SurveyResponseResult() {

    }

    public SurveyResponseResult(int optionId, Long count) {
        this.optionId = optionId;
        this.count = count;
    }
}
