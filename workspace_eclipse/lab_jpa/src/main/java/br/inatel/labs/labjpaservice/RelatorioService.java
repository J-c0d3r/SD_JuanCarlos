package br.inatel.labs.labjpaservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.inatel.labs.labj.repository.RelatorioRepository;
import br.inatel.labs.labjpa.dto.TotalCompradoPorFornecedorDTO;

@Service
public class RelatorioService {

//	@PersistenceContext
//	private EntityManager em;

	@Autowired
	private RelatorioRepository repository;

	public List<TotalCompradoPorFornecedorDTO> pesquisarTotalCompradoPorFornecedor() {
		return repository.pesquisarTotalCompradoPorFornecedor();
	}
}
