package filtri;

import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;

/** Filter that changes all occurrences of "filtersRus.com" to "weBefilters.com".
 *  <p>
 *  From <a href="http://courses.coreservlets.com/Course-Materials/">the
 *  coreservlets.com tutorials on servlets, JSP, Struts, JSF, Ajax, GWT, 
 *  Spring, Hibernate, JPA, and Java</a>.
 */

@WebFilter(urlPatterns={"/test.jsp"})
public class ReplaceCeoFIlter extends ReplaceFilter {
	@Override
		public void init(FilterConfig config) throws ServletException {
			// TODO Auto-generated method stub
			super.init(config);
			setCaseInsensitive(true);
	}
	
  @Override
  public String getTarget() {
	  
    return("Roberto");
  }

  @Override
  public String getReplacement() {
    return("Luca");
  }
}
