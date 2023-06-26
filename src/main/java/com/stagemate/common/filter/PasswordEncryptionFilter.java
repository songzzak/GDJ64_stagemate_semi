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
// 필터 적용할 서블릿 추후 수정
@WebFilter(urlPatterns={"/loginEnd.do", "/member/enrollEnd.do"})
public class PasswordEncryptionFilter extends HttpFilter implements Filter {
	private static final long serialVersionUID = 2958115529336001142L;

    public PasswordEncryptionFilter() {}

	public void destroy() {}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
			throws IOException, ServletException 
	{
		PasswordEncryptionWrapper pew = new PasswordEncryptionWrapper((HttpServletRequest) request);
		chain.doFilter(pew, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {}

}
