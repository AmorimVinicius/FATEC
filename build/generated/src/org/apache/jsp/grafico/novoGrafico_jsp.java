package org.apache.jsp.grafico;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class novoGrafico_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("                     \n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("  <script src=\"https://cdn.anychart.com/releases/v8/js/anychart-base.min.js?hcode=be5162d915534272a57d0bb781d27f2b\"></script>\n");
      out.write("  <script src=\"https://cdn.anychart.com/releases/v8/js/anychart-ui.min.js?hcode=be5162d915534272a57d0bb781d27f2b\"></script>\n");
      out.write("  <script src=\"https://cdn.anychart.com/releases/v8/js/anychart-exports.min.js?hcode=be5162d915534272a57d0bb781d27f2b\"></script>\n");
      out.write("  <link href=\"https://cdn.anychart.com/releases/v8/css/anychart-ui.min.css?hcode=be5162d915534272a57d0bb781d27f2b\" type=\"text/css\" rel=\"stylesheet\">\n");
      out.write("  <link href=\"https://cdn.anychart.com/releases/v8/fonts/css/anychart-font.min.css?hcode=be5162d915534272a57d0bb781d27f2b\" type=\"text/css\" rel=\"stylesheet\">\n");
      out.write("  <style type=\"text/css\">\n");
      out.write("html, body, #container {\n");
      out.write("    width: 100%;\n");
      out.write("    height: 100%;\n");
      out.write("    margin: 0;\n");
      out.write("    padding: 0;\n");
      out.write("}\n");
      out.write("</style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("  <div id=\"container\"></div>\n");
      out.write("  <script>\n");
      out.write("anychart.onDocumentReady(function () {\n");
      out.write("    // create data set on our data,also we can pud data directly to series\n");
      out.write("    var dataSet = anychart.data.set([\n");
      out.write("        ['Jan', 22, 43, 75],\n");
      out.write("        ['Feb', 34, 45, 56],\n");
      out.write("        ['Mar', 16, 26, 67],\n");
      out.write("        ['Apr', 12, 86, 42],\n");
      out.write("        ['May', 41, 35, 17],\n");
      out.write("        ['Jun', 47, 31, 12],\n");
      out.write("        ['Jul', 39, 27, 9],\n");
      out.write("        ['Aug', 28, 16, 23],\n");
      out.write("        ['Sep', 21, 27, 47],\n");
      out.write("        ['Oct', 18, 31, 58],\n");
      out.write("        ['Nov', 24, 42, 69],\n");
      out.write("        ['Dec', 29, 39, 71]\n");
      out.write("    ]);\n");
      out.write("\n");
      out.write("    // map data for the first series,take value from first column of data set\n");
      out.write("    var seriesData_1 = dataSet.mapAs({'x': 0, 'value': 1});\n");
      out.write("\n");
      out.write("    // map data for the second series,take value from second column of data set\n");
      out.write("    var seriesData_2 = dataSet.mapAs({'x': 0, 'value': 2});\n");
      out.write("\n");
      out.write("    // map data for the third series, take x from the zero column and value from the third column of data set\n");
      out.write("    var seriesData_3 = dataSet.mapAs({'x': 0, 'value': 3});\n");
      out.write("\n");
      out.write("    // create line chart\n");
      out.write("    var chart = anychart.line();\n");
      out.write("\n");
      out.write("    // turn on chart animation\n");
      out.write("    chart.animation(true);\n");
      out.write("\n");
      out.write("    // turn on the crosshair and tune it\n");
      out.write("    chart.crosshair()\n");
      out.write("            .enabled(true)\n");
      out.write("            .yLabel(false)\n");
      out.write("            .xLabel(false)\n");
      out.write("            .yStroke(null);\n");
      out.write("\n");
      out.write("    // set chart padding\n");
      out.write("    chart.padding([10, 20, 5, 20]);\n");
      out.write("\n");
      out.write("    // set chart title text settings\n");
      out.write("    chart.title('ACME corp. Problems During the Year');\n");
      out.write("\n");
      out.write("    // set yAxis title\n");
      out.write("    chart.yAxis().title('Occurences per month');\n");
      out.write("\n");
      out.write("    // temp variable to store series instance\n");
      out.write("    var series;\n");
      out.write("\n");
      out.write("    // setup first series\n");
      out.write("    series = chart.line(seriesData_1);\n");
      out.write("    series.name('Purchase Returns')\n");
      out.write("            .stroke('#000000')\n");
      out.write("            .size(4);\n");
      out.write("    series.hovered().markers(true);\n");
      out.write("\n");
      out.write("    // setup second series\n");
      out.write("    series = chart.line(seriesData_2);\n");
      out.write("    series.name('Delivery Failure')\n");
      out.write("            .size(4)\n");
      out.write("            .stroke(\n");
      out.write("                    {\n");
      out.write("                        color: '#6C6C6C',\n");
      out.write("                        dash: '3 5 10 5'\n");
      out.write("                    }\n");
      out.write("            );\n");
      out.write("    series.hovered().markers(true);\n");
      out.write("\n");
      out.write("    // setup third series\n");
      out.write("    series = chart.line(seriesData_3);\n");
      out.write("    series.name('Order Cancellation')\n");
      out.write("            .size(4)\n");
      out.write("            .stroke(\n");
      out.write("                    {\n");
      out.write("                        color: '#C8C8C8',\n");
      out.write("                        dash: '3 5'\n");
      out.write("                    }\n");
      out.write("            );\n");
      out.write("    series.hovered().markers(true);\n");
      out.write("\n");
      out.write("    // interactivity and tooltip settings\n");
      out.write("    chart.interactivity().hoverMode('by-x');\n");
      out.write("\n");
      out.write("    chart.tooltip()\n");
      out.write("            .displayMode('separated')\n");
      out.write("            .positionMode('point')\n");
      out.write("            .separator(false)\n");
      out.write("            .position('right')\n");
      out.write("            .anchor('left-bottom')\n");
      out.write("            .offsetX(2)\n");
      out.write("            .offsetY(5)\n");
      out.write("            .title(false)\n");
      out.write("            .format('{%Value} times');\n");
      out.write("\n");
      out.write("    // turn the legend on\n");
      out.write("    chart.legend(true);\n");
      out.write("\n");
      out.write("    // set container id for the chart\n");
      out.write("    chart.container('container');\n");
      out.write("    // initiate chart drawing\n");
      out.write("    chart.draw();\n");
      out.write("});\n");
      out.write("</script>\n");
      out.write("</body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("                ");
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
