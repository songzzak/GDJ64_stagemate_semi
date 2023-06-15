package com.stagemate.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
//필터 적용할 서블릿 추후 수정
@WebFilter(servletNames = { 
		"memberView", "updateMemberEnd", "updatePassword" 
})
public class AuthenticationFilter extends HttpFilter implements Filter {
	private static final long serialVersionUID = -302126541455035660L;
	private static final String LOGIN_MEMBER = "loginMember"; // 로그인한 계정 아이디 name 통일하기

	public AuthenticationFilter() {}

	public void destroy() {}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
			throws IOException, ServletException 
	{
		HttpSession session = ((HttpServletRequest) request).getSession();
		Object obj = session.getAttribute(LOGIN_MEMBER);
		
		if (obj == null) {
			request.setAttribute("msg", "잘못된 접근입니다!");
			request.setAttribute("loc", "/");
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
		} else {
			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {}

}
