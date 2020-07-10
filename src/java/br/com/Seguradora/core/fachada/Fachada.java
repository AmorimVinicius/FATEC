package br.com.Seguradora.core.fachada;

import br.com.Seguradora.core.dao.ApoliceDAO;
import br.com.Seguradora.core.dao.CausasNaturaisDAO;
import br.com.Seguradora.core.dao.ClienteDAO;
import br.com.Seguradora.core.dao.ClienteJuridicoDAO;
import br.com.Seguradora.core.dao.ClienteTerceiroDAO;
import br.com.Seguradora.core.dao.ColisaoDAO;
import br.com.Seguradora.core.dao.CorretorDAO;
import br.com.Seguradora.core.dao.EnderecoDAO;
import br.com.Seguradora.core.dao.FurtoRouboDAO;
import br.com.Seguradora.core.dao.GraficoDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.Seguradora.core.dao.IDAO;
import br.com.Seguradora.core.dao.IncendioDAO;
import br.com.Seguradora.core.dao.LoginDAO;
import br.com.Seguradora.core.dao.MecanicaDAO;
import br.com.Seguradora.core.negocio.IStrategy;
import br.com.Seguradora.core.dao.SinistroDAO;
import br.com.Seguradora.core.dao.VeiculoDAO;
import br.com.Seguradora.core.negocio.DadosObrigatoriosApolice;
import br.com.Seguradora.core.negocio.DadosObrigatoriosCausasNaturais;
import br.com.Seguradora.core.negocio.DadosObrigatoriosCliente;
import br.com.Seguradora.core.negocio.DadosObrigatoriosClienteJuridico;
import br.com.Seguradora.core.negocio.DadosObrigatoriosClienteTerceiro;
import br.com.Seguradora.core.negocio.DadosObrigatoriosColisao;
import br.com.Seguradora.core.negocio.DadosObrigatoriosCorretor;
import br.com.Seguradora.core.negocio.DadosObrigatoriosFurtoRoubo;
import br.com.Seguradora.core.negocio.DadosObrigatoriosGrafico;
import br.com.Seguradora.core.negocio.DadosObrigatoriosIncendio;
import br.com.Seguradora.core.negocio.DadosObrigatoriosLogin;
import br.com.Seguradora.core.negocio.DadosObrigatoriosMecanica;
import br.com.Seguradora.core.negocio.DadosObrigatoriosSinistro;
import br.com.Seguradora.core.negocio.DadosObrigatoriosVeiculo;
import br.com.Seguradora.dominio.Apolice;
import br.com.Seguradora.dominio.CausasNaturais;
import br.com.Seguradora.dominio.Cliente;
import br.com.Seguradora.dominio.ClienteJuridico;
import br.com.Seguradora.dominio.ClienteTerceiro;
import br.com.Seguradora.dominio.Colisao;
import br.com.Seguradora.dominio.Corretor;
import br.com.Seguradora.dominio.Endereco;
import br.com.Seguradora.dominio.EntidadeDominio;
import br.com.Seguradora.dominio.FurtoRoubo;
import br.com.Seguradora.dominio.Grafico;
import br.com.Seguradora.dominio.Incendio;
import br.com.Seguradora.dominio.Login;
import br.com.Seguradora.dominio.Mecanica;
import br.com.Seguradora.dominio.Sinistro;
import br.com.Seguradora.dominio.Veiculo;

public class Fachada implements IFachada {

	private Map<String, IDAO> daos;

	private Map<String, Map<String, List<IStrategy>>> rns;
	
	private Resultado resultado;
	
