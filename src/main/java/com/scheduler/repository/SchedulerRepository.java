package com.scheduler.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.scheduler.document.User;

@Repository
public interface SchedulerRepository extends MongoRepository<User,String> {

}
