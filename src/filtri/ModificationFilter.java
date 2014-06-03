package filtri;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

/** Abstract parent class of filters that wrap and modify output.
 *  <p>
 *  From <a href="http://courses.coreservlets.com/Course-Materials/">the
 *  coreservlets.com tutorials on servlets, JSP, Struts, JSF, Ajax, GWT, 
 *  Spring, Hibernate, JPA, and Java</a>.
 */

public abstract class ModificationFilter implements Filter {
  private HttpServletRequest request;
  private HttpServletResponse response;

  public void doFilter(ServletRequest req,
                       ServletResponse resp,
                       FilterChain chain)
      throws ServletException, IOException {
    request = (HttpServletRequest)req;
    response = (HttpServletResponse)resp;
    StringWrapper responseWrapper =
      new StringWrapper(response);
    // Invoke resource, accumulating output in the wrapper.
    chain.doFilter(request, responseWrapper);
    // Turn entire output into one big String.
    String modifiedResponse =
      doModification(responseWrapper.toString());
    PrintWriter out = response.getWriter();
    // Output the modified response
    out.write(modifiedResponse);
  }

  public abstract String doModification(String origResponse);

  public void init(FilterConfig config) throws ServletException {}

  public void destroy() {}

  public HttpServletRequest getRequest() {
    return(request);
  }

  public HttpServletResponse getResponse() {
    return(response);
  }

}
