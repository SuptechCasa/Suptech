package suptech.casa.service;

import java.io.File;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
	
	public List<Etudiant> getAllEtudiants(int page, int size, String field){
		Pageable pages=PageRequest.of(page, size, Sort.by("nom").descending());
		return etudiantRepository.findAll(pages).getContent();
	}
	
	public boolean deleteById(Long id) {
		String path="./src/main/resources/static/photos/"+id+".png";
		File file=new File(path);
		if (file.exists()) file.delete();
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
