package org.apache.jsp.grafico;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class infoGraficoNew_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<!DOCTYPE HTML>\n");
      out.write("<html>\n");
      out.write("\t<head>\n");
      out.write("\t\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\n");
      out.write("\t\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("\t\t<title>Highcharts Example</title>\n");
      out.write("\n");
      out.write("\t\t<style type=\"text/css\">\n");
      out.write("\n");
      out.write("\t\t</style>\n");
      out.write("\t</head>\n");
      out.write("\t<body>\n");
      out.write("<script src=\"../style/code/highcharts.js\"></script>\n");
      out.write("<script src=\"../style/code/modules/exporting.js\"></script>\n");
      out.write("<script src=\"../style/code/modules/export-data.js\"></script>\n");
      out.write("\n");
      out.write("<div id=\"container\" style=\"min-width: 310px; height: 400px; margin: 0 auto\"></div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\t\t<script type=\"text/javascript\">\n");
      out.write("Highcharts.chart('container', {\n");
      out.write("    chart: {\n");
      out.write("        type: 'area'\n");
      out.write("    },\n");
      out.write("    title: {\n");
      out.write("        text: 'US and USSR nuclear stockpiles'\n");
      out.write("    },\n");
      out.write("    subtitle: {\n");
      out.write("        text: 'Sources: <a href=\"https://thebulletin.org/2006/july/global-nuclear-stockpiles-1945-2006\">' +\n");
      out.write("            'thebulletin.org</a> &amp; <a href=\"https://www.armscontrol.org/factsheets/Nuclearweaponswhohaswhat\">' +\n");
      out.write("            'armscontrol.org</a>'\n");
      out.write("    },\n");
      out.write("    xAxis: {\n");
      out.write("        allowDecimals: false,\n");
      out.write("        labels: {\n");
      out.write("            formatter: function () {\n");
      out.write("                return this.value; // clean, unformatted number for year\n");
      out.write("            }\n");
      out.write("        }\n");
      out.write("    },\n");
      out.write("    yAxis: {\n");
      out.write("        title: {\n");
      out.write("            text: 'Nuclear weapon states'\n");
      out.write("        },\n");
      out.write("        labels: {\n");
      out.write("            formatter: function () {\n");
      out.write("                return this.value / 1000 + 'k';\n");
      out.write("            }\n");
      out.write("        }\n");
      out.write("    },\n");
      out.write("    tooltip: {\n");
      out.write("        pointFormat: '{series.name} had stockpiled <b>{point.y:,.0f}</b><br/>warheads in {point.x}'\n");
      out.write("    },\n");
      out.write("    plotOptions: {\n");
      out.write("        area: {\n");
      out.write("            pointStart: 1940,\n");
      out.write("            marker: {\n");
      out.write("                enabled: false,\n");
      out.write("                symbol: 'circle',\n");
      out.write("                radius: 2,\n");
      out.write("                states: {\n");
      out.write("                    hover: {\n");
      out.write("                        enabled: true\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("        }\n");
      out.write("    },\n");
      out.write("    series: [{\n");
      out.write("        name: 'USA',\n");
      out.write("        data: [\n");
      out.write("            null, null, null, null, null, 6, 11, 32, 110, 235,\n");
      out.write("            369, 640, 1005, 1436, 2063, 3057, 4618, 6444, 9822, 15468,\n");
      out.write("            20434, 24126, 27387, 29459, 31056, 31982, 32040, 31233, 29224, 27342,\n");
      out.write("            26662, 26956, 27912, 28999, 28965, 27826, 25579, 25722, 24826, 24605,\n");
      out.write("            24304, 23464, 23708, 24099, 24357, 24237, 24401, 24344, 23586, 22380,\n");
      out.write("            21004, 17287, 14747, 13076, 12555, 12144, 11009, 10950, 10871, 10824,\n");
      out.write("            10577, 10527, 10475, 10421, 10358, 10295, 10104, 9914, 9620, 9326,\n");
      out.write("            5113, 5113, 4954, 4804, 4761, 4717, 4368, 4018\n");
      out.write("        ]\n");
      out.write("    }, {\n");
      out.write("        name: 'USSR/Russia',\n");
      out.write("        data: [null, null, null, null, null, null, null, null, null, null,\n");
      out.write("            5, 25, 50, 120, 150, 200, 426, 660, 869, 1060,\n");
      out.write("            1605, 2471, 3322, 4238, 5221, 6129, 7089, 8339, 9399, 10538,\n");
      out.write("            11643, 13092, 14478, 15915, 17385, 19055, 21205, 23044, 25393, 27935,\n");
      out.write("            30062, 32049, 33952, 35804, 37431, 39197, 45000, 43000, 41000, 39000,\n");
      out.write("            37000, 35000, 33000, 31000, 29000, 27000, 25000, 24000, 23000, 22000,\n");
      out.write("            21000, 20000, 19000, 18000, 18000, 17000, 16000, 15537, 14162, 12787,\n");
      out.write("            12600, 11400, 5500, 4512, 4502, 4502, 4500, 4500\n");
      out.write("        ]\n");
      out.write("    }]\n");
      out.write("});\n");
      out.write("\t\t</script>\n");
      out.write("\t</body>\n");
      out.write("</html>\n");
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
