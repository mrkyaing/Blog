package com.akog02.services;

import java.util.List;
import java.util.Map;
import org.springframework.web.multipart.MultipartFile;

import com.akog02.domain.Post;

public interface IPostServices {
    Iterable<Post> getAllPosts();
    Post getPostById(Integer id);
    Post savePost(Post post);
    void deletePostById(Integer id);
    List<Map<String,Object>> report();
	public void store(MultipartFile file);
	List<Post> getPostBycategoryId(int categoryId);
}
