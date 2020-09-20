package com.sbs.jhs.be.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component("needToLogoutInterceptor") // 컴포넌트 이름 설정
public class NeedToLogoutInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		boolean isLogined = (boolean) request.getAttribute("isLogined");

		if (isLogined) {
			response.setContentType("application/json; charset=UTF-8");
			response.getWriter().append("{\"resultCode\":\"F-B\",\"msg\":\"로그아웃 후 이용해주세요.\"}");
			return false;
		}

		return HandlerInterceptor.super.preHandle(request, response, handler);
	}
}
