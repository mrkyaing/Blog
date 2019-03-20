package com.akog02.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akog02.domain.Category;
import com.akog02.repostories.ICategoryRepository;

@Service
public class CategoryServices implements ICategoryServices{

	@Autowired
	private ICategoryRepository repo;
	
	@Override
	public Iterable<Category> getAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public boolean Save(Category entity) {
		// TODO Auto-generated method stub
		try {
			repo.save(entity);
			return true;
		}catch(Exception e)
		{return false;}
	}

	@Override
	public boolean DeleteById(Integer Id) {
		// TODO Auto-generated method stub
		try {
			repo.deleteById(Id);
			return true;
		}catch(Exception e)
		{return false;}
	}

	@Override
	public Category SelectById(Integer Id) {
		// TODO Auto-generated method stub
		return repo.findById(Id).orElse(null);
	}

}
