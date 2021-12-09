/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2021-11-22 14:56:35 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

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
      response.setContentType("text/html");
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
      out.write("<html>\r\n");
      out.write("  <head>\r\n");
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\" />\r\n");
      out.write("    <title>Inventory System Login</title>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"style.css\">\r\n");
      out.write("    <link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">\r\n");
      out.write("\t<link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>\r\n");
      out.write("\t<link href=\"https://fonts.googleapis.com/css2?family=Nunito&display=swap\" rel=\"stylesheet\">\r\n");
      out.write("\t<script\r\n");
      out.write("\t  src=\"https://code.jquery.com/jquery-3.4.1.min.js\"\r\n");
      out.write("\t  integrity=\"sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=\"\r\n");
      out.write("\t  crossorigin=\"anonymous\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\"\r\n");
      out.write("\t    src=\"https://cdn.jsdelivr.net/npm/jquery-validation@1.19.0/dist/jquery.validate.min.js\"></script>\r\n");
      out.write("  </head>\r\n");
      out.write("\r\n");
      out.write("  <body>\r\n");
      out.write("\t  <div class=\"loginContainer\">\r\n");
      out.write("\t    <h1>Inventory management System</h1>\r\n");
      out.write("\t      <form class=\"loginForm\" id=\"loginForm\"action=\"FrontController\" method=\"post\">\r\n");
      out.write("\t        \t<h1 class=\"formHeading\">Login</h1>\r\n");
      out.write("\t\t        <input class=\"input\" name=\"username\" size=\"15\" type=\"text\" placeholder=\"Username\"/>\r\n");
      out.write("\t\t        <input class=\"input\" name=\"password\" size=\"15\" type=\"password\" placeholder=\"Password\"/>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<div class=\"loginFormButtons\">\r\n");
      out.write("\t\t\t\t\t<input type=\"hidden\" name=\"action\" value=\"LoginUser\" />\r\n");
      out.write("\t\t\t      \t<input class=\"button\" type=\"submit\" value=\"login\" />\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t  </form>\r\n");
      out.write("\t\t  \r\n");
      out.write("\t\t  <form action=\"FrontController\" method=\"post\">\r\n");
      out.write("\t\t\t<div>\r\n");
      out.write("\t\t\t\t<input type=\"hidden\" name=\"action\" value=\"SignUpUserClick\" />\r\n");
      out.write("\t\t      \t<input class=\"button\" type=\"submit\" value=\"Signup\" />\r\n");
      out.write("\t      \t</div>\r\n");
      out.write("\t\t  </form>\r\n");
      out.write("\t\t  \r\n");
      out.write("\t\t  <form action=\"FrontController\" method=\"post\">\r\n");
      out.write("\t\t\t<div>\r\n");
      out.write("\t\t\t\t<input type=\"hidden\" name=\"action\" value=\"ResetPasswordClick\" />\r\n");
      out.write("\t\t      \t\tForgot Your Password:\r\n");
      out.write("\t\t      \t<input class=\"button\" type=\"submit\" value=\"Reset Password\" />\r\n");
      out.write("\t      \t</div>\r\n");
      out.write("\t\t  </form>\r\n");
      out.write("\t  </div>\r\n");
      out.write("  </body>\r\n");
      out.write("  \r\n");
      out.write("  <script type=\"text/javascript\">\r\n");
      out.write(" \r\n");
      out.write("    $(document).ready(function() {\r\n");
      out.write("        $(\"#loginForm\").validate({\r\n");
      out.write("            rules: {\r\n");
      out.write("            \tusername: {\r\n");
      out.write("                    required: true,\r\n");
      out.write("                },\r\n");
      out.write("         \r\n");
      out.write("                password: \"required\",\r\n");
      out.write("            },\r\n");
      out.write("             \r\n");
      out.write("            messages: {\r\n");
      out.write("            \tusername: {\r\n");
      out.write("                    required: \"Please enter username\",\r\n");
      out.write("                },\r\n");
      out.write("                 \r\n");
      out.write("                password: \"Please enter password\"\r\n");
      out.write("            }\r\n");
      out.write("        });\r\n");
      out.write(" \r\n");
      out.write("    });\r\n");
      out.write("</script>\r\n");
      out.write("</html>\r\n");
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