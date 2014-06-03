package filtri;


import java.io.IOException;
import java.util.Date; // For Date class

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/** Simple filter that prints a report on the standard output 
 *  each time an associated servlet or JSP page is accessed.
 *  <p>
 *  From <a href="http://courses.coreservlets.com/Course-Materials/">the
 *  coreservlets.com tutorials on servlets, JSP, Struts, JSF, Ajax, GWT, 
 *  Spring, Hibernate, JPA, and Java</a>.
 */

@WebFilter(urlPatterns={"/test-servlet","/test.jsp"}) 
public class ReportFilter implements Filter {
  public void doFilter(ServletRequest request,
                       ServletResponse response,
                       FilterChain chain)
      throws ServletException, IOException {
    HttpServletRequest req = (HttpServletRequest)request;
    System.out.println(req.getRemoteHost() +
                       " tried to access " +
                       req.getRequestURL() +
                       " on " + new Date() + ".");
    chain.doFilter(request,response);
  }

  public void init(FilterConfig config)
      throws ServletException {
  }
  
  public void destroy() {}
}
