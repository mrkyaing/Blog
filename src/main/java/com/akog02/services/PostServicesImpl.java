package com.akog02.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.akog02.domain.Post;
import com.akog02.repostories.IPostRepository;

@Service
public class PostServicesImpl implements IPostServices {
	
	@Autowired
	private IPostRepository postrepo;

	@Override
	public List<Map<String, Object>> report() {
		List<Map<String,Object>> result=new ArrayList<Map<String,Object>>();
		for(Post p: postrepo.findAll()) {
			Map<String,Object> item=new HashMap<String,Object>();
			item.put("Id",p.getId());
			result.add(item);
		}
		return result;
	}
	@Override
	public Iterable<Post> getAllPosts() {
		// TODO Auto-generated method stub
		return postrepo.findAll();
	}
	@Override
	public Post getPostById(Integer id) {
		// TODO Auto-generated method stub
		return postrepo.findById(id).orElse(null);
	}
	@Override
	public Post savePost(Post post) {
		// TODO Auto-generated method stub
		return postrepo.save(post);
	}
	@Override
	public void deletePostById(Integer id) {
		// TODO Auto-generated method stub
		postrepo.deleteById(id);
	}
	Logger log = LoggerFactory.getLogger(this.getClass().getName());
	
	@Override
	public void store(MultipartFile file) {
		 String imgName = file.getOriginalFilename();
		 File upl = new File("blogimages/" + imgName);
		    try {
				upl.createNewFile();
				 FileOutputStream fout = new FileOutputStream(upl);
				    fout.write(file.getBytes());
				    fout.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		   
	}
	@Override
	public List<Post> getPostBycategoryId(int categoryId) {
		// TODO Auto-generated method stub
		return postrepo.findBycategoryId(categoryId);
	}
}
