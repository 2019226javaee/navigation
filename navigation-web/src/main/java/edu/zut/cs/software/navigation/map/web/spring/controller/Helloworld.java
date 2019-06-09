package edu.zut.cs.software.navigation.map.web.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Helloworld {

	@RequestMapping("/helloworld")
	public String hello() {
		System.out.println("helloworld");
		return "success";
	}
}
