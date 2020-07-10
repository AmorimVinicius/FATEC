package org.apache.jsp.veiculo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class cadastrarVeiculo_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Seguradora</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"../style/css/bootstrap.min.css\">\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js\"></script>\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.11/jquery.mask.min.js\"></script>    \n");
      out.write("        <!--<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">\n");
      out.write("        -->\n");
      out.write("        </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container\">\t\n");
      out.write("            <h3>Cadastrar Veículo</h3>\n");
      out.write("            <hr>\n");
      out.write("            <form action='salvar' method=\"POST\">\n");
      out.write("                \n");
      out.write("                <c:if test=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${mensagem != null}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("                    <br/>\n");
      out.write("                    <p>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${mensagem}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</p>\n");
      out.write("                </c:if>\n");
      out.write("                \n");
      out.write("                <br/>\n");
      out.write("                <div class=\"form-group row\">\n");
      out.write("                    <label for=\"marca\" class=\"col-2 col-form-label\">Marca:</label>\n");
      out.write("                    <div class=\"col-3\">\n");
      out.write("                        <input class=\"form-control\" type=\"text\" id=\"marca\" name=\"marca\" required=\"true\" maxlength=\"100\">\n");
      out.write("                    </div>\n");
      out.write("                    \n");
      out.write("                    <label for=\"modelo\" class=\"col-2 col-form-label\">Modelo:</label>  \n");
      out.write("                    <div class=\"col-4\">\n");
      out.write("                        <input class=\"form-control\" type=\"text\" id=\"modelo\" name=\"modelo\" required=\"true\" maxlength=\"11\">\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                \n");
      out.write("                <div class=\"form-group row\">\n");
      out.write("                    <label for=\"placa\" class=\"col-2 col-form-label\">Placa:</label>\n");
      out.write("                    <div class=\"col-2\">\n");
      out.write("                        <input class=\"form-control\" type=\"text\" id=\"placa\" name=\"placa\" required=\"true\" maxlength=\"8\">\n");
      out.write("                    </div>\n");
      out.write("                    <label for=\"chassi\" class=\"col-2 col-form-label\">Chassi:</label>\n");
      out.write("                    <div class=\"col-4\">\n");
      out.write("                        <input class=\"form-control\" type=\"text\" id=\"chassi\" name=\"chassi\" required=\"true\" maxlength=\"17\">\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                               \n");
      out.write("                \n");
      out.write("                <div class=\"form-group row\">                    \n");
      out.write("                    <label for=\"anoFabricacao\" class=\"col-2 col-form-label\">Ano Fabricação:</label>\n");
      out.write("                    <div class=\"col-1\">\n");
      out.write("                        <input class=\"form-control\" type=\"text\" id=\"anoFabricacao\" name=\"anoFabricacao\" required=\"true\" maxlength=\"4\">\n");
      out.write("                    </div>\n");
      out.write("                    <label for=\"anoModelo\" class=\"col-2 col-form-label\">Ano Modelo:</label>\n");
      out.write("                    <div class=\"col-1\">\n");
      out.write("                        <input class=\"form-control\" type=\"text\" id=\"anoModelo\" name=\"anoModelo\" required=\"true\" maxlength=\"4\">\n");
      out.write("                    </div>                    \n");
      out.write("                </div>\n");
      out.write("                \n");
      out.write("                <br/>\n");
      out.write("                <h3>Dados Cliente</h3>\n");
      out.write("                <hr>  \n");
      out.write("                              \n");
      out.write("                <div class=\"form-group row\">\n");
      out.write("                    \n");
      out.write("                    <label for=\"documento\" class=\"col-2 col-form-label\">CPF / CNPJ:</label>\n");
      out.write("                    <div class=\"col-3\">\n");
      out.write("                        <input class=\"form-control\" type=\"text\" id=\"documento\" name=\"documento\" required=\"true\" maxlength=\"15\">\n");
      out.write("                    </div>\n");
      out.write("                    \n");
      out.write("                </div>\n");
      out.write("                \n");
      out.write("              <!--  <div class=\"form-group row\">\n");
      out.write("                    <label for=\"imagem\" class=\"col-2 col-form-label\">Marca:</label>\n");
      out.write("                    <div class=\"col-3\">\n");
      out.write("                        <input class=\"form-control\" type=\"file\" id=\"imagem\" name=\"imagem\" required=\"true\" maxlength=\"100\">\n");
      out.write("                    </div>\n");
      out.write("                    \n");
      out.write("                </div>-->\n");
      out.write("                \n");
      out.write("                <br />\n");
      out.write("                    \n");
      out.write("                <input type=\"hidden\" name=\"operacao\" value=\"SALVAR\">\n");
      out.write("                <input type='submit' class=\"btn btn-primary\" name='Salvar' value='Salvar' />\n");
      out.write("                <br/>\n");
      out.write("                \n");
      out.write("            </form>\n");
      out.write("            <br/>\n");
      out.write("            <br/>\n");
      out.write("        </div>    \n");
      out.write("                \n");
      out.write("        <!-- Bootstrap core JavaScript -->\n");
      out.write("        \n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            $(\"#placa\").mask(\"AAA-0000\");\n");
      out.write("            $(\"#anoFabricacao\").mask(\"0000\");\n");
      out.write("            $(\"#anoModelo\").mask(\"0000\");\n");
      out.write("            $(\"#chassi\").mask(\"000000000000000000\");           \n");
      out.write("        </script>\n");
      out.write("        \n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js\" integrity=\"sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1\" crossorigin=\"anonymous\"></script>\n");
      out.write("    </body>\n");
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
