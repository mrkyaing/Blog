package com.akog02.configuration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.akog02.domain.ContactUs;
import com.akog02.domain.Post;
import com.akog02.domain.Role;
import com.akog02.common.RolesEnum;
import com.akog02.domain.Category;
import com.akog02.repostories.IContactUsRepository;
import com.akog02.repostories.ICategoryRepository;
import com.akog02.repostories.IPostRepository;
import com.akog02.repostories.IRoleRepository;

import java.util.Calendar;
import java.util.Date;

@Component
public class SeedingConfig implements ApplicationListener<ContextRefreshedEvent> {
 
	private static Integer categoryId_java;
    private static Integer categoryId_csharp;
    private static Integer categoryId_programdesign;
    
    Calendar cal = Calendar.getInstance();
    //CALLING THE ENUM >>RolesEnum.MANAGER.getId(), RolesEnum.MANAGER.getRoleName()
       @Autowired
       private ICategoryRepository categoryrepo;

        @Autowired
        private IPostRepository postrepo;

        @Autowired
        private IContactUsRepository contactusrepo;
       
        @Autowired
        private IRoleRepository rolerepo;
        
	    private static final Logger log = LogManager.getLogger(SeedingConfig.class);
   
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
    	
         Role sysrole=new Role();
         sysrole.setRoleLevel(RolesEnum.SYSADMIN.getId());
         sysrole.setRoleName(RolesEnum.SYSADMIN.getRoleName());
         rolerepo.save(sysrole);
         log.info("saving sysrole"+sysrole.getId());
         
         Role userrole=new Role();
         userrole.setRoleLevel(RolesEnum.BLOGUSER.getId());
         userrole.setRoleName(RolesEnum.BLOGUSER.getRoleName());
         rolerepo.save(userrole);
         log.info("saving userrole"+userrole.getId());
         
        Category category=new Category();
        category.setCode("C001");
        category.setActive(true);
        category.setDescription("Java Programming");
        categoryrepo.save(category);
        categoryId_java=category.getId();
        log.info("saving category"+category.getId());

        Category category1=new Category();
        category1.setCode("C002");
        category1.setActive(true);
        category1.setDescription("C# Programming");
        categoryrepo.save(category1);
        categoryId_csharp=category1.getId();
        log.info("saving category"+category1.getId());
        
        Category category2=new Category();
        category2.setCode("C003");
        category2.setActive(true);
        category2.setDescription("Best Program Design");
        categoryrepo.save(category2);
        categoryId_programdesign=category2.getId();
        log.info("saving category"+category2.getId());
        
        Post p = new Post();
        p.setActive(true);
        Date date = new Date();
        p.setCreatedDate(date);
        p.setTitle("core Java programming");
        p.setBriefDescription("The Origins of Java(Java မူလ အစ)");
        p.setBody("Java ကို စတင်တီထွင်သူတွေကတော့ Sun Microsystems ဆိုတဲ့ကုမ္ပဏီက သူတွေဖြစ်တဲ့ James Gosling,Patrick Naughton,Chris Warth,Ed Frank,နဲ့ Mike Sheridan သူတွေက ၁၉၉၁ မှ စပီးတီထွင်ခဲ့တာပါ");
        p.setImageUrl("JDK-8.png");
        p.setCategory(category);
        Category c=categoryrepo.findById(categoryId_java).orElse(null);
        p.setCategoryId(c.getId());
        p.setCategory(c);
        postrepo.save(p);
        
        Post p1 = new Post();
        p1.setActive(true);
        p1.setCreatedDate(cal.getTime());
        p1.setTitle("Web apps development with Spring boot");
        p1.setBriefDescription("What's spring boot?");
        p1.setBody("Spring Boot gives you the ability to create modern enterprise applications using a\r\n" + 
        		"convention-over-configuration design principle and building on the power and flexibility\r\n" + 
        		"of the underlying Spring Framework and its various components");
        p1.setImageUrl("3 billion devices.jpg");
        p1.setCategory(category);
        Category c1=categoryrepo.findById(categoryId_java).orElse(null);
        p1.setCategoryId(c1.getId());
        p1.setCategory(c1);
        postrepo.save(p1);

        Post p2 = new Post();
        p2.setActive(true);
        p2.setCreatedDate(cal.getTime());
        p2.setTitle("Web apps development with asp.net mvc and asp.net core");
        p2.setBriefDescription("What's asp.net mvc/Core?");
        p2.setBody("MVC stands for Model-View-Controller and is a recognized design pattern for developing software\r\n" + 
        		"applications. ASP.NET MVC based applications are made up of.");
        p2.setImageUrl("WelcomeToJavaInstall.png");
        p2.setCategory(category);
        Category c2=categoryrepo.findById(categoryId_csharp).orElse(null);
        p2.setCategoryId(c2.getId());
        p2.setCategory(c2);
        postrepo.save(p2);
        
        
        Post p3 = new Post();
        p3.setActive(true);
        p3.setCreatedDate(cal.getTime());
        p3.setTitle("STEPS IN PROGRAM DEVELOPMENT");
        p3.setBriefDescription("Computer programming is an art.Many people belive that a programmer must be a good at mathematics,have a memory for figures and technical information,and be prepared to spend many hours sitting at a computer.");
        p3.setBody("1)Define the problem.<br>2)Outline the solution <br> 3)Develop the outline into an algorighm <br>4)Test the algorithm for the correctness <br>5)Code thealgorithm into a specific programming language<br>6)Run the program on the computer <br>7)Document and matain the program");
        p3.setImageUrl("WelcomeToJavaInstall.png");
        p3.setCategory(category);
        Category c3=categoryrepo.findById(categoryId_programdesign).orElse(null);
        p3.setCategory(c3);
        p3.setCategoryId(c3.getId());
        postrepo.save(p3);
     
        ContactUs cu=new ContactUs();
        cu.setName("mgkyaing");
        cu.setMessage("this app is amazing");
        cu.setPhone("+959254666");
        contactusrepo.save(cu);
        
        log.info("saving contact us"+cu.getId());

    }
}
