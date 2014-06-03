package filtri;

/** Abstract parent class of filters that replace all occurrences
 *  of target with replacement in output of resource to which they are applied.
 *  <p>
 *  From <a href="http://courses.coreservlets.com/Course-Materials/">the
 *  coreservlets.com tutorials on servlets, JSP, Struts, JSF, Ajax, GWT, 
 *  Spring, Hibernate, JPA, and Java</a>.
 */

public abstract class ReplaceFilter extends ModificationFilter {
  private boolean isCaseInsensitive = false;

  public abstract String getTarget();

  public abstract String getReplacement();

  public void setCaseInsensitive(boolean flag) {
    isCaseInsensitive = flag;
  }

  public boolean isCaseInsensitive() {
    return(isCaseInsensitive);
  }

  @Override
  public String doModification(String orig) {
    if ((getTarget() == null) ||
        (getReplacement() == null)) {
      return(orig);
    } else {
      String target = getTarget();
      if (isCaseInsensitive()) {
        target = "(?i)" + target;
      }
      String replacement = getReplacement();
      return(orig.replaceAll(target, replacement));
    }
  }
}
