package com.phase3end.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.phase3end.entity.Task;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long>{

}
