package edu.zut.cs.software.navigation.account.web.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.zut.cs.software.navigation.account.service.AccountManager;
import edu.zut.cs.software.navigation.admin.account.daomain.Account;
import edu.zut.cs.software.navigation.base.web.spring.controller.GenericController;
@Controller
@RequestMapping("/account")
public class AccountController extends GenericController<Account, Long, AccountManager>{

	
	AccountManager accountManager;
	
	@Autowired
    public void setAccountManager( AccountManager  accountManager) {
        this.accountManager = accountManager;
        this.manager = this.accountManager;
    }
	@RequestMapping("/accountdemo")
    public String index() {
        return "success";
    }

    @ResponseBody
    @GetMapping(value = "hello", produces = "application/json;charset=utf-8")
    public String hello() {
        return "Hello, This is Account!";
    }
    
    @ResponseBody
	@GetMapping(value = "all",produces = "application/json;charset=utf-8")
	public List<Account> findAllMap(){
		return this.manager.findAll();
	}


}