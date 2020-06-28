package com.yyk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 主界面
 * 
 * */
@Controller
public class MainController {
	
	
	@RequestMapping({"/","main","index"})
	public String main(){
		
		return "main";
	}

}
