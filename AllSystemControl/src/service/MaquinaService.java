package service;


import dao.MaquinaDAO;
import model.Maquina;

public class MaquinaService {
	MaquinaDAO dao = new MaquinaDAO();
	
	public int criar(Maquina maquina) {
		return dao.criar(maquina);
	}
	
	public void atualizar(Maquina maquina){
		dao.atualizar(maquina);
	}
	
	public void excluir(int id){
		dao.excluir(id);
	}
	
	public Maquina carregar(int id){
		return dao.carregar(id);
	}

}
