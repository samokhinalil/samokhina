/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2021-05-31 19:18:22 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import java.text.*;
import ru.rsreu.samokhina.entity.*;

public final class editrequest_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/pages/style.css", Long.valueOf(1620156387496L));
  }

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<style>\r\n");
      out.write("        ");
      out.write("table {\r\n");
      out.write("   border-collapse: collapse;\r\n");
      out.write("   border: 1px solid grey;\r\n");
      out.write("   width: 50%;\r\n");
      out.write("   text-align: center;\r\n");
      out.write("   margin-bottom: 10px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("th {\r\n");
      out.write("   border: 1px solid grey;\r\n");
      out.write("   padding: 10px;\r\n");
      out.write("   font-size: 14pt;\r\n");
      out.write("   background: #e8edff;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("td {\r\n");
      out.write("   border: 1px solid grey;\r\n");
      out.write("   padding: 10px;\r\n");
      out.write("   font-size: 14pt;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".form {\r\n");
      out.write("\twidth: 300px;\r\n");
      out.write("\theight: auto;\r\n");
      out.write("\tbackground: #e8edff;\r\n");
      out.write("\tfont-size: 12pt;\r\n");
      out.write("\tpadding: 20px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("input{\r\n");
      out.write("\tpadding: 5px;\r\n");
      out.write("\tmargin-bottom: 5px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("select {\r\n");
      out.write("\tpadding: 10px;\r\n");
      out.write("\tmargin-bottom: 10px;\r\n");
      out.write("\twidth: 200px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".button {\r\n");
      out.write("\tpadding: 5px;\r\n");
      out.write("\twidth: 100px;\r\n");
      out.write("}");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("  <head>\r\n");
      out.write("      <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("      <title>Edit request</title>\r\n");
      out.write("  </head>\r\n");
      out.write("  <body>\r\n");
      out.write("        \t<div class=\"form\">\r\n");
      out.write("        \t<form action=\"jobrequest?action=requestupdate\" method=\"POST\">\r\n");
      out.write("        \t\t<h3>Edit request</h3>\r\n");
      out.write("        \t\t<label for=\"startdate\">Choose start date:</label><br>\r\n");
      out.write("                <input type=\"date\" name=\"startdate\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${jobRequest.getStartDate()}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"></input><br>\r\n");
      out.write("                <label for=\"enddate\">Choose end date:</label><br>\r\n");
      out.write("                <input type=\"date\" name=\"enddate\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${jobRequest.getEndDate()}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"></input><br>\r\n");
      out.write("\r\n");
      out.write("                <label for=\"description\">Description:</label><br>\r\n");
      out.write("                <input type=\"text\" name=\"description\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${jobRequest.getDescription()}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"></input><br>\r\n");
      out.write("                <br>\r\n");
      out.write("                <input type=\"hidden\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${jobRequest.getId()}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" name=\"editedRequestId\"/>\r\n");
      out.write("                <input type=\"submit\" value=\"Update\" class=\"button\"></input>\r\n");
      out.write("        \t</form>\r\n");
      out.write("\r\n");
      out.write("            <input type=\"submit\" value=\"Cancel\" class=\"button\"><a href=\"/jobrequest?action=user\"></input>\r\n");
      out.write("\r\n");
      out.write("        \t</div>\r\n");
      out.write("  </body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
