package br.com.Seguradora.web.servlet;

import br.com.Seguradora.core.dao.FabricaDAO;
import br.com.Seguradora.core.dao.IDAO;
import br.com.Seguradora.dominio.ClienteJuridico;
import br.com.Seguradora.web.command.AlterarCommand;
import br.com.Seguradora.web.command.AutenticarCommand;
import br.com.Seguradora.web.command.ConsultarCommand;
import br.com.Seguradora.web.command.ContinuarCommand;
import br.com.Seguradora.web.command.ExcluirCommand;
import br.com.Seguradora.web.command.FiltrarCommand;
import br.com.Seguradora.web.command.ICommand;
import br.com.Seguradora.web.command.SalvarCommand;
import br.com.Seguradora.web.command.SelecionarCommand;
import br.com.Seguradora.web.command.VisualizarCommand;
import br.com.Seguradora.web.vh.ApoliceViewHelper;
import br.com.Seguradora.web.vh.CausasNaturaisViewHelper;
import br.com.Seguradora.web.vh.ClienteJuridicoViewHelper;
import br.com.Seguradora.web.vh.ClienteTerceiroViewHelper;
import br.com.Seguradora.web.vh.ClienteViewHelper;
import br.com.Seguradora.web.vh.ColisaoViewHelper;
import br.com.Seguradora.web.vh.CorretorViewHelper;
import br.com.Seguradora.web.vh.FurtoRouboViewHelper;
import br.com.Seguradora.web.vh.GraficoViewHelper;
import br.com.Seguradora.web.vh.IViewHelper;
import br.com.Seguradora.web.vh.IncendioViewHelper;
import br.com.Seguradora.web.vh.LoginViewHelper;
import br.com.Seguradora.web.vh.MecanicaViewHelper;
import br.com.Seguradora.web.vh.ProdutoViewHelper;
import br.com.Seguradora.web.vh.SinistroViewHelper;
import br.com.Seguradora.web.vh.VeiculoViewHelper;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet extends HttpServlet{

    private static final long serialVersionUID = 1L;

    private static Map<String, ICommand> commands;
    private static Map<String, IViewHelper> vhs;
    
    public Servlet(){
        commands = new HashMap<String, ICommand>();
        commands.put("SALVAR", new SalvarCommand());
        commands.put("CONSULTAR", new ConsultarCommand());
        commands.put("VISUALIZAR", new VisualizarCommand());
        commands.put("EXCLUIR", new ExcluirCommand());
        commands.put("ALTERAR", new AlterarCommand());
        commands.put("LISTARFILTRO", new FiltrarCommand());
        commands.put("PREATUALIZAR", new ConsultarCommand());
        commands.put("CONTINUAR", new ContinuarCommand());
        commands.put("SELECIONAR", new SelecionarCommand());
        commands.put("AUTENTICAR", new AutenticarCommand());
        
    	
        vhs = new HashMap<String, IViewHelper>();
        
        
        // CLIENTE FISICO
        
        vhs.put("/Seguradora/cliente/salvar", new ClienteViewHelper());
        vhs.put("/Seguradora/cliente/consultar", new ClienteViewHelper());
        vhs.put("/Seguradora/cliente/excluir", new ClienteViewHelper());
        vhs.put("/Seguradora/cliente/visualizar", new ClienteViewHelper());
        vhs.put("/Seguradora/cliente/alterar", new ClienteViewHelper());
        vhs.put("/Seguradora/cliente/filtrar", new ClienteViewHelper());
        vhs.put("/Seguradora/cliente/preAtualizar", new ClienteViewHelper());
        vhs.put("/Seguradora/cliente/autenticar", new ClienteViewHelper());
        
        // VEICULO
        
        vhs.put("/Seguradora/veiculo/salvar", new VeiculoViewHelper());
        vhs.put("/Seguradora/veiculo/consultar", new VeiculoViewHelper());
        vhs.put("/Seguradora/veiculo/excluir", new VeiculoViewHelper());
        vhs.put("/Seguradora/veiculo/visualizar", new VeiculoViewHelper());
        vhs.put("/Seguradora/veiculo/alterar", new VeiculoViewHelper());
        vhs.put("/Seguradora/veiculo/filtrar", new VeiculoViewHelper());
        vhs.put("/Seguradora/veiculo/preAtualizar", new VeiculoViewHelper());
        
        // CORRETOR
        
        vhs.put("/Seguradora/corretor/salvar", new CorretorViewHelper());
        vhs.put("/Seguradora/corretor/consultar", new CorretorViewHelper());
        vhs.put("/Seguradora/corretor/excluir", new CorretorViewHelper());
        vhs.put("/Seguradora/corretor/visualizar", new CorretorViewHelper());
        vhs.put("/Seguradora/corretor/alterar", new CorretorViewHelper());
        vhs.put("/Seguradora/corretor/filtrar", new CorretorViewHelper());
        vhs.put("/Seguradora/corretor/preAtualizar", new CorretorViewHelper());   
        vhs.put("/Seguradora/corretor/autenticar", new CorretorViewHelper());   
        
        // APOLICE
        
        
        vhs.put("/Seguradora/apolice/salvar", new ApoliceViewHelper());
        vhs.put("/Seguradora/apolice/consultar", new ApoliceViewHelper());
        vhs.put("/Seguradora/apolice/excluir", new ApoliceViewHelper());
        vhs.put("/Seguradora/apolice/visualizar", new ApoliceViewHelper());
        vhs.put("/Seguradora/apolice/alterar", new ApoliceViewHelper());
        vhs.put("/Seguradora/apolice/filtrar", new ApoliceViewHelper());
        vhs.put("/Seguradora/apolice/preAtualizar", new ApoliceViewHelper());
        vhs.put("/Seguradora/apolice/continuar", new ApoliceViewHelper());
        vhs.put("/Seguradora/apolice/selecionar", new ApoliceViewHelper());
        
        // SINISTRO
        
        vhs.put("/Seguradora/sinistro/salvar", new SinistroViewHelper());
        vhs.put("/Seguradora/sinistro/consultar", new SinistroViewHelper());
        vhs.put("/Seguradora/sinistro/excluir", new SinistroViewHelper());
        vhs.put("/Seguradora/sinistro/visualizar", new SinistroViewHelper());
        vhs.put("/Seguradora/sinistro/alterar", new SinistroViewHelper());
        vhs.put("/Seguradora/sinistro/filtrar", new SinistroViewHelper());
        vhs.put("/Seguradora/sinistro/preAtualizar", new SinistroViewHelper());
        vhs.put("/Seguradora/sinistro/continuar", new SinistroViewHelper());
        vhs.put("/Seguradora/sinistro/selecionar", new SinistroViewHelper());
        
        // FURTO E ROUBO
        
        vhs.put("/Seguradora/furtoRoubo/salvar", new FurtoRouboViewHelper());
        vhs.put("/Seguradora/furtoRoubo/consultar", new FurtoRouboViewHelper());
        vhs.put("/Seguradora/furtoRoubo/excluir", new FurtoRouboViewHelper());
        vhs.put("/Seguradora/furtoRoubo/visualizar", new FurtoRouboViewHelper());
        vhs.put("/Seguradora/furtoRoubo/alterar", new FurtoRouboViewHelper());
        vhs.put("/Seguradora/furtoRoubo/filtrar", new FurtoRouboViewHelper());
        vhs.put("/Seguradora/furtoRoubo/preAtualizar", new FurtoRouboViewHelper());
        vhs.put("/Seguradora/furtoRoubo/continuar", new FurtoRouboViewHelper());
        vhs.put("/Seguradora/furtoRoubo/selecionar", new FurtoRouboViewHelper());
        
        // INCENDIO        
        vhs.put("/Seguradora/incendio/salvar", new IncendioViewHelper());
        vhs.put("/Seguradora/incendio/consultar", new IncendioViewHelper());
        vhs.put("/Seguradora/incendio/excluir", new IncendioViewHelper());
        vhs.put("/Seguradora/incendio/visualizar", new IncendioViewHelper());
        vhs.put("/Seguradora/incendio/alterar", new IncendioViewHelper());
        vhs.put("/Seguradora/incendio/filtrar", new IncendioViewHelper());
        vhs.put("/Seguradora/incendio/preAtualizar", new IncendioViewHelper());
        vhs.put("/Seguradora/incendio/continuar", new IncendioViewHelper());
        vhs.put("/Seguradora/incendio/selecionar", new IncendioViewHelper());
        
        // CAUSAS NATURAIS        
        vhs.put("/Seguradora/causasNaturais/salvar", new CausasNaturaisViewHelper());
        vhs.put("/Seguradora/causasNaturais/consultar", new CausasNaturaisViewHelper());
        vhs.put("/Seguradora/causasNaturais/excluir", new CausasNaturaisViewHelper());
        vhs.put("/Seguradora/causasNaturais/visualizar", new CausasNaturaisViewHelper());
        vhs.put("/Seguradora/causasNaturais/alterar", new CausasNaturaisViewHelper());
        vhs.put("/Seguradora/causasNaturais/filtrar", new CausasNaturaisViewHelper());
        vhs.put("/Seguradora/causasNaturais/preAtualizar", new CausasNaturaisViewHelper());
        vhs.put("/Seguradora/causasNaturais/continuar", new CausasNaturaisViewHelper());
        vhs.put("/Seguradora/causasNaturais/selecionar", new CausasNaturaisViewHelper());
        
        
        // CLIENTE TERCEIRO        
        vhs.put("/Seguradora/clienteTerceiro/salvar", new ClienteTerceiroViewHelper());
        vhs.put("/Seguradora/clienteTerceiro/consultar", new ClienteTerceiroViewHelper());
        vhs.put("/Seguradora/clienteTerceiro/excluir", new ClienteTerceiroViewHelper());
        vhs.put("/Seguradora/clienteTerceiro/visualizar", new ClienteTerceiroViewHelper());
        vhs.put("/Seguradora/clienteTerceiro/alterar", new ClienteTerceiroViewHelper());
        vhs.put("/Seguradora/clienteTerceiro/filtrar", new ClienteTerceiroViewHelper());
        vhs.put("/Seguradora/clienteTerceiro/preAtualizar", new ClienteTerceiroViewHelper());
        vhs.put("/Seguradora/clienteTerceiro/continuar", new ClienteTerceiroViewHelper());
        vhs.put("/Seguradora/clienteTerceiro/selecionar", new ClienteTerceiroViewHelper());
        
        // COLISAO
        vhs.put("/Seguradora/colisao/salvar", new ColisaoViewHelper());
        vhs.put("/Seguradora/colisao/consultar", new ColisaoViewHelper());
        vhs.put("/Seguradora/colisao/excluir", new ColisaoViewHelper());
        vhs.put("/Seguradora/colisao/visualizar", new ColisaoViewHelper());
        vhs.put("/Seguradora/colisao/alterar", new ColisaoViewHelper());
        vhs.put("/Seguradora/colisao/filtrar", new ColisaoViewHelper());
        vhs.put("/Seguradora/colisao/preAtualizar", new ColisaoViewHelper());
        vhs.put("/Seguradora/colisao/continuar", new ColisaoViewHelper());
        vhs.put("/Seguradora/colisao/selecionar", new ColisaoViewHelper());
        
        
        // MECANICA
        vhs.put("/Seguradora/mecanica/salvar", new MecanicaViewHelper());
        vhs.put("/Seguradora/mecanica/consultar", new MecanicaViewHelper());
        vhs.put("/Seguradora/mecanica/excluir", new MecanicaViewHelper());
        vhs.put("/Seguradora/mecanica/visualizar", new MecanicaViewHelper());
        vhs.put("/Seguradora/mecanica/alterar", new MecanicaViewHelper());
        vhs.put("/Seguradora/mecanica/filtrar", new MecanicaViewHelper());
        vhs.put("/Seguradora/mecanica/preAtualizar", new MecanicaViewHelper());
        vhs.put("/Seguradora/mecanica/continuar", new MecanicaViewHelper());
        vhs.put("/Seguradora/mecanica/selecionar", new MecanicaViewHelper());
        
        
        // GRAFICO
        vhs.put("/Seguradora/grafico/salvar", new GraficoViewHelper());
        vhs.put("/Seguradora/grafico/consultar", new GraficoViewHelper());
        vhs.put("/Seguradora/grafico/excluir", new GraficoViewHelper());
        vhs.put("/Seguradora/grafico/visualizar", new GraficoViewHelper());
        vhs.put("/Seguradora/grafico/alterar", new GraficoViewHelper());
        vhs.put("/Seguradora/grafico/filtrar", new GraficoViewHelper());
        vhs.put("/Seguradora/grafico/preAtualizar", new GraficoViewHelper());
        vhs.put("/Seguradora/grafico/continuar", new GraficoViewHelper());
        vhs.put("/Seguradora/grafico/selecionar", new GraficoViewHelper());
        
        // LOGIN
        vhs.put("/Seguradora/login/salvar", new LoginViewHelper());
        vhs.put("/Seguradora/login/autenticar", new LoginViewHelper());
        
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcessRequest(request, response);

    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doProcessRequest(request, response);
    }

    protected void doProcessRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
     //pega a uri de onde vem a requisição, indicada no action no form
        String uri = request.getRequestURI();
       
        //Obtem o objeto da viewHelper correta, mapeada no hash acima;
        IViewHelper vh = vhs.get(uri);

        //Vai retornar o objeto do dominio, que foi constru�do na viewhelper espec�fica
        br.com.Seguradora.dominio.EntidadeDominio entidade = vh.getEntidade(request);//AQUI!!!! RECEBE A ENTIDADE
      
        //Essa string recebe o valor do atributo "operacao" no formulário, que é do tipo hidden, e será utilizado para identificar o command no map
        String operacao = request.getParameter("operacao");

        //Obtem o objeto do comando que executará a operação
        ICommand command = commands.get(operacao);

        //Executa o commando que vai chamar a fachada para executar a opera��o requisitada
        //o retorno � uma inst�ncia da classe resultado que pode conter mensagens de erro ou entidades de retorno
        br.com.Seguradora.core.fachada.Resultado resultado = command.execute(entidade);

        //Chama o método para retornar a resposta para a view correta.
        vh.setView(resultado, request, response);
        

    }
    
    /*@Override
    protected void service(HttpServletRequest request, HttpServletResponse response) 
           throws ServletException, IOException{
       
       ClienteJuridico clienteTemp = new ClienteJuridico();
       List<ClienteJuridico> clientesJuridicos;
       try {
           IDAO idao = FabricaDAO.getConexaoSQL();
           clientesJuridicos = idao.consultarTodos();
           request.setAttribute("todosClientesJuridicos", clientesJuridicos);
           request.getRequestDispatcher("/clienteJuridico/filtrarClienteJuridico.jsp").forward(request, response);
       } catch (IOException | SQLException | ServletException e) {
       }
       
   }*/
}
