package com.akog02.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.akog02.common.RolesEnum;
import com.akog02.domain.CommentInPost;
import com.akog02.domain.Role;
import com.akog02.domain.User;
import com.akog02.domain.UserInRole;
import com.akog02.repostories.ICommentInPostRepository;
import com.akog02.repostories.IUserInRoleRepository;
import com.akog02.services.IRoleServices;
import com.akog02.services.IUserServies;


@Controller
@RequestMapping("/register")
public class UserController {

	@Autowired 
	IUserServies userservices;
	@Autowired
	IUserInRoleRepository userinroleRepo;
	@Autowired
	IRoleServices roleservices;
	
	@Autowired
	ICommentInPostRepository commentInPostRepo;
	
	@RequestMapping("/register")
	public String register(Model model) {
		model.addAttribute("user", new User());
        return "/pages/user/register";
	}
	//saving data to the database.
    @PostMapping(value = "/register")//action name >>post
    public String register(@ModelAttribute ("user")@Valid User input,	HttpSession session ){
    	try {			
			UserInRole ur=new UserInRole();
			User u=new User(input.getUserName(),input.getPassword(),input.getDesignation(),input.getGender(),input.getEmail(),false);		
			Role r=roleservices.getRoleByRoleLevel(RolesEnum.BLOGUSER.getId());
			ur.setRoleId(r.getId());//set the role id		
			ur.setRole(r);
			userservices.saveUser(u);//saving the user
			ur.setUser(u);
			ur.setUserId(u.getId());//set the user id	
			session.setAttribute("userId", u.getId());//set the user id in the session
			userinroleRepo.save(ur);//saving the user in role
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 return "redirect:/";//"/pages/user/register";
    }
  
  //saving data to the database.
    @PostMapping(value = "/comment")//action name >>post
    public String commentToPost(@ModelAttribute ("CommentInPost")@Valid CommentInPost input ){
    	 /* Long userId = (Long) session.getServletContext().getAttribute("userId");
    	  if(userId != null) {
    		  return "redirect:/register/register";
    	  }*/
    	/*  input.setUserId(userId);
    	  User u=userservices.getUserById(userId);
    	  input.setUser(u);*/
    	  commentInPostRepo.save(input);
    	  return "redirect:/";//"/pages/user/register";
    }
}
