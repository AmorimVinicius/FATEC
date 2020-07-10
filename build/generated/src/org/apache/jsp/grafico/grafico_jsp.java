package org.apache.jsp.grafico;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class grafico_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<script type=\"text/javascript\" src=\"https://www.gstatic.com/charts/loader.js\"></script>\n");
      out.write("  <script type=\"text/javascript\">\n");
      out.write("    google.charts.load(\"current\", {packages:['corechart']});\n");
      out.write("    google.charts.setOnLoadCallback(drawChart);\n");
      out.write("    function drawChart() {\n");
      out.write("      var data = google.visualization.arrayToDataTable([\n");
      out.write("        [\"Element\", \"Density\", { role: \"style\" } ],\n");
      out.write("        [\"Copper\", 8.94, \"#b87333\"],\n");
      out.write("        [\"Silver\", 10.49, \"silver\"],\n");
      out.write("        [\"Gold\", 19.30, \"gold\"],\n");
      out.write("        [\"Platinum\", 21.45, \"color: #e5e4e2\"]\n");
      out.write("      ]);\n");
      out.write("\n");
      out.write("      var view = new google.visualization.DataView(data);\n");
      out.write("      view.setColumns([0, 1,\n");
      out.write("                       { calc: \"stringify\",\n");
      out.write("                         sourceColumn: 1,\n");
      out.write("                         type: \"string\",\n");
      out.write("                         role: \"annotation\" },\n");
      out.write("                       2]);\n");
      out.write("\n");
      out.write("      var options = {\n");
      out.write("        title: \"Density of Precious Metals, in g/cm^3\",\n");
      out.write("        width: 600,\n");
      out.write("        height: 400,\n");
      out.write("        bar: {groupWidth: \"95%\"},\n");
      out.write("        legend: { position: \"none\" },\n");
      out.write("      };\n");
      out.write("      var chart = new google.visualization.ColumnChart(document.getElementById(\"columnchart_values\"));\n");
      out.write("      chart.draw(view, options);\n");
      out.write("  }\n");
      out.write("  </script>\n");
      out.write("<div id=\"columnchart_values\" style=\"width: 900px; height: 300px;\"></div>");
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
