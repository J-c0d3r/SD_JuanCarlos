package br.inatel.labs.labjpa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.inatel.labs.labjpa.entity.Endereco;
import br.inatel.labs.labjpaservice.EnderecoService;

@SpringBootTest
public class EnderecoTest {

	@Autowired
	private EnderecoService service;

	@Test
	public void testarUUIDGeradoPeloJPAListener() {

		Endereco e = new Endereco();
		e.setRua("Av. TesteRua");
		e.setNumero("100");
		e.setCidade("Cidade de Teste");
		e.setUf("TS");

		e = service.salvar(e);

		System.out.println(e);
	}

}
