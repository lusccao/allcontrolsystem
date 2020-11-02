package teste;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import model.Maquina;
import service.MaquinaService;

class Teste {

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	public void test00Carregar() {
		System.out.println("carregar");
		//para funcionar o cliente 1 deve ter sido carregado no banco por fora
		Maquina fixture = new Maquina();
		fixture.setIdMaquinas(1);
		fixture.setHostname("ip-172-31-82-97");
		fixture.setSO("Ubuntu,20.04.1");
		fixture.setDescricao("");
		MaquinaService novoService = new MaquinaService();
		Maquina novo = novoService.carregar(1);
		assertEquals("testa inclusao", novo, fixture);
	}

}
