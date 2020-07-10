package org.apache.jsp.grafico;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class infoGrafico_005f1_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("  <head>\n");
      out.write("    <!-- Carregando a API AJAX -->\n");
      out.write("    <script type=\"text/javascript\" src=\"https://www.google.com/jsapi\"></script>\n");
      out.write("    <script type=\"text/javascript\">\n");
      out.write("    \n");
      out.write("      // Carregando a API Visualization e os pacotes de gráficos\n");
      out.write("      google.load('visualization', '1.0', {'packages':['corechart']});\n");
      out.write("      \n");
      out.write("      // Configurando o método que será executado quando a API for carregada\n");
      out.write("      google.setOnLoadCallback(drawChart);\n");
      out.write("\n");
      out.write("      // Método onde será criado o DataTable,\n");
      out.write("      // configurado e inicializado o gráfico.\n");
      out.write("      function drawChart() {\n");
      out.write("\n");
      out.write("\t      // Criando o DataTable\n");
      out.write("\t      var data = new google.visualization.DataTable();\n");
      out.write("\t\t\tdata.addColumn('string', 'Região');\n");
      out.write("\t\t\tdata.addColumn('number', 'Geladeira');\n");
      out.write("\t\t\tdata.addColumn('number', 'Fogão');\n");
      out.write("\t\t\tdata.addColumn('number', 'Microondas');\n");
      out.write("\t\t\tdata.addColumn('number', 'Cafeteira');\n");
      out.write("\t\t\tdata.addColumn('number', 'Meta de Vendas');\n");
      out.write("\t\t\tdata.addRows([\n");
      out.write("\t\t\t ['Norte', 4, 6, 1, 1, 4],\n");
      out.write("\t\t\t ['Nordeste', 8, 7, 5, 2, 5],\n");
      out.write("\t\t\t ['Sul', 5, 7, 5, 4, 5],\n");
      out.write("\t\t\t ['Sudeste', 8, 6, 7, 6, 7],\n");
      out.write("\t\t\t ['Centro-Oeste', 6, 7, 3, 4, 4]\n");
      out.write("\t\t  ]);\n");
      out.write("\t\n");
      out.write("\t      // Opções de customização\n");
      out.write("\t\t  var options = {\n");
      out.write("\t\t    'legend':'right',\n");
      out.write("\t\t    'title':'Vendas Por Região',\n");
      out.write("\t\t    'is3D':true,\n");
      out.write("\t\t    'width':700,\n");
      out.write("\t\t    'height':400,\n");
      out.write("\t\t    seriesType: \"bars\",\n");
      out.write("\t\t    series: {4: {type: \"line\"}}\n");
      out.write("\t\t  };\n");
      out.write("\t\t\t\n");
      out.write("\t      // Instanciando e desenhando o gráfico, passando algunas opções\n");
      out.write("\t      var chart = new google.visualization.ComboChart(document.getElementById('chart_div'));\n");
      out.write("\t      chart.draw(data, options);\n");
      out.write("\t\n");
      out.write("\t  }\n");
      out.write("    </script>\n");
      out.write("  </head>\n");
      out.write("\n");
      out.write("  <body>\n");
      out.write("\t<!-- Div onde será criado o gráfico -->\n");
      out.write("    <div id=\"chart_div\" style=\"width:400; height:300\"></div>\n");
      out.write("\n");
      out.write("  </body>\n");
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
