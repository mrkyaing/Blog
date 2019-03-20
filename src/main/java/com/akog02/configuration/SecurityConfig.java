package com.akog02.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	/*@Bean
    public PasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }*/
 
    // In this example we do not use Security.
    // Override this method with empty code
    // to disable the default Spring Boot security.
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        		http
                .authorizeRequests()
                .antMatchers("/blog/**").permitAll()
                .antMatchers("/blogbycategory/**").permitAll()              
                .antMatchers("/blogdetail/**").permitAll()
                .antMatchers("/blogimages/**").permitAll()
                .antMatchers("/register/**").permitAll()
                 .antMatchers(
                            "/",
                            "/js/**",
                            "/fonts/**",  
                            "/css/**",
                            "/summernote/**",
                            "/images/**",
                            "/webjars/**").permitAll()
                    .antMatchers("/user/**").hasRole("ADMIN")
                    .anyRequest().authenticated()
                    .and()
                    .formLogin()
                    .loginPage("/login")
                    .usernameParameter("username").passwordParameter("password")
                    .permitAll()
	                .and()
	                .logout()
	                .logoutUrl("/")
                    .invalidateHttpSession(true)
                    .clearAuthentication(true)
                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                    .logoutSuccessUrl("/login?logout")
                    .permitAll()
            		.logoutSuccessUrl("/")
            		.and().exceptionHandling(); //exception handling configuration
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        		auth.inMemoryAuthentication()
                .withUser("akog02").password("{noop}root").roles("ADMIN");
    }
    @Override
    public void configure(WebSecurity web) throws Exception {
        		web
                .ignoring()
                .antMatchers("/resources/**");
    }
}
