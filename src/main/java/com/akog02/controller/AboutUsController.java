package com.akog02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/aboutus")
public class AboutUsController {

	@RequestMapping("/index")
	public String index() {
		return "/pages/aboutus/index";
	}
}
