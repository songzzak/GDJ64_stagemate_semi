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

import com.stagemate.member.model.vo.Member;
//필터 적용할 서블릿 추후 수정
@WebFilter("/admin/*")
public class AdminFilter extends HttpFilter implements Filter {
	private static final long serialVersionUID = 5019094855642891983L;
	private static final String LOGIN_MEMBER = "loginMember"; // 로그인한 계정 아이디 name 통일하기

	public AdminFilter() {}

	public void destroy() {}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
			throws IOException, ServletException 
	{
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		Object admin = session.getAttribute(LOGIN_MEMBER);
		
		if (admin == null || !((Member) admin).getMemberId().equals("admin")) {
			req.setAttribute("msg", "잘못된 접근입니다!");
			req.setAttribute("loc", "/");
			req.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
			return;
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {}

}