	public Fachada(){
	
        daos = new HashMap<String, IDAO>();
	rns = new HashMap<String, Map<String, List<IStrategy>>>();
	
        //ProdutoDAO proDAO = new ProdutoDAO();
        EnderecoDAO enderecoDAO = new EnderecoDAO();
        ClienteJuridicoDAO cliJurDAO = new ClienteJuridicoDAO();
        VeiculoDAO veiculoDAO = new VeiculoDAO();
        ClienteDAO clienteDAO = new ClienteDAO();
        CorretorDAO corretorDAO = new CorretorDAO();
        ApoliceDAO apoliceDAO = new ApoliceDAO();
        SinistroDAO sinistroDAO = new SinistroDAO();
        FurtoRouboDAO furtoRouboDAO = new FurtoRouboDAO();
        IncendioDAO incendioDAO = new IncendioDAO();
        CausasNaturaisDAO causasNaturaisDAO = new CausasNaturaisDAO();
        ClienteTerceiroDAO clienteTerceiroDAO = new ClienteTerceiroDAO();
        ColisaoDAO colisaoDAO = new ColisaoDAO();
        MecanicaDAO mecanicaDAO = new MecanicaDAO();
        GraficoDAO graficoDAO = new GraficoDAO();
        LoginDAO loginDAO = new LoginDAO();
		
	//daos.put(Produto.class.getName(), proDAO);
        daos.put(ClienteJuridico.class.getName(), cliJurDAO);
        daos.put(Veiculo.class.getName(), veiculoDAO);
        daos.put(Cliente.class.getName(), clienteDAO);
        daos.put(Endereco.class.getName(), enderecoDAO);
        daos.put(Corretor.class.getName(), corretorDAO);
        daos.put(Apolice.class.getName(), apoliceDAO);
        daos.put(Sinistro.class.getName(), sinistroDAO);
        daos.put(FurtoRoubo.class.getName(), furtoRouboDAO);
        daos.put(Incendio.class.getName(), incendioDAO);
        daos.put(CausasNaturais.class.getName(), causasNaturaisDAO);
        daos.put(ClienteTerceiro.class.getName(), clienteTerceiroDAO);
        daos.put(Colisao.class.getName(), colisaoDAO);
        daos.put(Mecanica.class.getName(), mecanicaDAO);
        daos.put(Grafico.class.getName(), graficoDAO);
        daos.put(Login.class.getName(), loginDAO);
        
        // aplicar regras de negócio
	//ValidadorQtdeProduto vQtd = new ValidadorQtdeProduto();
	DadosObrigatoriosClienteJuridico dadosObrigatoriosCliJur = new DadosObrigatoriosClienteJuridico();
        DadosObrigatoriosVeiculo dadosObrigatoriosVeiculo = new DadosObrigatoriosVeiculo();
        DadosObrigatoriosCliente dadosObrigadoriosCliente = new DadosObrigatoriosCliente();
        DadosObrigatoriosCorretor dadosObrigatoriosCorretor = new DadosObrigatoriosCorretor();
        DadosObrigatoriosApolice dadosObrigatoriosApolice = new DadosObrigatoriosApolice();
        DadosObrigatoriosSinistro dadosObrigatoriosSinistro  = new DadosObrigatoriosSinistro();
        DadosObrigatoriosFurtoRoubo dadosObrigatoriosFurtoRoubo = new DadosObrigatoriosFurtoRoubo();
        DadosObrigatoriosIncendio dadosObrigatoriosIncendio = new DadosObrigatoriosIncendio();
        DadosObrigatoriosCausasNaturais dadosObrigatoriosCausasNaturais = new DadosObrigatoriosCausasNaturais();
        DadosObrigatoriosClienteTerceiro dadosObrigatoriosClienteTerceiro = new DadosObrigatoriosClienteTerceiro();
        DadosObrigatoriosColisao dadosObrigatoriosColisao = new DadosObrigatoriosColisao();
        DadosObrigatoriosMecanica dadosObrigatoriosMecanica = new DadosObrigatoriosMecanica();
        DadosObrigatoriosGrafico dadosObrigatoriosGrafico = new DadosObrigatoriosGrafico();
        DadosObrigatoriosLogin dadosObrigatoriosLogin = new DadosObrigatoriosLogin();
        //DadosObrigatoriosEndereco dadosObrigatoriosEnd = new DadosObrigatoriosEndereco();
        
        
        // Array para SALVAR  
	//List<IStrategy> rnsSalvarProduto = new ArrayList<IStrategy>();
        List<IStrategy> rnsSalvarClienteJuridico = new ArrayList<IStrategy>();
        List<IStrategy> rnsSalvarVeiculo = new ArrayList<IStrategy>();
        List<IStrategy> rnsSalvarCliente = new ArrayList<IStrategy>();
        List<IStrategy> rnsSalvarCorretor = new ArrayList<IStrategy>();
        List<IStrategy> rnsSalvarApolice = new ArrayList<IStrategy>();
        List<IStrategy> rnsSalvarSinistro = new ArrayList<IStrategy>();
        List<IStrategy> rnsSalvarFurtoRoubo = new ArrayList<IStrategy>();
        List<IStrategy> rnsSalvarIncendio = new ArrayList<IStrategy>();
        List<IStrategy> rnsSalvarCausasNaturais = new ArrayList<IStrategy>();
        List<IStrategy> rnsSalvarClienteTerceiro = new ArrayList<IStrategy>();
        List<IStrategy> rnsSalvarColisao = new ArrayList<IStrategy>();
        List<IStrategy> rnsSalvarMecanica = new ArrayList<IStrategy>();
        List<IStrategy> rnsSalvarLogin = new ArrayList<IStrategy>();
                
        // Array para ALTERAR 
        List<IStrategy> rnsAlterarClienteJuridico = new ArrayList<IStrategy>();
        List<IStrategy> rnsAlterarVeiculo = new ArrayList<IStrategy>();
        List<IStrategy> rnsAlterarCliente = new ArrayList<IStrategy>();
        List<IStrategy> rnsAlterarCorretor = new ArrayList<IStrategy>();
        List<IStrategy> rnsAlterarApolice = new ArrayList<IStrategy>();
        List<IStrategy> rnsAlterarSinistro = new ArrayList<IStrategy>();
        List<IStrategy> rnsAlterarFurtoRoubo = new ArrayList<IStrategy>();
        List<IStrategy> rnsAlterarIncendio = new ArrayList<IStrategy>();
        List<IStrategy> rnsAlterarCausasNaturais = new ArrayList<IStrategy>();
        List<IStrategy> rnsAlterarClienteTerceiro = new ArrayList<IStrategy>();
        List<IStrategy> rnsAlterarColisao = new ArrayList<IStrategy>();
        List<IStrategy> rnsAlterarMecanica = new ArrayList<IStrategy>();
        
        
        // Array para LISTAR
        List<IStrategy> rnsListarIncendio = new ArrayList<IStrategy>();
        List<IStrategy> rnsListarFurtoRoubo = new ArrayList<IStrategy>();
        List<IStrategy> rnsListarCausasNaturais = new ArrayList<IStrategy>();
        List<IStrategy> rnsListarColisao = new ArrayList<IStrategy>();
        List<IStrategy> rnsListarGrafico = new ArrayList<IStrategy>();
        //List<IStrategy> rnsListarMecanica = new ArrayList<IStrategy>();
        //rnsSalvarProduto.add(vQtd);
        
        // Array para EXCLUIR
        List<IStrategy> rnsExcluirApolice = new ArrayList<IStrategy>();
        
        
        // Array para AUTENTICAR
        List<IStrategy> rnsAutenticarCliente = new ArrayList<IStrategy>();
        List<IStrategy> rnsAutenticarCorretor = new ArrayList<IStrategy>();
        List<IStrategy> rnsAutenticarLogin = new ArrayList<IStrategy>();
	
        // Dados CLIENTE_JURIDICO
        rnsSalvarClienteJuridico.add(dadosObrigatoriosCliJur);
        rnsAlterarClienteJuridico.add(dadosObrigatoriosCliJur);
        rnsSalvarCliente.add(dadosObrigadoriosCliente);
        rnsAlterarCliente.add(dadosObrigadoriosCliente);
        rnsAutenticarCliente.add(dadosObrigadoriosCliente);
        //rnsSalvarClienteJuridico.add(dadosObrigatoriosEnd);
        
        
        
        // Dados VEICULO
        rnsSalvarVeiculo.add(dadosObrigatoriosVeiculo);        
        rnsAlterarVeiculo.add(dadosObrigatoriosVeiculo);
        
        
        // Dados CORRETOR
        rnsSalvarCorretor.add(dadosObrigatoriosCorretor);
        rnsAlterarCorretor.add(dadosObrigatoriosCorretor);
        rnsAutenticarCorretor.add(dadosObrigatoriosCorretor);
        
        
        // Dados APOLICE
        rnsSalvarApolice.add(dadosObrigatoriosApolice);
        rnsAlterarApolice.add(dadosObrigatoriosApolice);
        rnsExcluirApolice.add(dadosObrigatoriosApolice);
        
        
        // Dados SINISTRO
        rnsSalvarSinistro.add(dadosObrigatoriosSinistro);
        rnsAlterarSinistro.add(dadosObrigatoriosSinistro);
        
        
        // Dados FURTO E ROUBO
        rnsSalvarFurtoRoubo.add(dadosObrigatoriosFurtoRoubo);
        rnsAlterarFurtoRoubo.add(dadosObrigatoriosFurtoRoubo);
        rnsListarFurtoRoubo.add(dadosObrigatoriosFurtoRoubo);
        
        
        // Dados INCENDIO
        rnsSalvarIncendio.add(dadosObrigatoriosIncendio);
        rnsAlterarIncendio.add(dadosObrigatoriosIncendio);
        rnsListarIncendio.add(dadosObrigatoriosIncendio);
        
        // Dados CAUSAS NATURAIS
        rnsSalvarCausasNaturais.add(dadosObrigatoriosCausasNaturais);
        rnsAlterarCausasNaturais.add(dadosObrigatoriosCausasNaturais);
        rnsListarCausasNaturais.add(dadosObrigatoriosCausasNaturais);
        
        // Dados CLIENTE TERCEIRO
        rnsSalvarClienteTerceiro.add(dadosObrigatoriosClienteTerceiro);
        rnsAlterarClienteTerceiro.add(dadosObrigatoriosClienteTerceiro);
        
        
        // Dados COLISAO
        rnsSalvarColisao.add(dadosObrigatoriosColisao);
        rnsAlterarColisao.add(dadosObrigatoriosColisao);
        rnsListarColisao.add(dadosObrigatoriosColisao);
        
        
        // Dados MECANICA
        rnsSalvarMecanica.add(dadosObrigatoriosMecanica);
        rnsAlterarMecanica.add(dadosObrigatoriosMecanica);
        //rnsListarMecanica.add(dadosObrigatoriosMecanica);
        
        
        // Dados GRAFICO
        rnsListarGrafico.add(dadosObrigatoriosGrafico);
        
        
        // Dados LOGIN
        rnsSalvarLogin.add(dadosObrigatoriosLogin);
        rnsAutenticarLogin.add(dadosObrigatoriosLogin);
		
	//Map<String, List<IStrategy>> rnsProduto = new HashMap<String, List<IStrategy>>();
        Map<String, List<IStrategy>> rnsClienteJuridico = new HashMap<String, List<IStrategy>>();
        Map<String, List<IStrategy>> rnsVeiculo = new HashMap<String, List<IStrategy>>();
        Map<String, List<IStrategy>> rnsCliente = new HashMap<String, List<IStrategy>>();
	Map<String, List<IStrategy>> rnsCorretor = new HashMap<String, List<IStrategy>>();
        Map<String, List<IStrategy>> rnsApolice = new HashMap<String, List<IStrategy>>();
        Map<String, List<IStrategy>> rnsSinistro = new HashMap<String, List<IStrategy>>();
        Map<String, List<IStrategy>> rnsFurtoRoubo = new HashMap<String, List<IStrategy>>();
        Map<String, List<IStrategy>> rnsIncendio = new HashMap<String, List<IStrategy>>();
        Map<String, List<IStrategy>> rnsCausasNaturais = new HashMap<String, List<IStrategy>>();
        Map<String, List<IStrategy>> rnsClienteTerceiro = new HashMap<String, List<IStrategy>>();
        Map<String, List<IStrategy>> rnsColisao = new HashMap<String, List<IStrategy>>();
        Map<String, List<IStrategy>> rnsMecanica = new HashMap<String, List<IStrategy>>();
        Map<String, List<IStrategy>> rnsGrafico = new HashMap<String, List<IStrategy>>();
        Map<String, List<IStrategy>> rnsLogin = new HashMap<String, List<IStrategy>>();
        //rnsProduto.put("SALVAR", rnsSalvarProduto);
        
        rnsClienteJuridico.put("SALVAR", rnsSalvarClienteJuridico);
        rnsClienteJuridico.put("ALTERAR", rnsAlterarClienteJuridico);
        
        rnsVeiculo.put("SALVAR", rnsSalvarVeiculo);
        rnsVeiculo.put("ALTERAR", rnsAlterarVeiculo);
        
        rnsCliente.put("SALVAR", rnsSalvarCliente);
        rnsCliente.put("ALTERAR", rnsAlterarCliente);
        rnsCliente.put("AUTENTICAR", rnsAutenticarCliente);
        
        rnsCorretor.put("SALVAR", rnsSalvarCorretor);
        rnsCorretor.put("ALTERAR", rnsAlterarCorretor);
        rnsCorretor.put("AUTENTICAR", rnsAutenticarCorretor);
        
        rnsApolice.put("SALVAR", rnsSalvarApolice);
        rnsApolice.put("ALTERAR", rnsAlterarApolice);
        rnsApolice.put("EXCLUIR", rnsExcluirApolice);
        
        rnsSinistro.put("SALVAR", rnsSalvarSinistro);
        rnsSinistro.put("ALTERAR", rnsAlterarSinistro);
        
        rnsFurtoRoubo.put("SALVAR", rnsSalvarFurtoRoubo);
        rnsFurtoRoubo.put("ALTERAR", rnsAlterarFurtoRoubo);
        rnsFurtoRoubo.put("LISTARFILTRO", rnsListarFurtoRoubo);
        
        rnsIncendio.put("SALVAR", rnsSalvarIncendio);
        rnsIncendio.put("LISTARFILTRO", rnsListarIncendio);
        rnsIncendio.put("ALTERAR", rnsAlterarIncendio);
        
        rnsCausasNaturais.put("SALVAR", rnsSalvarCausasNaturais);
        rnsCausasNaturais.put("ALTERAR", rnsAlterarCausasNaturais);
        rnsCausasNaturais.put("LISTARFILTRO", rnsListarCausasNaturais);
        
        rnsClienteTerceiro.put("SALVAR", rnsSalvarClienteTerceiro);
        rnsClienteTerceiro.put("ALTERAR", rnsAlterarClienteTerceiro);
        
        rnsColisao.put("SALVAR", rnsSalvarColisao);
        rnsColisao.put("ALTERAR", rnsAlterarColisao);
        rnsColisao.put("LISTARFILTRO", rnsListarColisao);
        
        
        rnsMecanica.put("SALVAR", rnsSalvarMecanica);
        rnsMecanica.put("ALTERAR", rnsAlterarMecanica);
        //rnsMecanica.put("LISTARFILTRO", rnsListarMecanica);
        
        
        rnsGrafico.put("LISTARFILTRO", rnsListarGrafico);
        
        
        rnsLogin.put("SALVAR", rnsSalvarLogin);
        rnsLogin.put("AUTENTICAR", rnsAutenticarLogin);
	
	/* Adiciona o mapa(criado na linha 129) com as regras indexadas pelas opera��es no mapa geral indexado 
	* pelo nome da entidade. Observe que este mapa (rns) � o mesmo utilizado na linha 88.
	 */
	//rns.put(Produto.class.getName(), rnsProduto);
        rns.put(ClienteJuridico.class.getName(), rnsClienteJuridico);
        //rns.put(Endereco.class.getName(), rnsClienteJuridico);
        rns.put(Veiculo.class.getName(), rnsVeiculo);
        rns.put(Cliente.class.getName(), rnsCliente);
        rns.put(Corretor.class.getName(), rnsCorretor);
        rns.put(Apolice.class.getName(), rnsApolice);
        rns.put(Sinistro.class.getName(), rnsSinistro);
        rns.put(FurtoRoubo.class.getName(), rnsFurtoRoubo);
        rns.put(Incendio.class.getName(), rnsIncendio);
        rns.put(CausasNaturais.class.getName(), rnsCausasNaturais);
        rns.put(ClienteTerceiro.class.getName(), rnsClienteTerceiro);
        rns.put(Colisao.class.getName(), rnsColisao);
        rns.put(Mecanica.class.getName(), rnsMecanica);
        rns.put(Grafico.class.getName(), rnsGrafico);
        rns.put(Login.class.getName(), rnsLogin);
        
	}
	
	
	@Override
	public Resultado salvar(EntidadeDominio entidade) {
		resultado = new Resultado();
		String nmClasse = entidade.getClass().getName();	
		
		String msg = executarRegras(entidade, "SALVAR");
		
		
		if(msg == null){
			IDAO dao = daos.get(nmClasse);
			try {
				dao.salvar(entidade);
				List<EntidadeDominio> entidades = new ArrayList<EntidadeDominio>();
				entidades.add(entidade);
				resultado.setEntidades(entidades);
			} catch (SQLException e) {
				e.printStackTrace();
				resultado.setMsg("Nao foi possivel realizar o registro!");
				
			}
		}else{
			resultado.setMsg(msg);
					
			
		}
		
		return resultado;
	}

