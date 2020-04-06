package homework.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import homework.dto.UserDTO;
import homework.util.SessionUtil;

public class AuthoricationFilter implements Filter {

	private ServletContext context;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.context=filterConfig.getServletContext();
		
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest) servletRequest;
		HttpServletResponse response=(HttpServletResponse) servletResponse;
		String url=request.getRequestURI();
		UserDTO userDTO=(UserDTO) SessionUtil.getInstance().getValue(request, "USERMODEL");
		if(url.contains("/homework/admin")&&userDTO==null) {
			response.sendRedirect(request.getContextPath()+"/login?action=login");
			return;
		}
		else
			filterChain.doFilter(servletRequest, servletResponse);
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
