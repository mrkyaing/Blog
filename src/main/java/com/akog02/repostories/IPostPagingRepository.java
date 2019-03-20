package com.akog02.repostories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.akog02.domain.Post;

@Repository
public interface IPostPagingRepository extends PagingAndSortingRepository<Post, Integer>{
	Page<Post> findBycategoryId(int categoryId,Pageable pageable);
}
