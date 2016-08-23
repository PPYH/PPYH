package util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharacterEncodingFilter implements Filter {

	private String encoding;
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("Encoding filter dofilter called...");
		req.setCharacterEncoding(encoding);
		chain.doFilter(req, res);
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		System.out.println("Encoding filter init called...");
		encoding = config.getInitParameter("encoding");
		if (encoding == null) {
			encoding = "UTF-8";
		}
	}

	@Override
	public void destroy() {
		
		System.out.println("Encoding filter destroy called...");
	}

}
