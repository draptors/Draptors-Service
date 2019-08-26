package com.draptors.controller;

import com.draptors.config.ApplicationConstants;
import com.draptors.domain.*;
import com.draptors.model.SurveyResponse;
import com.draptors.model.SurveyResponseResult;
import com.draptors.repository.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;
import java.util.List;

@Controller
@RequestMapping("/survey")
@Slf4j
public class ServeyController {

    @Autowired
    QuestionsRepository questionsRepository;

    @Autowired
    SurveyRepository surveyRepository;

    @Autowired
    UserDetailsRepository userDetailsRepository;

    @Autowired
    OptionsRepository optionsRepository;

    @Autowired
    UserResponseRepository userResponseRepository;

    @CrossOrigin
    @RequestMapping("/registration")
    @ResponseBody
    public SurveyResponse registration(UserDetailsEntity userDetailsEntity) {
        SurveyResponse res = new SurveyResponse();
        try {
            userDetailsEntity.setCreatedDate(new Timestamp(System.currentTimeMillis()));
            userDetailsRepository.save(userDetailsEntity);
            res.setStatus(ApplicationConstants.SUCCESS);
        } catch ( Exception ex ) {
            log.error("Error in registration");
            res.setStatus(ApplicationConstants.FAILURE);
        }
        return res;
    }

    @CrossOrigin
    @RequestMapping("/listQuestions")
    @ResponseBody
    public List<QuestionsEntity> listQuestions() {
        List<QuestionsEntity> list = null;
        try {
            list = (List<QuestionsEntity>) questionsRepository.findAll();
        } catch ( Exception ex ) {
            log.error("Error in listQuestions");
        }
        return list;
    }

    @CrossOrigin
    @RequestMapping("/createSurvey")
    @ResponseBody
    public SurveyResponse createSurvey(SurveyEntity surveyEntity) {
        SurveyResponse res = new SurveyResponse();
        try {
            if(surveyEntity.getSurveyId()!=0) {
                surveyEntity.setTimeStart(new Timestamp(System.currentTimeMillis()));
                surveyEntity.setStatus(1);
            } else {
                surveyEntity.setStatus(0);
            }

            surveyRepository.save(surveyEntity);
            res.setStatus(ApplicationConstants.SUCCESS);
            res.setSurveyId(String.valueOf(surveyEntity.getSurveyId()));
        } catch ( Exception ex ) {
            res.setStatus(ApplicationConstants.FAILURE);
            log.error("Error in createSurvey");
        }
        return res;
    }

    @CrossOrigin
    @RequestMapping("/getActiveSurvey")
    @ResponseBody
    public QuestionsEntity getActiveSurvey(UserDetailsEntity userDetailsEntity) {
        QuestionsEntity questionsEntity = null;
        try {
            List<SurveyEntity> list = surveyRepository.findAllByStatus(1);
            if(!CollectionUtils.isEmpty(list)){
                SurveyEntity surveyEntity = list.get(0);
                List<OptionsEntity> optionsList = optionsRepository.findAllByOptionsIdQuesId(surveyEntity.getQuesId());
                questionsEntity.setQuesId(surveyEntity.getQuesId());
                questionsEntity.setSurveyId(surveyEntity.getSurveyId());
                questionsEntity.setOptionsList(optionsList);
            }
        } catch ( Exception ex ) {
            log.error("Error in getActiveSurvey");
        }
        return questionsEntity;
    }

    @CrossOrigin
    @RequestMapping("/submitSurvey")
    @ResponseBody
    public SurveyResponse submitSurvey(UserResponseEntity userResponseEntity) {
        SurveyResponse res = new SurveyResponse();
        try {
            if(!CollectionUtils.isEmpty(surveyRepository.findAllByStatusAndSurveyId(
                    1, userResponseEntity.getUserResponseId().getSurveyId()))) {
                userResponseRepository.save(userResponseEntity);
                res.setStatus(ApplicationConstants.SUCCESS);
            } else {
                res.setStatus(ApplicationConstants.FAILURE);
            }
        } catch ( Exception ex ) {
            log.error("Error in submitSurvey");
            res.setStatus(ApplicationConstants.FAILURE);
        }
        return res;
    }

    @CrossOrigin
    @RequestMapping("/getSurveyResult")
    @ResponseBody
    public List<SurveyResponseResult> getSurveyResult(@RequestParam("surveyId") int surveyId) {
        List<SurveyResponseResult> list = null;
        try {
            list = userResponseRepository.getSurveyResponseResult(surveyId);
        } catch ( Exception ex ) {
            log.error("Error in listQuestions");
        }
        return list;
    }
}
