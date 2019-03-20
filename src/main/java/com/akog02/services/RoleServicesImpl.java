package com.akog02.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akog02.domain.Role;

import com.akog02.repostories.IRoleRepository;
@Service
public class RoleServicesImpl implements IRoleServices {

	@Autowired
	private IRoleRepository rolerepo;
	@Override
	public Iterable<Role> getAllRoles() {
		// TODO Auto-generated method stub
		return rolerepo.findAll();
	}

	@Override
	public Role getRoleById(Long id) {
		// TODO Auto-generated method stub
		return rolerepo.findById(id).orElse(null);
	}

	@Override
	public Role saveRole(Role entity) {
		// TODO Auto-generated method stub
		return rolerepo.save(entity);
	}

	@Override
	public void deleteRoleById(Long id) {
		// TODO Auto-generated method stub
       rolerepo.deleteById(id);
	}

	@Override
	public Role getRoleByRoleLevel(int roleLevel) {
		// TODO Auto-generated method stub
		return rolerepo.findByRoleLevel(roleLevel);
	}

}
