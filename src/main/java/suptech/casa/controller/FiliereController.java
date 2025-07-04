package suptech.casa.controller;

import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import suptech.casa.model.Etudiant;
import suptech.casa.model.Filiere;
import suptech.casa.service.EtudiantService;
import suptech.casa.service.FiliereService;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@AllArgsConstructor
public class FiliereController {
	final FiliereService filiereService;
	final EtudiantService etudiantService;
	@GetMapping("filieres")
	public List<Filiere> getAllFilieres() {
		return filiereService.getAllFilieres();
	}
	
	@PostMapping("filieres")
	public Filiere addFiliere(@RequestBody Filiere filiere) {
		return filiereService.addFiliere(filiere);
	}
	
	//Ajouter un nouvel étudiant à une filière
	@PostMapping("filieres/{nomFil}/etudiants")
	public Etudiant addEtudiantToFiliere(@RequestBody Etudiant etudiant,@PathVariable String nomFil) {
		Filiere filiere=filiereService.getFiliereByNom(nomFil);
		if (filiere==null) return null;
		etudiant.setFiliere(filiere);
		return etudiantService.addEtudiant(etudiant);
	}
	
	
}
