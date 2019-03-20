package com.akog02.controller;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.akog02.domain.Post;
import com.akog02.repostories.ICommentInPostRepository;
import com.akog02.domain.Category;
import com.akog02.domain.CommentInPost;
import com.akog02.services.CategoryServices;
import com.akog02.services.IPostServices;
@Controller
@RequestMapping("/post")
public class PostController {

	@Autowired
    private IPostServices postService;

	@Autowired
    private CategoryServices categoryServices;

	
	
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("posts", postService.getAllPosts());
        return "/pages/post/list";
    }
    //view(showing) the data getting by id.
    @RequestMapping("/{id}")
    public String postdetail(@PathVariable Integer id, Model model){
        model.addAttribute("post", postService.getPostById(id));
        return "/pages/post/postdetail";
    }
    //editing the data by post id
    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute("post", postService.getPostById(id));
        model.addAttribute("categorydata",getCategoryData());
        return "/pages/post/entry";
    }
    //loading the post form 
    @RequestMapping("/entry")
    public String newpost(Model model){
        model.addAttribute("post", new Post());
        model.addAttribute("categorydata",getCategoryData());
        return "/pages/post/entry";
    }
    //saving data to the database.
    @PostMapping(value = "/entry")//action name >>post
    public String savepost(@ModelAttribute ("post")@Valid Post input,@RequestParam("uploadfile") MultipartFile file){
    	try {
    		postService.store(file);
    		Category category=categoryServices.SelectById(input.getCategoryId());
    		input.setActive(true);
    		 DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    		 Calendar cal = Calendar.getInstance();
    		input.setCreatedDate(cal.getTime());
            // Here, you can save the product details in database
            input.setCategory(category);
            input.setImageUrl(file.getOriginalFilename());
            postService.savePost(input);
           
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
    	 return "redirect:list";//redirect to action name(posts)
    }
	//deleting data from the database.
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        postService.deletePostById(id);
        return "redirect:list";//redirect to action name(posts)
    }
    
    @RequestMapping("/mostPopularposts")
    public String handleForexRequest(Model model) {
        model.addAttribute("mostPopularposts", getMostPopularposts());
        return "forexView";
    }
    
    private List<Post> getMostPopularposts() {
        //dummy rates
        List<Post> postList = new ArrayList<>();
        Iterable<Post> data=postService.getAllPosts();
        
       for (Post p:data) {
            Post post = new Post();
             post.setTitle(post.getTitle());
            postList.add(post);
        }
        return postList;
    }
   private Iterable<Category> getCategoryData(){
       return categoryServices.getAll();
   }
 
}
