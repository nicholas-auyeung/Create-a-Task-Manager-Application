package com.phase3end.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.phase3end.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{

}
