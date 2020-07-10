package org.apache.jsp.sinistro;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class consultarSinistro_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.7.0/jquery.min.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"../style/js/estados-cidades.js\"></script>\n");
      out.write("        <title>Seguradora</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("                \n");
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
      out.write("                            <a class=\"nav-link\" href=\"#\">Home <span class=\"sr-only\">(current)</span></a>\n");
      out.write("                        </li>\n");
      out.write("\n");
      out.write("                        <li class=\"nav-item dropdown\">\n");
      out.write("                            <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdown\" role=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\n");
      out.write("                                Veículo\n");
      out.write("                            </a>\n");
      out.write("                            <div class=\"dropdown-menu\" aria-labelledby=\"navbarDropdown\">\n");
      out.write("                                <a class=\"dropdown-item\" href=\"cadastrarSinistro.jsp\">Cadastrar Sinistro</a>\n");
      out.write("                                <div class=\"dropdown-divider\"></div>\n");
      out.write("                                <a class=\"dropdown-item\" href=\"consultarSinistro.jsp\">Consultar Sinistro</a>\n");
      out.write("                                <div class=\"dropdown-divider\"></div>\n");
      out.write("                                <a class=\"dropdown-item\" href=\"#\">Something else here</a>\n");
      out.write("                            </div>\n");
      out.write("                        </li>\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("            </nav>\n");
      out.write("        </div>\n");
      out.write("        <br/> <br/> <br/> <br/> <br/>\n");
      out.write("        <div class=\"container\">\t\n");
      out.write("            <h1>Consultar Sinistro</h1>\n");
      out.write("            <form action='filtrar' method=\"POST\">\n");
      out.write("                <div class=\"form-group row\">\n");
      out.write("                    <label for=\"placa\" class=\"col-2 col-form-label\">Placa:</label>\n");
      out.write("                    <div class=\"col-3\">\n");
      out.write("                        <input class=\"form-control\" type=\"text\" id=\"placa\" name=\"placa\" >\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                \n");
      out.write("                <div class=\"form-group row\">\n");
      out.write("                    <label for=\"documento\" class=\"col-2 col-form-label\">Documento Cliente:</label>\n");
      out.write("                    <div class=\"col-3\">\n");
      out.write("                        <input class=\"form-control\" type=\"text\" id=\"documento\" name=\"documento\" >\n");
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
      out.write("                <input class=\"btn btn-primary\" type=\"submit\" value=\"Filtrar\">\n");
      out.write("                <br/>\n");
      out.write("            \n");
      out.write("                ");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write("            \n");
      out.write("      \n");
      out.write("            <br/>\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <form> \n");
      out.write("                <table class=\"table table-striped\">\n");
      out.write("                    <thead>\n");
      out.write("                        <tr>\n");
      out.write("                            <th scope=\"col\">Nome</th>\n");
      out.write("                            <th scope=\"col\">Documento</th>\n");
      out.write("                            <th scope=\"col\">Modelo</th>\n");
      out.write("                            <th scope=\"col\">Placa</th>\n");
      out.write("                            <th scope=\"col\">Sinistro</th>\n");
      out.write("                            <th scope=\"col\">Documento</th>\n");
      out.write("                            <th scope=\"col\">Endereço</th>\n");
      out.write("                            <th scope=\"col\">CRVL</th>\n");
      out.write("                            <th scope=\"col\">CNH</th>\n");
      out.write("                            <th scope=\"col\">B.O</th>\n");
      out.write("                            <th scope=\"col\">Status</th>\n");
      out.write("                            <th scope=\"col\">Descrição</th>\n");
      out.write("                            <th scope=\"col\">Data</th>\n");
      out.write("                            <th scope=\"col\">Aceitar</th>\n");
      out.write("                            <th scope=\"col\">Recusar</th>\n");
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
      out.write("                \n");
      out.write("                <script language=\"javascript\">                                             \n");
      out.write("                    var radios = document.body.querySelectorAll(\"input[id='recusado']\");                        \n");
      out.write("                    for(var x=0; x<radios.length; x++){\n");
      out.write("                        radios[x].onclick = function(){\n");
      out.write("                            document.getElementById('classeMotivoRecusa').style.display = \"inline\";\n");
      out.write("                            document.getElementById('classeNomeMecanica').style.display = \"none\";\n");
      out.write("                            document.getElementById('classeEnderecoMecanicaCep').style.display = \"none\";\n");
      out.write("                            document.getElementById('classeEnderecoMecanicaLogradouro').style.display = \"none\";\n");
      out.write("                            document.getElementById('classeEnderecoMecanicaBairro').style.display = \"none\";\n");
      out.write("                            document.getElementById('classeEnderecoMecanicaEstado').style.display = \"none\";\n");
      out.write("                            cliqueRecusado(this.value);                            \n");
      out.write("                        }\n");
      out.write("                    } \n");
      out.write("                    var radios = document.body.querySelectorAll(\"input[id='aprovado']\");                        \n");
      out.write("                    for(var x=0; x<radios.length; x++){\n");
      out.write("                        radios[x].onclick = function(){\n");
      out.write("                            document.getElementById('classeMotivoRecusa').style.display = \"none\";\n");
      out.write("                            document.getElementById('classeNomeMecanica').style.display = \"inline\";\n");
      out.write("                            document.getElementById('classeEnderecoMecanicaCep').style.display = \"inline\";\n");
      out.write("                            document.getElementById('classeEnderecoMecanicaLogradouro').style.display = \"inline\";\n");
      out.write("                            document.getElementById('classeEnderecoMecanicaBairro').style.display = \"inline\";\n");
      out.write("                            document.getElementById('classeEnderecoMecanicaEstado').style.display = \"inline\";\n");
      out.write("                            cliqueAprovado(this.value);\n");
      out.write("                        }\n");
      out.write("                    } \n");
      out.write("                    function cliqueRecusado(i){\n");
      out.write("                        document.getElementById('id').value = i;   \n");
      out.write("                        document.getElementById('retorno').value = \"Reprovado\";\n");
      out.write("                    }\n");
      out.write("                    function cliqueAprovado(i){\n");
      out.write("                        document.getElementById('id').value = i;\n");
      out.write("                        document.getElementById('retorno').value = \"Aprovado\";\n");
      out.write("                    }\n");
      out.write("                </script>\n");
      out.write("                \n");
      out.write("                <script type=\"text/javascript\">\n");
      out.write("                    $(window).load(function() {\n");
      out.write("                        var aprovado = document.getElementsByName('aprovado');\n");
      out.write("                        var recusado = document.getElementsByName('recusado'); \n");
      out.write("                        var aceite = document.getElementsByName('aceite'); \n");
      out.write("                        var status = \"Aguardando\";\n");
      out.write("                        \n");
      out.write("                        // APROVADO\n");
      out.write("                        for(var i=0;i<aceite.length;i++){\n");
      out.write("                            if (document.getElementsByName(\"aceite\")[i].value != status){\n");
      out.write("                                aprovado[i].disabled=true;\n");
      out.write("                            }\n");
      out.write("                        }\n");
      out.write("                        \n");
      out.write("                        // \n");
      out.write("                        for(var i=0;i<aceite.length;i++){\n");
      out.write("                            if (document.getElementsByName(\"aceite\")[i].value != status){\n");
      out.write("                                recusado[i].disabled=true;\n");
      out.write("                            }\n");
      out.write("                        }\n");
      out.write("                    })\n");
      out.write("                </script>             \n");
      out.write("                \n");
      out.write("                ");
      if (_jspx_meth_c_if_1(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                \n");
      out.write("            </div>\n");
      out.write("        \n");
      out.write("            <input type=\"hidden\" id=\"aguardando\" name=\"aguardando\" value=\"Aguardando\">  \n");
      out.write("            \n");
      out.write("            <form action='alterar' method=\"POST\">    \n");
      out.write("                \n");
      out.write("                \n");
      out.write("                <div class=\"form-group row\" id=\"classeNomeMecanica\" style=\"display:none;\">\n");
      out.write("                    <h3>Dados Mecânica</h3>\n");
      out.write("                    <label for=\"nomeMecanica\" class=\"col-3 col-form-label\">Nome Mecânica:</label>\n");
      out.write("                    <div class=\"col-3\">\n");
      out.write("                        <input class=\"form-control\" type=\"text\" id=\"nomeMecanica\" name=\"nomeMecanica\" >\n");
      out.write("                    </div>\n");
      out.write("                     <label for=\"documentoMecanica\" class=\"col-3 col-form-label\">CNPJ:</label>\n");
      out.write("                    <div class=\"col-3\">\n");
      out.write("                        <input class=\"form-control\" type=\"text\" id=\"documentoMecanica\" name=\"documentoMecanica\" >\n");
      out.write("                    </div>\n");
      out.write("                    <label for=\"telefoneMecanica\" class=\"col-3 col-form-label\">Telefone Mecânica:</label>\n");
      out.write("                    <div class=\"col-3\">\n");
      out.write("                        <input class=\"form-control\" type=\"text\" id=\"telefoneMecanica\" name=\"telefoneMecanica\" >\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                \n");
      out.write("                <div class=\"form-group row\" id=\"classeEnderecoMecanicaCep\" style=\"display:none;\">\n");
      out.write("                    <label for=\"cepMecanica\" class=\"col-3 col-form-label\">CEP:</label>\n");
      out.write("                    <div class=\"col-3\">\n");
      out.write("                        <input class=\"form-control\" type=\"text\" id=\"cepMecanica\" name=\"cepMecanica\" >\n");
      out.write("                    </div>                    \n");
      out.write("                </div>\n");
      out.write("                \n");
      out.write("                <div class=\"form-group row\" id=\"classeEnderecoMecanicaLogradouro\" style=\"display:none;\">\n");
      out.write("                    <label for=\"logradouroMecanica\" class=\"col-3 col-form-label\">Logradouro:</label>\n");
      out.write("                    <div class=\"col-3\">\n");
      out.write("                        <input class=\"form-control\" type=\"text\" id=\"logradouroMecanica\" name=\"logradouroMecanica\" >\n");
      out.write("                    </div> \n");
      out.write("                    <label for=\"numeroMecanica\" class=\"col-3 col-form-label\">Número:</label>\n");
      out.write("                    <div class=\"col-3\">\n");
      out.write("                        <input class=\"form-control\" type=\"text\" id=\"numeroMecanica\" name=\"numeroMecanica\" >\n");
      out.write("                    </div> \n");
      out.write("                </div>\n");
      out.write("                \n");
      out.write("                <div class=\"form-group row\" id=\"classeEnderecoMecanicaBairro\" style=\"display:none;\">\n");
      out.write("                    <label for=\"complementoMecanica\" class=\"col-3 col-form-label\">Complemento:</label>\n");
      out.write("                    <div class=\"col-3\">\n");
      out.write("                        <input class=\"form-control\" type=\"text\" id=\"complementoMecanica\" name=\"complementoMecanica\" >\n");
      out.write("                    </div> \n");
      out.write("                    <label for=\"bairroMecanica\" class=\"col-3 col-form-label\">Bairro:</label>\n");
      out.write("                    <div class=\"col-3\">\n");
      out.write("                        <input class=\"form-control\" type=\"text\" id=\"bairroMecanica\" name=\"bairroMecanica\" >\n");
      out.write("                    </div> \n");
      out.write("                </div>\n");
      out.write("                \n");
      out.write("                <div class=\"form-group row\" id=\"classeEnderecoMecanicaEstado\" style=\"display:none;\">\n");
      out.write("                    \n");
      out.write("                    <label for=\"estadoMecanica\" class=\"col-2 col-form-label\">Estado:</label>\n");
      out.write("                    <div class=\"col-4\">\n");
      out.write("                        <select class=\"form-control\" type=\"text\" id=\"estado\" name=\"estado\" onchange=\"buscaCidades(this.value)\">\n");
      out.write("                            <option value=\"\">Selecione o Estado</option>\n");
      out.write("                            <option value=\"AC\">Acre</option>\n");
      out.write("                            <option value=\"AL\">Alagoas</option>\n");
      out.write("                            <option value=\"AP\">Amapá</option>\n");
      out.write("                            <option value=\"AM\">Amazonas</option>\n");
      out.write("                            <option value=\"BA\">Bahia</option>\n");
      out.write("                            <option value=\"CE\">Ceará</option>\n");
      out.write("                            <option value=\"DF\">Distrito Federal</option>\n");
      out.write("                            <option value=\"ES\">Espírito Santo</option>\n");
      out.write("                            <option value=\"GO\">Goiás</option>\n");
      out.write("                            <option value=\"MA\">Maranhão</option>\n");
      out.write("                            <option value=\"MT\">Mato Grosso</option>\n");
      out.write("                            <option value=\"MS\">Mato Grosso do Sul</option>\n");
      out.write("                            <option value=\"MG\">Minas Gerais</option>\n");
      out.write("                            <option value=\"PA\">Pará</option>\n");
      out.write("                            <option value=\"PB\">Paraíba</option>\n");
      out.write("                            <option value=\"PR\">Paraná</option>\n");
      out.write("                            <option value=\"PE\">Pernambuco</option>\n");
      out.write("                            <option value=\"PI\">Piauí</option>\n");
      out.write("                            <option value=\"RJ\">Rio de Janeiro</option>\n");
      out.write("                            <option value=\"RN\">Rio Grande do Norte</option>\n");
      out.write("                            <option value=\"RS\">Rio Grande do Sul</option>\n");
      out.write("                            <option value=\"RO\">Rondônia</option>\n");
      out.write("                            <option value=\"RR\">Roraima</option>\n");
      out.write("                            <option value=\"SC\">Santa Catarina</option>\n");
      out.write("                            <option value=\"SP\">São Paulo</option>\n");
      out.write("                            <option value=\"SE\">Sergipe</option>\n");
      out.write("                            <option value=\"TO\">Tocantins</option>\n");
      out.write("                        </select>\n");
      out.write("                    </div>\n");
      out.write("  \n");
      out.write("                   \n");
      out.write("                    <label for=\"cidadeMecanica\" class=\"col-2 col-form-label\">Cidade:</label>\n");
      out.write("                    <div class=\"col-4\">\n");
      out.write("                        <select class=\"form-control\" type=\"text\" id=\"cidade\" name=\"cidade\">\n");
      out.write("                        </select>\n");
      out.write("                    </div>\n");
      out.write("                </div>           \n");
      out.write("                \n");
      out.write("                <div class=\"form-group row\" id=\"classeMotivoRecusa\" style=\"display:none;\">\n");
      out.write("                    <label for=\"motivoRecusa\" class=\"col-3 col-form-label\">Motivo Recusa:</label>\n");
      out.write("                    <div class=\"col-5\">\n");
      out.write("                        <input class=\"form-control\" type=\"text\" id=\"motivoRecusa\" name=\"motivoRecusa\" >\n");
      out.write("                    </div>\n");
      out.write("                </div>                 \n");
      out.write("                \n");
      out.write("                   \n");
      out.write("                              \n");
      out.write("                 \n");
      out.write("                \n");
      out.write("                <input type=\"hidden\" id=\"id\" name=\"id\" >\n");
      out.write("                <input type=\"hidden\" id=\"retorno\" name=\"retorno\">\n");
      out.write("            \n");
      out.write("                <br />\n");
      out.write("                <hr>\n");
      out.write("                \n");
      out.write("                <input type=\"hidden\" name=\"operacao\" value=\"ALTERAR\">\n");
      out.write("                <input class=\"btn btn-primary\" type=\"submit\" value=\"Concluir\">\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            $(\"#telefoneMecanica\").mask(\"(00) 00000-0000\");\n");
      out.write("            $(\"#telefoneComercial\").mask(\"(00) 0000-0000\");\n");
      out.write("            $(\"#documento\").mask(\"000.000.000-00\");\n");
      out.write("            $(\"#cep\").mask(\"00000-000\");\n");
      out.write("            $(\"#cepSec\").mask(\"00000-000\");\n");
      out.write("            $(\"#dataNascimento\").mask(\"00/00/0000\");\n");
      out.write("        </script>\n");
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
    _jspx_th_c_forEach_0.setVar("sinistro");
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${resultado}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                            <tr>\n");
          out.write("                                <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sinistro.cliente.nome}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                                <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sinistro.cliente.documento}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>                                \n");
          out.write("                                <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sinistro.veiculo.modelo}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td> \n");
          out.write("                                <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sinistro.veiculo.placa}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td> \n");
          out.write("                                <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sinistro.tipo}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td> \n");
          out.write("                                <td><a href=\"../");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sinistro.comprovanteDocumento}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" target=\"_blank\" download=\"ComprovanteDocumento.png\">Visualizar</a></td>\n");
          out.write("                                <td><a href=\"../");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sinistro.comprovanteEndereco}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" target=\"_blank\" download=\"ComprovanteEndereco.png\">Visualizar</a></td>\n");
          out.write("                                <td><a href=\"../");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sinistro.comprovanteCRVL}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" target=\"_blank\" download=\"ComprovanteCRVL.png\">Visualizar</a></td>\n");
          out.write("                                <td><a href=\"../");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sinistro.comprovanteCNH}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" target=\"_blank\" download=\"ComprovanteCNH.png\">Visualizar</a></td>\n");
          out.write("                                <td><a href=\"../");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sinistro.comprovanteBO}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" target=\"_blank\" download=\"ComprovanteBO.png\">Visualizar</a></td>\n");
          out.write("                                <td><input type=\"hidden\" id=\"aceite\" name=\"aceite\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sinistro.aceite}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write('"');
          out.write('>');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sinistro.aceite}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>                                 \n");
          out.write("                                <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sinistro.descricao}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td> \n");
          out.write("                                <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sinistro.dataAceiteRecusa}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td> \n");
          out.write("                                <td><input type=\"radio\" name=\"aprovado\" id=\"aprovado\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sinistro.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\"></td>\n");
          out.write("                                <td><input type=\"radio\" name=\"recusado\" id=\"recusado\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sinistro.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\"></td>   \n");
          out.write("                                \n");
          out.write("                                <td><input type=\"hidden\" id=\"idSinistro\" name=\"idSinistro\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sinistro.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\"></td> \n");
          out.write("                                <td><a href=\"excluir?id=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sinistro.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("&operacao=EXCLUIR&tipo=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sinistro.tipo}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\"><input class=\"btn btn-danger\" type=\"button\" value=\"Finalizar\"></a></td>\n");
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
