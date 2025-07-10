package suptech.casa.controller;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import suptech.casa.model.Etudiant;
import suptech.casa.service.EtudiantService;

@RestController
@AllArgsConstructor
public class EtudiantController {
	final EtudiantService etudiantService;
	@GetMapping("etudiants/{page}/{size}/{field}")
	public List<Etudiant> getAllEtudiantsPages(@PathVariable int page, @PathVariable int size,@PathVariable String field) {
		return etudiantService.getAllEtudiants(page, size, field);
	}
	
	@DeleteMapping("etudiants/{id}")
	public boolean deleteEtudiant(@PathVariable Long id) {
		return etudiantService.deleteById(id);
	}
	
	@PutMapping("etudiants")
	public Etudiant updateEtudiant(@RequestBody Etudiant etudiant) {
		return etudiantService.updateEtudiant(etudiant);
	}
	
	
	
	@GetMapping("etudiants/{note}")
	public List<Etudiant> getByNoteSuperieureA(double note){
		return etudiantService.getByNoteSuperieureA(note);
	}
	
	@GetMapping("etudiants/like/{nom}")
	public List<Etudiant> getByNomLike(String nom){
		return etudiantService.getByNomLike(nom);
	}
}
