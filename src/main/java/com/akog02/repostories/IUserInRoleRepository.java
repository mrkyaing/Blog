package com.akog02.repostories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.akog02.domain.Role;
import com.akog02.domain.UserInRole;


@Repository
public interface IUserInRoleRepository extends CrudRepository<UserInRole,Long>{
	
}