    @Override
    public Resultado alterar(EntidadeDominio entidade) {
       resultado = new Resultado();
		String nmClasse = entidade.getClass().getName();	
		
		String msg = executarRegras(entidade, "ALTERAR");
		
		
		if(msg == null){
			IDAO dao = daos.get(nmClasse);
			try {
				dao.alterar(entidade);
				List<EntidadeDominio> entidades = new ArrayList<EntidadeDominio>();
				entidades.add(entidade);
				resultado.setEntidades(entidades);
			} catch (SQLException e) {
				e.printStackTrace();
				resultado.setMsg("Nao foi possivel realizar o registro!");
				
			}
		}else{
			resultado.setMsg(msg);
					
			
		}
		
		return resultado;
	}

    @Override
    public Resultado excluir(EntidadeDominio entidade) {
         resultado = new Resultado();
		String nmClasse = entidade.getClass().getName();	
		
		String msg = executarRegras(entidade, "EXCLUIR");
		
		
		if(msg == null){
			IDAO dao = daos.get(nmClasse);
			try {
				dao.excluir(entidade);
				List<EntidadeDominio> entidades = new ArrayList<EntidadeDominio>();
				entidades.add(entidade);
				resultado.setEntidades(entidades);
			} catch (SQLException e) {
				e.printStackTrace();
				resultado.setMsg("Nao foi possivel realizar o registro!");
				
			}
		}else{
			resultado.setMsg(msg);
					
			
		}
		
		return resultado;
	}

