package com.bank.Controller;

import org.springframework.web.bind.annotation.GetMapping;

public class MainController {
	  @GetMapping("")
	    public String viewHomePage() {
	        return "index";
	    }
	     
	    @GetMapping("/admin/login")
	    public String viewAdminLoginPage() {
	        return "admin/admin_login";
	    }
	     
	    @GetMapping("/admin/home")
	    public String viewAdminHomePage() {
	        return "admin/admin_home";
	    }
	     
	    @GetMapping("/user/login")
	    public String viewUserLoginPage() {
	        return "Caissier/user_login";
	    }
	     
	    @GetMapping("/user/home")
	    public String viewUserHomePage() {
	        return "Caissier/user_home";
	    }  

}
