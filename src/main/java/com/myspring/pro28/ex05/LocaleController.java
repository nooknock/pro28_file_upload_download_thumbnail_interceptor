package com.myspring.pro28.ex05;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("localeController")
public class LocaleController {
	
	@RequestMapping(value = "/test/locale.do",method = {RequestMethod.GET})
	public String locale() {
		System.out.println("로케일 컨트롤러다");
		return "locale";
	}
	
}
