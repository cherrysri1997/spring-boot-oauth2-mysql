package com.hcc.oAuth2WithMySql.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ReqController {
	
	@RequestMapping("/public")
	public String getPublic() {
		System.out.println("public api");
		return "its a public api";
	}
	
	@RequestMapping("/private")
	public String getPrivate() {
		
		System.out.println("private api");
		return "its a private api";
	}
	
	@RequestMapping("/admin")
	public String getAdmin() {
		return "it is an admin api";
	}
	
}
