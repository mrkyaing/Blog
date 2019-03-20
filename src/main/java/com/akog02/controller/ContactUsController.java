package com.akog02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.akog02.domain.ContactUs;
import com.akog02.services.IContactUsServices;

@Controller
public class ContactUsController {
@Autowired
private IContactUsServices services;
//getting the all data from the database.
@RequestMapping(value = "contactus/list", method = RequestMethod.GET)
public String list(Model model){
    model.addAttribute("contactusdata", services.getAllContactus());
    return "/pages/contactus/list";
}
//editing the data by product id
@RequestMapping("contactus/edit/{id}")
public String edit(@PathVariable Integer id, Model model){
    model.addAttribute("contactus", services.SelectById(id));
    return "/pages/contactus/entry";
}
//loading the product form 
@RequestMapping("contactus/new")
public String newProduct(Model model){
    model.addAttribute("contactus", new ContactUs());
    return "/pages/contactus/entry";
}
//saving data to the database.
@RequestMapping(value = "contactus", method = RequestMethod.POST)
public String saveProduct(ContactUs c){
	services.Save(c);
    return "redirect:/contactus/list";//action Name to redirect.
}
//deleting data from the database.
@RequestMapping("contactus/delete/{id}")
public String delete(@PathVariable Integer id){
	services.DeleteById(id);
    return "redirect:/contactus/list";//action Name to redirect.
}
}
