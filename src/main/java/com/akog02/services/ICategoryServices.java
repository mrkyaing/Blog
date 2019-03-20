package com.akog02.services;
import com.akog02.domain.Category;

public interface ICategoryServices {
	Iterable<Category> getAll();
	boolean Save(Category entity);
	boolean DeleteById(Integer Id);
	Category SelectById(Integer Id);
}
