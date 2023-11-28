package br.inatel.labs.labrestclient;

import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import br.inatel.labs.labrestclient.model.dto.ProdutoDTO;
import reactor.core.publisher.Mono;

public class WebClientGetMonoProdutoPeloId {

	
	public static void main(String[] args) {
		
		try {
			Mono<ProdutoDTO> monoProduto = WebClient.create(Constantes.BASE_URL)
					.get()
					.uri("/produto/1")
					.retrieve()
					.bodyToMono(ProdutoDTO.class);
			
			monoProduto.subscribe();
	
			ProdutoDTO produtoRetornado = monoProduto.block();
			
			System.out.println("Produto encontrado");
			System.out.println(produtoRetornado);
			
		}catch (WebClientResponseException e) {
			System.out.println("Status code: " +e.getStatusCode());
			System.out.println("Message: " +e.getMessage());
		}
	}
	
}
