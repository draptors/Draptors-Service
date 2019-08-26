package com.draptors.repository;

import com.draptors.domain.UserResponseEntity;
import com.draptors.domain.UserResponseId;
import com.draptors.model.SurveyResponseResult;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserResponseRepository extends CrudRepository<UserResponseEntity, UserResponseId> {

    @Query("SELECT new com.draptors.model.SurveyResponseResult(u.userResponseId.optionId, count(u)) "+
            "FROM UserResponseEntity u where u.userResponseId.surveyId = :surveyId group by u.userResponseId.optionId")
    List<SurveyResponseResult> getSurveyResponseResult(int surveyId);
}
