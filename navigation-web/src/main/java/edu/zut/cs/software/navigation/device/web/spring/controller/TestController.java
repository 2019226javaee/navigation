package edu.zut.cs.software.navigation.device.web.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")

public class TestController {
	@RequestMapping("/register")
	public String register(HttpServletRequest request) {
		String password =request.getParameter("username");
		System.out.println(password);
		System.out.println(request.getParameterMap().entrySet());
		return "恭喜你注册成功";
	}

}
