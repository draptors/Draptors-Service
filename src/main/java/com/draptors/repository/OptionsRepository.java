package com.draptors.repository;

import com.draptors.domain.OptionsEntity;
import com.draptors.domain.OptionsId;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OptionsRepository extends CrudRepository<OptionsEntity, OptionsId> {
    List<OptionsEntity> findAllByOptionsIdQuesId(int quesId);
}
