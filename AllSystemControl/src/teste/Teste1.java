package teste;

import java.sql.SQLException;

import model.Informacoes;
import model.Maquina;
import service.InformacoesService;
import service.MaquinaService;

public class Teste1 {

	public static void main(String[] args)  {
		MaquinaService novoService = new MaquinaService();
		Maquina novo = novoService.carregar();
		InformacoesService is = new InformacoesService();
		Informacoes info = is.carregar();
		System.out.println(novo);
		System.out.println(info);

	}

}
