package com.adesoes.gerenciamento.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adesoes.gerenciamento.domain.exception.CpfDuplicadoException;
import com.adesoes.gerenciamento.domain.exception.CpfNaoEncontradoException;
import com.adesoes.gerenciamento.domain.model.contratante.Contratante;
import com.adesoes.gerenciamento.domain.service.ContratanteService;
import com.adesoes.gerenciamento.infrastructure.repository.ContratanteRepository;

@Service
public class ContratanteServiceImp implements ContratanteService{

	@Autowired
	private ContratanteRepository contratanteRepository;
	
	@Override
	public Contratante cadastrar(Contratante contratante) throws Exception{
		if(listarPorCpf(contratante.getCpf()) !=null) {
			throw new CpfDuplicadoException();
		}
		
		return contratanteRepository.save(contratante);
	}
	
	@Override
	public List<Contratante> listar(){
		return contratanteRepository.findAll();
	}
	
	@Override
	public Contratante listarPorCpf(String cpf){
		Contratante contratante = null;
		List<Contratante> contratantes = contratanteRepository.findAll();
		if(!contratantes.isEmpty()) {
			for(Contratante c: contratantes) {
				if(c.getCpf().equals(cpf)) {
					contratante = c;
					break;
				}
			}
		
		}
		
		return contratante;
	}
	
	@Override
	public void deletar(String cpf) throws Exception{
		Contratante contratante = listarPorCpf(cpf);
		
		if(contratante == null) {
			throw new CpfNaoEncontradoException();
		}
		contratanteRepository.deleteById(cpf);
	}

	@Override
	public Contratante editar(String cpf, Contratante contratante) throws Exception{
		Contratante c = null;
		
		if(listarPorCpf(cpf)!=null) {
			contratante.setCpf(cpf);
			c=contratanteRepository.save(contratante);
		}else {
			throw new CpfNaoEncontradoException();
		}
		return c;
	}
	
}
