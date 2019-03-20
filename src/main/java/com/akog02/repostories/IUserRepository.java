package com.akog02.repostories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.akog02.domain.User;

@Repository
public interface IUserRepository extends CrudRepository<User, Long>{

}
