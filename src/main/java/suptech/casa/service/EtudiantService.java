package suptech.casa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import suptech.casa.model.Etudiant;
import suptech.casa.repository.EtudiantRepository;

@Service
@AllArgsConstructor
public class EtudiantService {
	final EtudiantRepository etudiantRepository;
	
	public Etudiant addEtudiant(Etudiant etudiant) {
		return etudiantRepository.save(etudiant);
	}
	
	public List<Etudiant> getAllEtudiants(){
		return etudiantRepository.findAll();
	}
	
	public boolean deleteById(Long id) {
		etudiantRepository.deleteById(id);
		return !etudiantRepository.existsById(id);
	}
	
	public Etudiant updateEtudiant(Etudiant etudiant) {
		return etudiantRepository.save(etudiant);
	}

	public List<Etudiant> getByNoteSuperieureA(double note) {
		return etudiantRepository.findByNoteGreaterThan(note);
	}

	public List<Etudiant> getByNomLike(String nom) {
		return etudiantRepository.findByNomLike(nom);
	}

}
