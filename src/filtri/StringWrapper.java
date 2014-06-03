package filtri;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

/** A response wrapper that takes everything the client
 *  would normally output and saves it in one big String.
 *  <p>
 *  From <a href="http://courses.coreservlets.com/Course-Materials/">the
 *  coreservlets.com tutorials on servlets, JSP, Struts, JSF, Ajax, GWT, 
 *  Spring, Hibernate, JPA, and Java</a>.
 */

public class StringWrapper
             extends HttpServletResponseWrapper {
  private StringWriter stringWriter;

  /** Initializes wrapper.
   *  <p>
   *  First, this constructor calls the parent
   *  constructor. That call is crucial so that the response
   *  is stored and thus setHeader, setStatus, addCookie,
   *  and so forth work normally.
   *  <p>
   *  Second, this constructor creates a StringWriter
   *  that will be used to accumulate the response.
   */

  public StringWrapper(HttpServletResponse response) {
    super(response);
    stringWriter = new StringWriter();
  }

  /** When servlets or JSP pages ask for the Writer,
   *  don't give them the real one. Instead, give them
   *  a version that writes into the StringWriter.
   *  The filter needs to send the contents of the
   *  buffer to the client (usually after modifying it).
   */

  @Override
  public PrintWriter getWriter() {
    return(new PrintWriter(stringWriter));
  }

  /** Similarly, when resources call getOutputStream,
    * give them a phony output stream that just
    * buffers up the output.
    */

  @Override
  public ServletOutputStream getOutputStream() {
    return(new StringOutputStream(stringWriter));
  }

  /** Get a String representation of the entire buffer.
   *  <p>
   *  Be sure <i>not</i> to call this method multiple times
   *  on the same wrapper. The API for StringWriter
   *  does not guarantee that it "remembers" the previous
   *  value, so the call is likely to make a new String
   *  every time.
   */

  @Override
  public String toString() {
    return(stringWriter.toString());
  }

  /** Get the underlying StringBuffer. */

  public StringBuffer getBuffer() {
    return(stringWriter.getBuffer());
  }
}
