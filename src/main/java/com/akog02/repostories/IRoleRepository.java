package com.akog02.repostories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.akog02.domain.Role;

@Repository
public interface IRoleRepository extends CrudRepository<Role, Long>{
	@Query("SELECT r FROM  Role r WHERE r.RoleLevel= :Level")
	Role findByRoleLevel(@Param("Level")int level);
}
