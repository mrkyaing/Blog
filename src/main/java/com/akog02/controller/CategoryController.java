package com.akog02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.akog02.domain.Category;
import com.akog02.services.ICategoryServices;

@Controller
@RequestMapping("/category")
public class CategoryController {
@Autowired
private ICategoryServices services;

//getting the all data from the database.
@RequestMapping(value = "/list", method = RequestMethod.GET)
public String list(Model model){
  model.addAttribute("categorydata", services.getAll());
  return "/pages/category/list";
}

//loading the entry form
@RequestMapping("/entry")
public String Entry(Model model){
  model.addAttribute("category", new Category());
  return "/pages/category/entry";
}
//saving data to the database.
@RequestMapping(value = "/save", method = RequestMethod.POST)
public String Entry(Category model){
	services.Save(model);
  return "redirect:/category/list";//action Name to redirect.
}
    //editing the data by  id
    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute("category", services.SelectById(id));
        return "/pages/category/entry";
    }
//deleting data from the database.
@RequestMapping("/delete/{id}")
public String delete(@PathVariable Integer id){
	services.DeleteById(id);
  return "redirect:/category/list";//action Name to redirect.
}
}
