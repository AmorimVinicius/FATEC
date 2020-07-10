package org.apache.jsp.grafico;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class selecaoGrafico_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_varStatus_var_items;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_varStatus_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_varStatus_var_items.release();
    _jspx_tagPool_c_if_test.release();
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
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        <link rel=\"stylesheet\" href=\"../style/css/bootstrap.min.css\">\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js\"></script>\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.11/jquery.mask.min.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"../style/js/config.js\"></script>       \n");
      out.write("        <link rel=\"stylesheet\" href=\"http://code.jquery.com/ui/1.9.0/themes/base/jquery-ui.css\" />\n");
      out.write("\t<script src=\"http://code.jquery.com/jquery-1.8.2.js\"></script>\n");
      out.write("\t<script src=\"http://code.jquery.com/ui/1.9.0/jquery-ui.js\"></script>           \n");
      out.write("        <script src=\"https://cdn.anychart.com/releases/v8/js/anychart-base.min.js?hcode=be5162d915534272a57d0bb781d27f2b\"></script>\n");
      out.write("        <script src=\"https://cdn.anychart.com/releases/v8/js/anychart-ui.min.js?hcode=be5162d915534272a57d0bb781d27f2b\"></script>\n");
      out.write("        <script src=\"https://cdn.anychart.com/releases/v8/js/anychart-exports.min.js?hcode=be5162d915534272a57d0bb781d27f2b\"></script>\n");
      out.write("       <style type=\"text/css\">\n");
      out.write("        #container {\n");
      out.write("          width: 1000px;\n");
      out.write("          height: 500px;\n");
      out.write("          margin: 0;\n");
      out.write("          padding: 0;\n");
      out.write("      }\n");
      out.write("      </style>\n");
      out.write("\t\t\n");
      out.write("\t<script type=\"text/javascript\">\n");
      out.write("            $(document).ready(function(){\n");
      out.write("\t \t$(\".form-control\").datepicker({\n");
      out.write("                    dateFormat: 'dd/mm/yy',\n");
      out.write("                    dayNames: ['Domingo','Segunda','Terça','Quarta','Quinta','Sexta','Sábado','Domingo'],\n");
      out.write("                    dayNamesMin: ['D','S','T','Q','Q','S','S','D'],\n");
      out.write("                    dayNamesShort: ['Dom','Seg','Ter','Qua','Qui','Sex','Sáb','Dom'],\n");
      out.write("                    monthNames: ['Janeiro','Fevereiro','Março','Abril','Maio','Junho','Julho','Agosto','Setembro','Outubro','Novembro','Dezembro'],\n");
      out.write("                    monthNamesShort: ['Jan','Fev','Mar','Abr','Mai','Jun','Jul','Ago','Set','Out','Nov','Dez'],\n");
      out.write("                    nextText: 'Próximo',\n");
      out.write("                    prevText: 'Anterior'\n");
      out.write("\t\t});\n");
      out.write("            });\n");
      out.write("\t</script>\n");
      out.write("        \n");
      out.write("        <title>Seguradora</title>              \n");
      out.write("    </head>\n");
      out.write("    \n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("            <nav class=\"navbar navbar-expand-lg navbar-dark bg-dark fixed-top\">\n");
      out.write("                <a class=\"navbar-brand\" href=\"#\">Seguradora</a>\n");
      out.write("                <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n");
      out.write("                    <span class=\"navbar-toggler-icon\"></span>\n");
      out.write("                </button>\n");
      out.write("\n");
      out.write("                <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\n");
      out.write("                    <ul class=\"navbar-nav mr-auto\">\n");
      out.write("                        <li class=\"nav-item active\">\n");
      out.write("                            <a class=\"nav-link\" href=\"../admin/index.jsp\">Home <span class=\"sr-only\">(current)</span></a>\n");
      out.write("                        </li>                                                \n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("            </nav>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        <br/> <br/> <br/> <br/> <br/>\n");
      out.write("        <div class=\"container\">\t\n");
      out.write("            <h1>Selecionar Intervalo</h1>\n");
      out.write("            <form action='filtrar' method=\"POST\">\n");
      out.write("                \n");
      out.write("                <hr>\n");
      out.write("                 \n");
      out.write("               <div>\n");
      out.write("                    <label for=\"dataInicial\" class=\"col-3 col-form-label\">Data Inicial:</label>\n");
      out.write("                    <div class=\"col-3\">\n");
      out.write("                        <input class=\"form-control\" type=\"text\" id=\"dataInicial\" name=\"dataInicial\">\n");
      out.write("                    </div>\n");
      out.write("                    <label for=\"dataFinal\" class=\"col-3 col-form-label\">Data Final:</label>\n");
      out.write("                    <div class=\"col-3\">\n");
      out.write("                        <input class=\"form-control\" type=\"text\" id=\"dataFinal\" name=\"dataFinal\" >\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <br>\n");
      out.write("                <hr>\n");
      out.write("                \n");
      out.write("               \t<input type=\"hidden\" name=\"operacao\" value=\"LISTARFILTRO\">\n");
      out.write("                <input class=\"btn btn-primary\" type=\"submit\" id=\"criarGrafico\" value=\"Gerar Gráfico\">\n");
      out.write("                <br/>\n");
      out.write("            </form>               \n");
      out.write("                \n");
      out.write("                ");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write("  \n");
      out.write("                    \n");
      out.write("                ");
      if (_jspx_meth_c_if_1(_jspx_page_context))
        return;
      out.write("  \n");
      out.write("      \n");
      out.write("                <br/>\n");
      out.write("                              \n");
      out.write("                <br/>              \n");
      out.write("                    \n");
      out.write("                \n");
      out.write("        <div id=\"container\"></div>\n");
      out.write("        \n");
      out.write("       <script>\n");
      out.write("anychart.onDocumentReady(function () {\n");
      out.write("    // create data set on our data,also we can pud data directly to series\n");
      out.write("    var dataSet = anychart.data.set([\n");
      out.write("        ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("    ]);\n");
      out.write("\n");
      out.write("    // quantidade total\n");
      out.write("    var seriesData_1 = dataSet.mapAs({'x': 0, 'value': 1});\n");
      out.write("\n");
      out.write("    // aprovado\n");
      out.write("    var seriesData_2 = dataSet.mapAs({'x': 0, 'value': 2});\n");
      out.write("\n");
      out.write("    // recusado\n");
      out.write("    var seriesData_3 = dataSet.mapAs({'x': 0, 'value': 3});\n");
      out.write("    \n");
      out.write("    // aguardando\n");
      out.write("    var seriesData_4 = dataSet.mapAs({'x': 0, 'value': 4});\n");
      out.write("\n");
      out.write("    // create line chart\n");
      out.write("    var chart = anychart.bar();\n");
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
      out.write("    //chart.padding([10, 20, 5, 20]);\n");
      out.write("\n");
      out.write("    chart.title('TOTAL DE SINISTROS');\n");
      out.write("\n");
      out.write("    chart.yAxis().title('Quantidade de Sinistros por Dia');\n");
      out.write("    \n");
      out.write("    chart.xAxis().title('Intervalo de Dias');\n");
      out.write("\n");
      out.write("    // temp variable to store series instance\n");
      out.write("    var series;\n");
      out.write("\n");
      out.write("    // setup first series\n");
      out.write("    series = chart.bar(seriesData_1);\n");
      out.write("    series.name('Quantidade')            \n");
      out.write("            .size(4)\n");
      out.write("            .stroke({                       \n");
      out.write("                    color: '#696969'                    \n");
      out.write("                    });\n");
      out.write("    series.hovered().markers(true);\n");
      out.write("\n");
      out.write("    // setup second series\n");
      out.write("    series = chart.line(seriesData_2);\n");
      out.write("    series.name('Aprovado')\n");
      out.write("            .size(4)\n");
      out.write("            .stroke({                        \n");
      out.write("                    color: '#006400',\n");
      out.write("                    line: '10'\n");
      out.write("                    });\n");
      out.write("    series.hovered().markers(true);\n");
      out.write("\n");
      out.write("    // setup third series\n");
      out.write("    series = chart.line(seriesData_3);\n");
      out.write("    series.name('Recusado')\n");
      out.write("            .size(4)\n");
      out.write("            .stroke({\n");
      out.write("                    color: '#FF0000'\n");
      out.write("                    });\n");
      out.write("    series.hovered().markers(true);\n");
      out.write("    \n");
      out.write("    // setup third series\n");
      out.write("    series = chart.line(seriesData_4);\n");
      out.write("    series.name('Aguardando')\n");
      out.write("            .size(4)\n");
      out.write("            .stroke(\n");
      out.write("                    {\n");
      out.write("                        color: '#FFD700'\n");
      out.write("                    }\n");
      out.write("            );\n");
      out.write("    series.hovered().markers(true);\n");
      out.write("\n");
      out.write("    // interactivity and tooltip settings\n");
      out.write("   // chart.interactivity().hoverMode('by-x');\n");
      out.write("\n");
      out.write("    chart.tooltip()\n");
      out.write("            .displayMode('separated')\n");
      out.write("            .positionMode('point')\n");
      out.write("            .separator(false)\n");
      out.write("            .position('right')\n");
      out.write("            .anchor('left-bottom')\n");
      out.write("            .offsetX(2)\n");
      out.write("            .offsetY(35)\n");
      out.write("            .title(false)\n");
      out.write("            .format('{%Value} Total');\n");
      out.write("    \n");
      out.write("    // turn the legend on\n");
      out.write("    chart.legend(true);\n");
      out.write("\n");
      out.write("    // set container id for the chart\n");
      out.write("    chart.container('container');\n");
      out.write("    // initiate chart drawing\n");
      out.write("    chart.draw();\n");
      out.write("});\n");
      out.write("</script>         \n");
      out.write("        \n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
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

  private boolean _jspx_meth_c_if_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_0.setPageContext(_jspx_page_context);
    _jspx_th_c_if_0.setParent(null);
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${mensagem != null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                    <br/>\n");
        out.write("                    <p>");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${mensagem}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</p>\n");
        out.write("                ");
        int evalDoAfterBody = _jspx_th_c_if_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
    return false;
  }

  private boolean _jspx_meth_c_if_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_1.setPageContext(_jspx_page_context);
    _jspx_th_c_if_1.setParent(null);
    _jspx_th_c_if_1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${!mensagem != null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_1 = _jspx_th_c_if_1.doStartTag();
    if (_jspx_eval_c_if_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                    <hr>\n");
        out.write("                    <div class=\"container-fluid\">                         \n");
        out.write("                    </div>\n");
        out.write("                ");
        int evalDoAfterBody = _jspx_th_c_if_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
    return false;
  }

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_varStatus_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setVar("grafico");
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${resultado}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_0.setVarStatus("loop");
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("            ['");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${grafico.dataInicial}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("', ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${grafico.quantidade}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write(',');
          out.write(' ');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${grafico.aprovado}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write(',');
          out.write(' ');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${grafico.recusado}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write(',');
          out.write(' ');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${grafico.aguardando}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("],            \n");
          out.write("        ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_varStatus_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }
}
