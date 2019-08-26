package com.draptors.repository;

import com.draptors.domain.UserDetailsEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserDetailsRepository extends CrudRepository<UserDetailsEntity, String> {
}
