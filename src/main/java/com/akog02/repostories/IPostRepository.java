package com.akog02.repostories;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.akog02.domain.Post;


@Repository
public interface IPostRepository extends CrudRepository<Post, Integer>{
	//@Query("FROM  CommentInPost WHERE PostId=:pid")
@Query("FROM  Post  WHERE categoryId= :cId")
 List<Post> findBycategoryId(@Param("cId")int categoryId);

}