    @Override
    public Resultado consultar(EntidadeDominio entidade) {
        resultado = new Resultado();

        String nmClasse = entidade.getClass().getName();

        //String msg = executarRegras(entidade, "CONSULTAR");
        //if(msg == null){
        IDAO dao = daos.get(nmClasse);
        try {

            resultado.setEntidades(dao.consultar(entidade));
        } catch (SQLException e) {
            e.printStackTrace();
            resultado.setMsg("Não foi possível realizar a consulta!");

        }
        //}else{
        //	resultado.setMsg(msg);

        //}
        return resultado;

    }

    @Override
    public Resultado visualizar(EntidadeDominio entidade) {
        resultado = new Resultado();
        resultado.setEntidades(new ArrayList<>(1));
        resultado.getEntidades().add(entidade);
        return resultado;
    }
    
    private String executarRegras(EntidadeDominio entidade, String operacao){
		String nmClasse = entidade.getClass().getName();		
		StringBuilder msg = new StringBuilder();
		
		Map<String, List<IStrategy>> regrasOperacao = rns.get(nmClasse);
		
		
		if(regrasOperacao != null){
			List<IStrategy> regras = regrasOperacao.get(operacao);
			
			if(regras != null){
				for(IStrategy s: regras){			
					String m = s.processar(entidade);			
					
					if(m != null){
						msg.append(m);
						msg.append("\n");
					}			
				}	
			}			
			
		}
		
		if(msg.length()>0)
			return msg.toString();
		else
			return null;
	}

