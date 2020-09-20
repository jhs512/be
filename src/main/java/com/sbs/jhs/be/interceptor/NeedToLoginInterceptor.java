package com.sbs.jhs.be.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component("needToLoginInterceptor") // 컴포넌트 이름 설정
public class NeedToLoginInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		boolean isLogined = (boolean) request.getAttribute("isLogined");

		if (isLogined == false) {
			response.setContentType("application/json; charset=UTF-8");
			response.getWriter().append("{\"resultCode\":\"F-A\",\"msg\":\"로그인 후 이용해주세요.\"}");
			return false;
		}

		return HandlerInterceptor.super.preHandle(request, response, handler);
	}
}
