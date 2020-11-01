package service;

import dao.InformacoesDAO;
import model.Informacoes;

public class InformacoesService {
	InformacoesDAO dao = new InformacoesDAO();
	
	public int criar(Informacoes informacoes) {
		return dao.criar(informacoes);
	}
	
	public void atualizar(Informacoes informacoes){
		dao.atualizar(informacoes);
	}
	
	public void excluir(int id){
		dao.excluir(id);
	}
	
	public Informacoes carregar(int id){
		return dao.carregar(id);
	}

}