    @Override
    public Resultado listarfiltro(EntidadeDominio entidade) {
        resultado = new Resultado();

        String nomeClasse = entidade.getClass().getName();
        String mensagem = executarRegras(entidade, "LISTARFILTRO");

        if(mensagem == null){
            IDAO dao = daos.get(nomeClasse); // presta atencao aqui!!!

            try {
                resultado.setEntidades(dao.filtrar(entidade));

            } catch (Exception e) {
                e.printStackTrace();
                resultado.setMsg("Não foi possível realizar a consulta.");
            } //fim try/catch
        } else {
        	resultado.setMsg(mensagem);
        } // fim if

        return resultado;
    }

    @Override
    public Resultado continuar(EntidadeDominio entidade) {
        resultado = new Resultado();

        String nomeClasse = entidade.getClass().getName();
        IDAO dao = daos.get(nomeClasse);

        try {
            resultado.setEntidades(dao.continuar(entidade));

        } catch (Exception e) {
            e.printStackTrace();
            resultado.setMsg("Não foi possível realizar a consulta.");
        } 
        return resultado;
    }

    @Override
    public Resultado selecionar(EntidadeDominio entidade) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Resultado autenticar(EntidadeDominio entidade) {
        resultado = new Resultado();

        String nomeClasse = entidade.getClass().getName();
        String mensagem = executarRegras(entidade, "AUTENTICAR");

        if(mensagem == null){
            IDAO dao = daos.get(nomeClasse); // presta atencao aqui!!!

            try {
                resultado.setEntidades(dao.filtrar(entidade));

            } catch (Exception e) {
                e.printStackTrace();
                resultado.setMsg("Não foi possível realizar a consulta.");
            } //fim try/catch
        } else {
        	resultado.setMsg(mensagem);
        } // fim if

        return resultado;
    }

}