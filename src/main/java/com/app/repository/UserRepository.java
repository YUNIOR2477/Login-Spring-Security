package com.app.repository;

import com.app.entity.User.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<UserEntity,Long> {

    @Query(value = "SELECT u FROM UserEntity u WHERE u.userName LIKE %?1%")
    Optional<UserEntity> findByUsername(String username);
}
