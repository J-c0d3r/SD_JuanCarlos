package br.inatel.labs.labjpaservice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.inatel.labs.labj.repository.NotaCompraItemRepository;
import br.inatel.labs.labj.repository.NotaCompraRepository;
import br.inatel.labs.labjpa.entity.NotaCompra;
import br.inatel.labs.labjpa.entity.NotaCompraItem;

@Service
@Transactional
public class NotaCompraService {

//	@PersistenceContext
//	private EntityManager em;

	@Autowired
	private NotaCompraRepository ncRepository;

	@Autowired
	private NotaCompraItemRepository nciRepository;

	//// nota compra
	public NotaCompra salvar(NotaCompra nc) {
//		return em.merge(nc);
		return ncRepository.save(nc);
	}

	public Optional<NotaCompra> buscarNotaCompraPeloId(Long id) {
//		return em.find(NotaCompra.class, id);
		return ncRepository.findById(id);
	}

	public NotaCompra buscarNotaCompraPeloIdComListaItem(Long id) {
//		NotaCompra notaCompra = em.find(NotaCompra.class, id);
//		notaCompra.getListaNotaCompraItem().size();
//		return notaCompra;

		Optional<NotaCompra> opNotaCompra = ncRepository.findById(id);
		if (opNotaCompra.isPresent()) {
			NotaCompra notaCompra = opNotaCompra.get();
			notaCompra.getListaNotaCompraItem().size();
			return notaCompra;
		} else {
			throw new RuntimeException("Nenhuma nota compra encontrada");
		}
	}

	public List<NotaCompra> listaNotaCompra() {
//		return em.createQuery("select nc from NotaCompra nc", NotaCompra.class).getResultList();
		return ncRepository.findAll();
	}

	//// nota compra item
	public NotaCompraItem salvar(NotaCompraItem item) {
//		return em.merge(item);
		return nciRepository.save(item);
	}

	public Optional<NotaCompraItem> buscarNotaCompraItemPeloId(Long id) {
//		return em.find(NotaCompraItem.class, id);
		return nciRepository.findById(id);
	}

	public List<NotaCompraItem> listaNotaCompraItem() {
//		return em.createQuery("select i from NotaCompraItem i", NotaCompraItem.class).getResultList();
		return nciRepository.findAll();
	}
}
