package br.com.Seguradora.core.dao;

import br.com.Seguradora.dominio.Cidade;
import br.com.Seguradora.dominio.ClienteJuridico;
import java.sql.SQLException;
import java.util.List;
import br.com.Seguradora.dominio.EntidadeDominio;

public interface IDAO {
	public void salvar(EntidadeDominio entidade) throws SQLException;
	public void alterar(EntidadeDominio entidade)throws SQLException;
	public void excluir(EntidadeDominio entidade)throws SQLException;
	public List<EntidadeDominio> consultar(EntidadeDominio entidade)throws SQLException;
	public int salvarId(EntidadeDominio entidade) throws SQLException;
	public List<EntidadeDominio> filtrar(EntidadeDominio entidade) throws SQLException;	
        List<ClienteJuridico> consultarTodos() throws SQLException;
        public List<EntidadeDominio> continuar(EntidadeDominio entidade) throws SQLException;
}
