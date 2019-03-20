package com.akog02.controller;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.akog02.common.PagerModel;
import com.akog02.domain.CommentInPost;
import com.akog02.domain.Post;
import com.akog02.repostories.ICommentInPostRepository;
import com.akog02.repostories.IPostPagingRepository;
import com.akog02.services.ICategoryServices;
import com.akog02.services.IPostServices;

@Controller
public class HomeController {
	
	private static final int BUTTONS_TO_SHOW = 3;
    private static final int INITIAL_PAGE = 0;
    private static final int INITIAL_PAGE_SIZE =3;
    private static final int[] PAGE_SIZES = { 3,5};
    
    @Autowired
    IPostPagingRepository postpagingRepo;
	
	private  Post postDetail;
	@Autowired
	ICommentInPostRepository commentInPostRepo;
	@Autowired
	private IPostServices postservices;
	@Autowired
	private ICategoryServices categoryservices;
	
	//Home page start action
	@RequestMapping("/")
	public String Index() {
		return "index";
	}
	//Login page action
	@GetMapping("/login")
    public String login() {
        return "login";
    }
	//get all blogs no filter
	@RequestMapping(value="/blog",method = RequestMethod.GET)
	public String blog(Model mv,@RequestParam("pageSize") Optional<Integer> pageSize,
            @RequestParam("page") Optional<Integer> page) {

        // Evaluate page size. If requested parameter is null, return initial
        // page size
        int evalPageSize = pageSize.orElse(INITIAL_PAGE_SIZE);
        
        // Evaluate page. If requested parameter is null or less than 0 (to
        // prevent exception), return initial size. Otherwise, return value of
        // param. decreased by 1.
        int evalPage = (page.orElse(0) < 1) ? INITIAL_PAGE : page.get() - 1;
        // print repo
        System.out.println("here is client repo " + postservices.getAllPosts());
        
        @SuppressWarnings("deprecation")
		Page<Post> postslist =postpagingRepo.findAll(new PageRequest(evalPage, evalPageSize));
        System.out.println("posts list get total pages" + postslist.getTotalPages() + "post list get number " + postslist.getNumber());
        
        PagerModel pager = new PagerModel(postslist.getTotalPages(),postslist.getNumber(),BUTTONS_TO_SHOW);
        // add posts
        mv.addAttribute("posts",postslist);
        // evaluate page size
        mv.addAttribute("selectedPageSize", evalPageSize);
        // add page sizes
        mv.addAttribute("pageSizes", PAGE_SIZES);
        // add pager
        mv.addAttribute("pager", pager);
                   
		//mv.addAttribute("posts", postservices.getAllPosts());
		mv.addAttribute("category",categoryservices.getAll());
		return "blog";
	}
	//blog detail by post id action
	@RequestMapping(value="/blogdetail/{id}",method = RequestMethod.GET)
	public String blogdetailById(@PathVariable Integer id, Model model){
		postDetail=postservices.getPostById(id);
        model.addAttribute("post", postDetail);
        model.addAttribute("CommentInPost",new CommentInPost());
        List<CommentInPost> c=commentInPostRepo.findByPostId(id);
        model.addAttribute("comments",c);
        model.addAttribute("CommentsCont",String.valueOf(c.size()));
        model.addAttribute("category",categoryservices.getAll());
        model.addAttribute("prevposts", postservices.getPostById(id-1));
        model.addAttribute("nexposts", postservices.getPostById(id+1));
		return "blogdetail";
	}
	
	//all blog action with blog by category id
	@RequestMapping(value="/blogbycategory/{id}",method = RequestMethod.GET)
	public String blogByCategoryId(@PathVariable Integer id, Model model,
			@RequestParam("pageSize") Optional<Integer> pageSize,
            @RequestParam("page") Optional<Integer> page){
		 // Evaluate page size. If requested parameter is null, return initial
        // page size
        int evalPageSize = pageSize.orElse(INITIAL_PAGE_SIZE);
        
        // Evaluate page. If requested parameter is null or less than 0 (to
        // prevent exception), return initial size. Otherwise, return value of
        // param. decreased by 1.
        int evalPage = (page.orElse(0) < 1) ? INITIAL_PAGE : page.get() - 1;      
       @SuppressWarnings("deprecation")
	  Page<Post> postslist =postpagingRepo.findBycategoryId(id,new PageRequest(evalPage, evalPageSize));  
       // add posts
        model.addAttribute("posts", postslist);        
        PagerModel pager = new PagerModel(postslist.getTotalPages(),postslist.getNumber(),BUTTONS_TO_SHOW);
        // evaluate page size
        model.addAttribute("selectedPageSize", evalPageSize);
        // add page sizes
        model.addAttribute("pageSizes", PAGE_SIZES);
        // add pager
        model.addAttribute("pager", pager);

    Integer cid = null;
    for(Post p:postslist) {
    	cid=p.getCategoryId();
    }
    model.addAttribute("category",categoryservices.SelectById(cid));
    model.addAttribute("cid", cid);
     return "blogbycategory";
	}
		
	   //comment to post by the user name,email,comments action
		//saving data to the database.
	   @PostMapping(value = "/blogdetail/comment")//action name >>post
	   public String commentToPost(@ModelAttribute ("CommentInPost")@Valid CommentInPost input ){	   
		   if(postDetail==null) {
			   return "redirect:/";
		   }
		   input.setPostId(postDetail.getId());
		   input.setPost(postDetail);
	   	  commentInPostRepo.save(input);
	   	  return "redirect:/blogdetail/"+postDetail.getId();
	   }
}
