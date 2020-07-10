package org.apache.jsp.grafico;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class infoGrafico_005f1_005f1_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

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
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<html>\n");
      out.write("<head>\n");
      out.write("  <title>Graphical View</title>\n");
      out.write("  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n");
      out.write("  <script type=\"text/javascript\" src=\"https://www.gstatic.com/charts/loader.js\"></script>\n");
      out.write("  <script type=\"text/javascript\">\n");
      out.write("    google.charts.load('current', {packages: ['corechart', 'bar']});\n");
      out.write("    google.charts.setOnLoadCallback(drawBasic);\n");
      out.write("\n");
      out.write("    function drawBasic() {\n");
      out.write("      var data = google.visualization.DataTable();\n");
      out.write("\n");
      out.write("      data.addColumn('string', 'Player Name');\n");
      out.write("      data.addColumn('number', 'Runs Scored');\n");
      out.write("\n");
      out.write("      data.addRow('John',250);\n");
      out.write("      data.addRow('sachin',165); \n");
      out.write("      data.addRow('ponting',54); \n");
      out.write("      data.addRow('richards',320);\n");
      out.write("\n");
      out.write("      var options = {\n");
      out.write("        title: 'Player Name vs Number of runs scored',\n");
      out.write("        hAxis: {\n");
      out.write("          title: 'Player Name'\n");
      out.write("        },\n");
      out.write("        vAxis: {\n");
      out.write("          title: 'Runs Scored'\n");
      out.write("        }\n");
      out.write("      };\n");
      out.write("\n");
      out.write("      var chart = new google.visualization.ColumnChart(\n");
      out.write("        document.getElementById('chart_div'));\n");
      out.write("\n");
      out.write("      chart.draw(data, options);\n");
      out.write("    }\n");
      out.write("  </script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("  <div id=\"chart_div\"></div>\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
