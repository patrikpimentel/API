package com.first.api.entity.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.first.api.entity.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    boolean existsByeMail(String email);
}
