package com.phase3end.repository;

import org.springframework.data.repository.CrudRepository;

import com.phase3end.entity.UserTask;

public interface UserTaskRepository extends CrudRepository<UserTask, Long>{

}
