package com.draptors.repository;

import com.draptors.domain.SurveyEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SurveyRepository extends CrudRepository<SurveyEntity, Integer> {
    List<SurveyEntity> findAllByStatus(int status);
    List<SurveyEntity> findAllByStatusAndSurveyId(int status, int surveyId);
}
