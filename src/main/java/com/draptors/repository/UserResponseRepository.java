package com.draptors.repository;

import com.draptors.domain.UserResponseEntity;
import com.draptors.domain.UserResponseId;
import org.springframework.data.repository.CrudRepository;

public interface UserResponseRepository extends CrudRepository<UserResponseEntity, UserResponseId> {
}
