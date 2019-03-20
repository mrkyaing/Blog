package com.akog02.services;

import com.akog02.domain.Role;;

public interface IRoleServices {
	  Iterable<Role> getAllRoles();
	  Role getRoleById(Long id);
	  Role saveRole(Role entity);
	  void deleteRoleById(Long id);
	  Role getRoleByRoleLevel(int roleLevel);
}
