package suptech.casa.service;

import java.io.File;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import suptech.casa.model.Filiere;
import suptech.casa.repository.FiliereRepository;

@Service
@AllArgsConstructor
public class FiliereService {
	final FiliereRepository filiereRepository;

	public List<Filiere> getAllFilieres() {
		return filiereRepository.findAll();
	}

	public Filiere addFiliere(Filiere filiere) {
		return filiereRepository.save(filiere);
	}

	public Filiere getFiliereByNom(String nomFil) {
		return filiereRepository.findByNom(nomFil);
	}

	public boolean deleteFiliereById(Long id) {
		filiereRepository.deleteById(id);
		return !filiereRepository.existsById(id);
	}
	
	
	
}
