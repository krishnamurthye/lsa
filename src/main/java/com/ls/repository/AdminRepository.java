package com.ls.repository;

import com.ls.domain.Admin;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface AdminRepository extends MongoRepository<Admin, String> {

    @Query("{username:'?0'}")
    Admin findUserByUsername(String username);
}
