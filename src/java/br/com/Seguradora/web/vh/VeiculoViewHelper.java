package br.com.Seguradora.web.vh;

import br.com.Seguradora.core.fachada.Resultado;
import br.com.Seguradora.dominio.Apolice;
import br.com.Seguradora.dominio.Cliente;
import br.com.Seguradora.dominio.EntidadeDominio;
import br.com.Seguradora.dominio.Veiculo;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VeiculoViewHelper implements IViewHelper{
    
    Veiculo veiculo;
    Cliente cliente;
    Apolice apolice;
    
    public EntidadeDominio getEntidade(HttpServletRequest request) {
        //Recebe operação do formulário, na request.
        String operacao = request.getParameter("operacao");

        if (operacao.equals("SALVAR")) {
          
                veiculo = new Veiculo();
                cliente = new Cliente();
                apolice = new Apolice();
                
                String marca = request.getParameter("marca");
                String modelo = request.getParameter("modelo");
                String placa = request.getParameter("placa");
                String chassi = request.getParameter("chassi");
                String anoFabricacao = request.getParameter("anoFabricacao");
                String anoModelo = request.getParameter("anoModelo");
                String documento = request.getParameter("documento");
                String numeroApolice = request.getParameter("apolice");
                String frota = request.getParameter("frota");
                //Byte imagem = Byte.valueOf(request.getParameter("imagem"));
                                
                
                veiculo.setOperacao(operacao);
                
                if (marca != null && !marca.trim().equals("")) {
                    veiculo.setMarca(marca);
                }
                if (modelo != null && !modelo.trim().equals("")) {
                    veiculo.setModelo(modelo);
                }
                if (placa != null && !placa.trim().equals("")) {
                    veiculo.setPlaca(placa);
                }
                if (chassi != null && !chassi.trim().equals("")) {
                    veiculo.setChassi(chassi);
                }
                if (anoFabricacao != null && !anoFabricacao.trim().equals("")) {
                    veiculo.setAnoFabricacao(anoFabricacao);
                }
                if (anoModelo != null && !anoModelo.trim().equals("")) {
                    veiculo.setAnoModelo(anoModelo);
                }
                if (documento != null && !documento.trim().equals("")) {
                    cliente.setDocumento(documento);
                }
                if (numeroApolice != null && !numeroApolice.trim().equals("")) {
                    apolice.setNumeroApolice(numeroApolice);
                }
                if (frota != null && !frota.trim().equals("")) {
                    veiculo.setNumeroFrota(frota);
                }/*
                if (imagem != null) {
                    veiculo.setImage_data(imagem);
                }*/
                
                veiculo.setCliente(cliente);
                veiculo.setApolice(apolice);
                return veiculo;
           
            
        }
        
        
        if (operacao.equals("CONSULTAR")) {

            String op = request.getParameter("operacao");
            veiculo = new Veiculo();
            if (op != null && !"".equals(op)) {

                veiculo.setId(Integer.parseInt(request.getParameter("id")));

                return veiculo;

            } else {
                veiculo = new Veiculo();

                return veiculo;
            }
        }

        if (operacao.equals("LISTARFILTRO")){
            veiculo = new Veiculo();
            cliente = new Cliente();
            apolice = new Apolice();
            
            String marca = request.getParameter("marca");
            String modelo = request.getParameter("modelo");
            String placa = request.getParameter("placa");
            String chassi = request.getParameter("chassi");
            String anoFabricacao = request.getParameter("anoFabricacao");
            String anoModelo = request.getParameter("anoModelo");
            String documento = request.getParameter("documento");
            String numeroApolice = request.getParameter("apolice");
            String frota = request.getParameter("frota");
            
            veiculo.setOperacao(operacao);
            
            if (marca != null && !marca.trim().equals("")) {
                veiculo.setMarca(marca);
            }
            if (modelo != null && !modelo.trim().equals("")) {
                veiculo.setModelo(modelo);
            }
            if (placa != null && !placa.trim().equals("")) {
                veiculo.setPlaca(placa);
            }
            if (chassi != null && !chassi.trim().equals("")) {
                veiculo.setChassi(chassi);
            }
            if (anoFabricacao != null && !anoFabricacao.trim().equals("")) {
                veiculo.setAnoFabricacao(anoFabricacao);
            }
            if (anoModelo != null && !anoModelo.trim().equals("")) {
                veiculo.setAnoModelo(anoModelo);
            }
            if (documento != null && !documento.trim().equals("")) {
                cliente.setDocumento(documento);
            }
            if (numeroApolice != null && !numeroApolice.trim().equals("")) {
                apolice.setNumeroApolice(numeroApolice);
            }
            if (frota != null && !frota.trim().equals("")) {
                veiculo.setNumeroFrota(frota);
            }
            
            veiculo.setCliente(cliente);
            veiculo.setApolice(apolice);            
            return veiculo;
        }
        
        String uri = request.getRequestURI();
        if (uri.equals("/Seguradora/veiculo/preAtualizar")) {
            operacao = "PREATUALIZAR";
        }
        if (operacao.equals("EXCLUIR")) {

            veiculo = new Veiculo();
            veiculo.setId(Integer.parseInt(request.getParameter("id")));
            String status = request.getParameter("opStatus");
            if (status != null && status.trim().equals("")) {
                if ("1".equals(status)) {
                    veiculo.setStatus(1);
                }
            }

            return veiculo;

        }
        
        if (operacao.equals("PREATUALIZAR")) {
            veiculo = new Veiculo();

            String id = request.getParameter("id");

            if (id != null && !id.trim().equals("")) {

                veiculo.setId(Integer.parseInt(id));

                return veiculo;

            } else {

                return veiculo;
            }
        } // PREATUALIZAR
        
        
        if (operacao.equals("ALTERAR")){
            veiculo = new Veiculo();
            cliente = new Cliente();
            apolice = new Apolice();
            
            String marca = request.getParameter("marca");
            String modelo = request.getParameter("modelo");
            String placa = request.getParameter("placa");
            String chassi = request.getParameter("chassi");
            String anoFabricacao = request.getParameter("anoFabricacao");
            String anoModelo = request.getParameter("anoModelo");
            String documento = request.getParameter("documento");
            String numeroApolice = request.getParameter("apolice");
            String frota = request.getParameter("frota");
            String id = request.getParameter("idVeiculo");
            
            veiculo.setOperacao(operacao);
            veiculo.setId(Integer.parseInt(id));
            
            if (marca != null && !marca.trim().equals("")) {
                veiculo.setMarca(marca);
            }
            if (modelo != null && !modelo.trim().equals("")) {
                veiculo.setModelo(modelo);
            }
            if (placa != null && !placa.trim().equals("")) {
                veiculo.setPlaca(placa);
            }
            if (chassi != null && !chassi.trim().equals("")) {
                veiculo.setChassi(chassi);
            }
            if (anoFabricacao != null && !anoFabricacao.trim().equals("")) {
                veiculo.setAnoFabricacao(anoFabricacao);
            }
            if (anoModelo != null && !anoModelo.trim().equals("")) {
                veiculo.setAnoModelo(anoModelo);
            }
            if (documento != null && !documento.trim().equals("")) {
                cliente.setDocumento(documento);
            }
            if (numeroApolice != null && !numeroApolice.trim().equals("")) {
                apolice.setNumeroApolice(numeroApolice);
            }
            if (frota != null && !frota.trim().equals("")) {
                veiculo.setNumeroFrota(frota);
            }
            
            veiculo.setCliente(cliente);
            veiculo.setApolice(apolice);            
            return veiculo;
        }
        
        return veiculo;
        
    }		

    @Override
    public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher rd = null;

        //Recebe operação do formulário, na request.
        String operacao = request.getParameter("operacao");

        if (operacao.equals("SALVAR")) {

            if (resultado.getMsg() != null) {
                request.getSession().setAttribute("mensagem", resultado.getMsg());
                rd = request.getRequestDispatcher("cadastrarVeiculo.jsp");

            } else {

                request.getSession().setAttribute("resultado", resultado.getEntidades());
                //request.getSession().setAttribute("auditoria", resultado.getEntidade());
                rd = request.getRequestDispatcher("paginaVeiculo.jsp");
            }
        }

        if (operacao.equals("ALTERAR")) {
            if (resultado.getMsg() != null) {
                request.getSession().setAttribute("mensagem", resultado.getMsg());
                request.getSession().setAttribute("resultado", resultado.getEntidades());
                rd = request.getRequestDispatcher("atualizarVeiculo.jsp");

            } else {

                request.getSession().setAttribute("resultado", resultado.getEntidades());
                //request.getSession().setAttribute("auditoria", resultado.getEntidade());
                rd = request.getRequestDispatcher("paginaVeiculo.jsp");
            }
        }

        if (operacao.equals("CONSULTAR")) {

            if (resultado.getMsg() != null) {
                request.getSession().setAttribute("mensagem", resultado.getMsg());
                rd = request.getRequestDispatcher("consultarVeiculo.jsp");

            } else {
                request.getSession().setAttribute("resultado", resultado.getEntidades());
                rd = request.getRequestDispatcher("consultarVeiculo.jsp");
            }

        } //fim consultar

        if (operacao.equals("LISTARFILTRO")) {

            if (resultado.getMsg() != null) {
                request.getSession().setAttribute("mensagem", resultado.getMsg());
                rd = request.getRequestDispatcher("consultarVeiculo.jsp");

            } else {
                
                request.getSession().setAttribute("resultado", resultado.getEntidades());
                rd = request.getRequestDispatcher("consultarVeiculo.jsp");
            }

        } //fim consultar

        if (operacao.equals("PREATUALIZAR")) {

            if (resultado.getMsg() != null) {
                request.getSession().setAttribute("mensagem", resultado.getMsg());

                rd = request.getRequestDispatcher("consultarVeiculo.jsp");

            } else {
                request.getSession().setAttribute("resultado", resultado.getEntidades());

                rd = request.getRequestDispatcher("atualizarVeiculo.jsp");
            }

        } //fim consultar

        if (operacao.equals("EXCLUIR")) {
            if (resultado.getMsg() != null) {
                request.getSession().setAttribute("mensagem", resultado.getMsg());

                rd = request.getRequestDispatcher("consultarVeiculo.jsp");

            } else {
                request.getSession().setAttribute("resultado", resultado.getEntidade());

                rd = request.getRequestDispatcher("consultarVeiculo.jsp");
            }
        }

        rd.forward(request, response);
    }

}


