package com.akog02.repostories;

import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.akog02.domain.CommentInPost;


@Repository
public interface ICommentInPostRepository extends CrudRepository<CommentInPost, Long>{
	//"from table where tech=?1 order by "
	@Query("FROM  CommentInPost WHERE PostId=:pid")
	 List<CommentInPost> findByPostId(@Param("pid") int PostId);
}
