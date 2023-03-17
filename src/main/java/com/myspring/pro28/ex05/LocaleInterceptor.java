package com.myspring.pro28.ex05;


import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
//HandlerInterceptor : Workflow interface that allows for customized handler execution chains.Applications can register any number of existing or custom interceptorsfor certain groups of handlers, to add common preprocessing behaviorwithout needing to modify each handler implementation. 
//Abstract adapter class for the HandlerInterceptor interface,for simplified implementation of pre-only/post-only interceptors.
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LocaleInterceptor extends HandlerInterceptorAdapter {

	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session=request.getSession();
		String locale=request.getParameter("locale");
		
		System.out.println(locale);
		
		if(locale==null) {
			locale="ko";
		}
		
		//LocaleResolver implementation that uses a locale attribute in the user's session in case of a custom setting, with a fallback to the configured default locale, the request's Accept-Language header, or the default locale for the server.
		session.setAttribute("org.springframework.web.servlet.i18n.SessionLocaleResolver.LOCALE", new Locale(locale));
		
		return true;
	}
	
	
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
	}
	
}
