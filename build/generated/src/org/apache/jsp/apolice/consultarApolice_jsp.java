package org.apache.jsp.apolice;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class consultarApolice_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
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
      out.write("        <title>Seguradora</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container-fluid\">   \n");
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
      out.write("                        </li>\n");
      out.write("                        <li class=\"nav-item dropdown\">\n");
      out.write("                            <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdown\" role=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\n");
      out.write("                                Apólice\n");
      out.write("                            </a>\n");
      out.write("                            <div class=\"dropdown-menu\" aria-labelledby=\"navbarDropdown\">\n");
      out.write("                                <a class=\"dropdown-item\" href=\"cadastrarApolice.jsp\">Cadastrar Apólice</a>\n");
      out.write("                                <div class=\"dropdown-divider\"></div>\n");
      out.write("                                <a class=\"dropdown-item\" href=\"consultarApolice.jsp\">Consultar Apólice</a>\n");
      out.write("                            </div>\n");
      out.write("                        </li>                        \n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("            </nav>\n");
      out.write("        </div>\n");
      out.write("        <br/> <br/> <br/> <br/> <br/>\n");
      out.write("        <div class=\"container\">\t\n");
      out.write("            <h1>Consultar Apólice</h1>\n");
      out.write("            <form action='filtrar' method=\"POST\">\n");
      out.write("                <div class=\"form-group row\">\n");
      out.write("                    <label for=\"documento\" class=\"col-2 col-form-label\">Documento:</label>\n");
      out.write("                    <div class=\"col-3\">\n");
      out.write("                        <input class=\"form-control\" type=\"text\" id=\"documento\" name=\"documento\" >\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                \n");
      out.write("                <div class=\"form-group row\">\n");
      out.write("                    <label for=\"placa\" class=\"col-2 col-form-label\">Placa:</label>\n");
      out.write("                    <div class=\"col-3\">\n");
      out.write("                        <input class=\"form-control\" type=\"text\" id=\"placa\" name=\"placa\" >\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <hr/>\n");
      out.write("                \n");
      out.write("                <div class=\"form-group row\">\n");
      out.write("                    <div class=\"custom-control custom-radio custom-control-inline\">\n");
      out.write("                        <input type=\"radio\" class=\"custom-control-input\" id=\"opStatus1\" checked value=\"1\" name=\"opStatus\">\n");
      out.write("                        <label class=\"custom-control-label\" for=\"opStatus1\">Ativo</label>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                 \n");
      out.write("                    <div class=\"custom-control custom-radio custom-control-inline\">\n");
      out.write("                        <input type=\"radio\" class=\"custom-control-input\" id=\"opStatus\" value=\"0\" name=\"opStatus\">\n");
      out.write("                        <label class=\"custom-control-label\" for=\"opStatus\">Inativo</label>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("               \t<input type=\"hidden\" name=\"operacao\" value=\"LISTARFILTRO\">\n");
      out.write("\n");
      out.write("                <input class=\"btn btn-primary\" type=\"submit\" value=\"filtrar\">\n");
      out.write("                <br/>\n");
      out.write("            \n");
      out.write("                ");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("      \n");
      out.write("            <br/>\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <form> \n");
      out.write("                <table class=\"table table-striped\">\n");
      out.write("                    <thead>\n");
      out.write("                        <tr>\n");
      out.write("                            <th scope=\"col\">Data Início</th>\n");
      out.write("                            <th scope=\"col\">Data Fim</th>\n");
      out.write("                            <th scope=\"col\">Prêmio</th>\n");
      out.write("                            <th scope=\"col\">Valor Apólice (Franquia)</th>\n");
      out.write("                            <th scope=\"col\">Tipo Apólice</th>\n");
      out.write("                            <th scope=\"col\">Marca</th>\n");
      out.write("                            <th scope=\"col\">Modelo</th>\n");
      out.write("                            <th scope=\"col\">Placa</th>\n");
      out.write("                            <th scope=\"col\">Alterar</th>\n");
      out.write("                            <th scope=\"row\">Encerrar</th>\n");
      out.write("                        </tr>\n");
      out.write("                    </thead>\n");
      out.write("\n");
      out.write("                    <tbody>\n");
      out.write("                        ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                    </tbody>\n");
      out.write("                </table>\n");
      out.write("                </form>\n");
      out.write("                             \n");
      out.write("                \n");
      out.write("                ");
      if (_jspx_meth_c_if_1(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                \n");
      out.write("            </div>\n");
      out.write("        \n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            $(\"#documento\").mask(\"000.000.000-00\");\n");
      out.write("            $(\"#placa\").mask(\"AAA-0000\");\n");
      out.write("        </script>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <!-- Bootstrap core JavaScript -->\n");
      out.write("        <script src=\"../style/js/jquery-3.3.1.min.js\"></script>\n");
      out.write("        <script src=\"../style/js/popper.min.js\"></script>\n");
      out.write("        <script src=\"../style/js/bootstrap.min.js\"></script>\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js\" integrity=\"sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1\" crossorigin=\"anonymous\"></script>\n");
      out.write("    \n");
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

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setVar("apolice");
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${resultado}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                            <tr>\n");
          out.write("                                <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${apolice.dataInicio}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                                <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${apolice.dataFim}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                                <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${apolice.premio}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                                <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${apolice.valorApolice}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                                <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${apolice.tipoApolice}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>             \n");
          out.write("                                <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${apolice.veiculo.marca}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                                <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${apolice.veiculo.modelo}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                                <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${apolice.veiculo.placa}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                                <td><a href=\"preAtualizar?id=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${apolice.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("&operacao=PREATUALIZAR\"><input class=\"btn btn-secondary\" type=\"button\" value=\"Alterar\"></a></td>\n");
          out.write("                                <td><a href=\"excluir?id=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${apolice.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("&veiculo=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${apolice.veiculo.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("&operacao=EXCLUIR\"><input class=\"btn btn-danger\" type=\"button\" value=\"Encerrar\"></a></td>\n");
          out.write("                                <td><input type=\"hidden\" id=\"nomeCliente\" name=\"nomeCliente\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${apolice.cliente.nome}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\"></td>\n");
          out.write("                                <td><input type=\"hidden\" name=\"documentoCliente\" id=\"documentoCliente\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${apolice.cliente.documento}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\"></td>\n");
          out.write("                                <td><input type=\"hidden\" id=\"idEndereco\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${apolice.endereco.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\"></td>\n");
          out.write("                                <td><input type=\"hidden\" id=\"cepEndereco\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${apolice.endereco.cep}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\"></td>\n");
          out.write("                                <td><input type=\"hidden\" id=\"logradouroEndereco\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${apolice.endereco.logradouro}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\"></td>\n");
          out.write("                                <td><input type=\"hidden\" id=\"complementoEndereco\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${apolice.endereco.complemento}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\"></td>\n");
          out.write("                                <td><input type=\"hidden\" id=\"numeroEndereco\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${apolice.endereco.numero}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\"></td>\n");
          out.write("                                <td><input type=\"hidden\" id=\"bairroEndereco\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${apolice.endereco.bairro}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\"></td>\n");
          out.write("                                <td><input type=\"hidden\" id=\"cidadeEndereco\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${apolice.cidade.cidade}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\"></td>\n");
          out.write("                                <td><input type=\"hidden\" id=\"estadoEndereco\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${apolice.estado.estado}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\"></td>\n");
          out.write("                                <td><input type=\"hidden\" id=\"idPernoite\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${apolice.endereco.idPernoite}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\"></td>\n");
          out.write("                                <td><input type=\"hidden\" id=\"cepPernoite\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${apolice.endereco.cepSec}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\"></td>\n");
          out.write("                                <td><input type=\"hidden\" id=\"logradouroPernoite\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${apolice.endereco.logradouroSec}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\"></td>\n");
          out.write("                                <td><input type=\"hidden\" id=\"complementoPernoite\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${apolice.endereco.complementoSec}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\"></td>\n");
          out.write("                                <td><input type=\"hidden\" id=\"numeroPernoite\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${apolice.endereco.numeroSec}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\"></td>\n");
          out.write("                                <td><input type=\"hidden\" id=\"bairroPernoite\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${apolice.endereco.bairroSec}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\"></td>\n");
          out.write("                                <td><input type=\"hidden\" id=\"cidadePernoite\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${apolice.cidade.cidadeSec}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\"></td>\n");
          out.write("                                <td><input type=\"hidden\" id=\"estadoPernoite\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${apolice.estado.estadoSec}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\"></td>                                \n");
          out.write("                                <td><input type=\"hidden\" id=\"idVeiculo\" name='idVeiculo' value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${apolice.veiculo.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\"></td>                                \n");
          out.write("                                <td><input type=\"hidden\" id=\"idCliente\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${apolice.cliente.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\"></td>\n");
          out.write("                            </tr>\n");
          out.write("                        ");
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
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
    }
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
    _jspx_th_c_if_1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${mensagem != null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_1 = _jspx_th_c_if_1.doStartTag();
    if (_jspx_eval_c_if_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                    <br/>\n");
        out.write("                    <p>");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${mensagem}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</p>\n");
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
}
