/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/10.1.17
 * Generated at: 2024-01-03 19:37:57 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.*;

public final class check_002dbalance_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports,
                 org.apache.jasper.runtime.JspSourceDirectives {

  private static final jakarta.servlet.jsp.JspFactory _jspxFactory =
          jakarta.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/lib/jakarta.servlet.jsp.jstl-2.0.0.jar", Long.valueOf(1704292724359L));
    _jspx_dependants.put("jar:file:/D:/project/bankapplication/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/bank-app/WEB-INF/lib/jakarta.servlet.jsp.jstl-2.0.0.jar!/META-INF/c.tld", Long.valueOf(1602854172000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("jakarta.servlet");
    _jspx_imports_packages.add("jakarta.servlet.http");
    _jspx_imports_packages.add("jakarta.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody;

  private volatile jakarta.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public boolean getErrorOnELNotFound() {
    return false;
  }

  public jakarta.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.release();
  }

  public void _jspService(final jakarta.servlet.http.HttpServletRequest request, final jakarta.servlet.http.HttpServletResponse response)
      throws java.io.IOException, jakarta.servlet.ServletException {

    if (!jakarta.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final jakarta.servlet.jsp.PageContext pageContext;
    jakarta.servlet.http.HttpSession session = null;
    final jakarta.servlet.ServletContext application;
    final jakarta.servlet.ServletConfig config;
    jakarta.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    jakarta.servlet.jsp.JspWriter _jspx_out = null;
    jakarta.servlet.jsp.PageContext _jspx_page_context = null;


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

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("    <title>Deposit Amount</title>\r\n");
      out.write("    <style>\r\n");
      out.write("    	body {\r\n");
      out.write("    font-family: 'Arial', sans-serif;\r\n");
      out.write("    margin: 0;\r\n");
      out.write("    padding: 0;\r\n");
      out.write("    box-sizing: border-box;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("header {\r\n");
      out.write("    background-color: grey;\r\n");
      out.write("    color: white;\r\n");
      out.write("    text-align: center;\r\n");
      out.write("    padding: 5px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("section {\r\n");
      out.write("    max-width: 400px;\r\n");
      out.write("    margin: 20px auto;\r\n");
      out.write("    padding: 10px;\r\n");
      out.write("    border: 1px solid #ccc;\r\n");
      out.write("    border-radius: 8px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("form {\r\n");
      out.write("    display: flex;\r\n");
      out.write("    flex-direction: column;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("label {\r\n");
      out.write("    margin-bottom: 8px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("input {\r\n");
      out.write("    padding: 8px;\r\n");
      out.write("    margin-bottom: 16px;\r\n");
      out.write("    border: 1px solid #ccc;\r\n");
      out.write("    border-radius: 4px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("button {\r\n");
      out.write("    background-color: grey;\r\n");
      out.write("    color: white;\r\n");
      out.write("    padding: 10px;\r\n");
      out.write("    border: none;\r\n");
      out.write("    border-radius: 4px;\r\n");
      out.write("    cursor: pointer;\r\n");
      out.write("}\r\n");
      out.write("h4{\r\n");
      out.write("	color: green;	\r\n");
      out.write("}\r\n");
      out.write("button:hover {\r\n");
      out.write("    background-color: #BEBEBE;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("footer {\r\n");
      out.write("    text-align: center;\r\n");
      out.write("    margin-top: 20px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("    	\r\n");
      out.write("    </style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("    <header>\r\n");
      out.write("        <h1>Check Balance</h1>\r\n");
      out.write("    </header>\r\n");
      out.write("\r\n");
      out.write("    <section>\r\n");
      out.write("        <form action=\"admin?action=checkBalance\" method=\"post\">\r\n");
      out.write("            <label for=\"accountNumber\">Account Number:</label>\r\n");
      out.write("            <input type=\"text\" id=\"accountNumber\" name=\"accountNumber\" required><br>\r\n");
      out.write("\r\n");
      out.write("            <button type=\"submit\">Submit</button>\r\n");
      out.write("        </form>\r\n");
      out.write("    </section>\r\n");
      out.write("\r\n");
      out.write("    <footer>\r\n");
      out.write("        <button onclick=\"redirectForm()\">Back</button>\r\n");
      out.write("        <h4>");
      //  c:out
      org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f0 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
      boolean _jspx_th_c_005fout_005f0_reused = false;
      try {
        _jspx_th_c_005fout_005f0.setPageContext(_jspx_page_context);
        _jspx_th_c_005fout_005f0.setParent(null);
        // /check-balance.jsp(87,12) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
        _jspx_th_c_005fout_005f0.setValue(request.getAttribute("closingbal"));
        int _jspx_eval_c_005fout_005f0 = _jspx_th_c_005fout_005f0.doStartTag();
        if (_jspx_th_c_005fout_005f0.doEndTag() == jakarta.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return;
        }
        _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f0);
        _jspx_th_c_005fout_005f0_reused = true;
      } finally {
        org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fout_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fout_005f0_reused);
      }
      out.write("</h4>\r\n");
      out.write("    </footer>\r\n");
      out.write("	<script>\r\n");
      out.write("	function redirectForm(){\r\n");
      out.write("		window.location.href = \"admin-dashboard.jsp\";\r\n");
      out.write("	}\r\n");
      out.write("</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof jakarta.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
