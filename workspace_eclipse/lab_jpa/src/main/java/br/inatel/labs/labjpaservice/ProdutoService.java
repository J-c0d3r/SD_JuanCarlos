package br.inatel.labs.labjpaservice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.inatel.labs.labj.repository.ProdutoRepository;
import br.inatel.labs.labjpa.entity.Produto;

@Service
@Transactional
public class ProdutoService {

//	@PersistenceContext
//	private EntityManager em;

	@Autowired
	private ProdutoRepository produtoRepository;

	public Produto salvar(Produto p) {
//		p = em.merge(p);
//		return p;
		return produtoRepository.save(p);
	}

	public Optional<Produto> buscarPeloId(Long id) {
//		Produto produtoEncontrado = em.find(Produto.class, id);
//		return produtoEncontrado;
		return produtoRepository.findById(id);
	}

	public List<Produto> listar() {
//		List<Produto> produtos = em.createQuery("select p from Produto p", Produto.class).getResultList();
//		return produtos;
		return produtoRepository.findAll();
	}

	public void remove(Produto p) {
//		p = em.merge(p); // provoca a transição para o estado Managed
//		em.remove(p); // uma vez em Managed, posso remover
		produtoRepository.delete(p);
	}

}
