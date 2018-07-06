package com.projetoposto.avaliacao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoposto.cliente.Cliente;
import com.projetoposto.cliente.ClienteService;
import com.projetoposto.combustivel.Combustivel;
import com.projetoposto.combustivel.CombustivelService;
import com.projetoposto.posto.Posto;
import com.projetoposto.posto.PostoRepository;

@Service(value = "avaliacaoService")
public class AvaliacaoServiceImpl implements AvaliacaoService{
	
	@Autowired
	private ClienteService clienteService;

	@Autowired
	private AvaliacaoRepository avaliacaoRepository;
	
	@Autowired
	private CombustivelService combustivelService;
	
	@Autowired
	private PostoRepository postoRepository;
	
	@Override
	public Avaliacao save(Long idPosto, Long idCombustivel, Long idCliente, Avaliacao avaliacao) {
		Cliente cliente = clienteService.findById(idCliente).get();
		Combustivel combustivel = combustivelService.findById(idPosto,idCombustivel);
		Posto posto = postoRepository.findById(idPosto).get();
		
		Avaliacao novaAvaliacao = new Avaliacao();
		novaAvaliacao.setCombustivel(combustivel);
		novaAvaliacao.setComentario(avaliacao.getComentario());
		novaAvaliacao.setCliente(cliente);
		
		Combustivel combustivelEncontrado = posto.buscarCombustivel(combustivel, combustivelService.findAll(idPosto));
		combustivelEncontrado.getAvaliacoes().add(novaAvaliacao);
		
		cliente.getListaDeAvaliacoes().add(novaAvaliacao);
		
		Avaliacao avaliacaoCombustivel = avaliacaoRepository.save(novaAvaliacao);
		
		return avaliacaoCombustivel;
	}

	@Override
	public List<Avaliacao> findAll(Long idPosto, Long idCombustivel) {
		List<Avaliacao> list = new ArrayList<>();
		Posto posto = postoRepository.findById(idPosto).get();
		Combustivel combustivel = combustivelService.findById(idPosto,idCombustivel);
		
		Combustivel combustivelEncontrado = posto.buscarCombustivel(combustivel, combustivelService.findAll(idPosto));
		combustivelEncontrado.getAvaliacoes().iterator().forEachRemaining(list::add);
		return list;
	}

	@Override
	public void delete(Long idPosto, Long idCombustivel, Long idCliente, Long idAvaliacao) {
		List<Avaliacao> avaliacoes = findAll(idPosto, idCombustivel);
		Combustivel combustivel= combustivelService.findById(idPosto,idCombustivel);
		Avaliacao avaliacao = avaliacaoRepository.findById(idAvaliacao).get();
		Cliente cliente = clienteService.findById(idCliente).get();
		
		cliente.getListaDeAvaliacoes().remove(avaliacao);
		combustivel.getAvaliacoes().remove(avaliacao);
		avaliacoes.remove(avaliacao);
		avaliacaoRepository.delete(avaliacao);
		
	}
	
	

}
