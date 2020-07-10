package br.com.Seguradora.core.fachada;

import br.com.Seguradora.dominio.EntidadeDominio;

public interface IFachada {
    public Resultado salvar(EntidadeDominio entidade);
    public Resultado alterar(EntidadeDominio entidade);
    public Resultado excluir(EntidadeDominio entidade);
    public Resultado consultar(EntidadeDominio entidade);
    public Resultado visualizar(EntidadeDominio entidade);
    public Resultado listarfiltro(EntidadeDominio entidade);
    public Resultado continuar(EntidadeDominio entidade);
    public Resultado selecionar(EntidadeDominio entidade);
    public Resultado autenticar(EntidadeDominio entidade);
}
