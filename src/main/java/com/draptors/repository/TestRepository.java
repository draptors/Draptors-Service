package com.draptors.repository;

import com.draptors.domain.TestEntity;
import org.springframework.data.repository.CrudRepository;

public interface TestRepository extends CrudRepository<TestEntity, Integer> {
}
