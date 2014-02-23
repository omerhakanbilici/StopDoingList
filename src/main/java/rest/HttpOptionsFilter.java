package rest;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns={"/rest/*"})
public class HttpOptionsFilter implements Filter {

	  
    public HttpOptionsFilter() {
        // TODO Auto-generated constructor stub
    }


	public void destroy() {
		// TODO Auto-generated method stub
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		   HttpServletRequest httpRequest = (HttpServletRequest) request; 
		   HttpServletResponse httpResponse = (HttpServletResponse) response;    
	       if(httpRequest.getMethod().equalsIgnoreCase("OPTIONS")){
	    	   
	    	   httpResponse.addHeader("Access-Control-Allow-Origin", "*");
	    	   httpResponse.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS, PUT, DELETE");
	    	   httpResponse.addHeader("Content-Type", "application/json");
	    	   String returnMethod = httpRequest.getHeader("access-control-request-headers");
	    	   
	   		if (returnMethod!=null && !"".equals(returnMethod)) {
	   			httpResponse.addHeader("Access-Control-Allow-Headers", returnMethod);
	   		}
	   		
	       }else{
	    	   chain.doFilter(request, response);
	       }
	}

	
	public void init(FilterConfig fConfig) throws ServletException {}

}
