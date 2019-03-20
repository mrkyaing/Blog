package com.akog02.repostories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.akog02.domain.Category;

@Repository
public interface ICategoryRepository extends CrudRepository<Category,Integer>{
/*@Query('SELECT u FROM UM u')
    List<UM> */
}
