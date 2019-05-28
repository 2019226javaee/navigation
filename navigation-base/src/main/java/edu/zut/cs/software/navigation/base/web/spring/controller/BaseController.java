package edu.zut.cs.software.navigation.base.web.spring.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;

@Controller
public class BaseController {

	final Logger logger = LogManager.getLogger(this.getClass().getName());
}
