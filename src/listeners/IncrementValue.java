package listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class IncrementValue
 *
 */
@WebListener
public class IncrementValue implements ServletContextAttributeListener {

    /**
     * Default constructor. 
     */
    public IncrementValue() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextAttributeListener#attributeAdded(ServletContextAttributeEvent)
     */
    public void attributeAdded(ServletContextAttributeEvent arg0) {
        // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextAttributeListener#attributeReplaced(ServletContextAttributeEvent)
     */
    public void attributeReplaced(ServletContextAttributeEvent event) {
    	ServletContext context = event.getServletContext();
		Object newCompanyName = context.getAttribute("companyName");
		Object oldCompanyName = event.getValue();
		
		if (event.getName().equals("companyName") && 
				!newCompanyName.equals(oldCompanyName)) {
			
			double companyStock = (double) context.getAttribute("companyStock");
			context.setAttribute("companyStock", companyStock*1.25);
		}		
    }

	/**
     * @see ServletContextAttributeListener#attributeRemoved(ServletContextAttributeEvent)
     */
    public void attributeRemoved(ServletContextAttributeEvent arg0) {
        // TODO Auto-generated method stub
    }
	
}
