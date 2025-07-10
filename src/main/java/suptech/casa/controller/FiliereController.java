package suptech.casa.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import suptech.casa.model.Etudiant;
import suptech.casa.model.Filiere;
import suptech.casa.repository.FiliereRepository;
import suptech.casa.service.EtudiantService;
import suptech.casa.service.FiliereService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;


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
	public Etudiant addEtudiantToFiliere(
			@RequestPart Etudiant etudiant,
			@RequestPart MultipartFile photo,
			@PathVariable String nomFil
			) throws IllegalStateException, IOException {	
		String path="./src/main/resources/static/photos/"+etudiant.getId()+".png";
		photo.transferTo(Path.of(path));
		String photoURL="http://localhost:8080/photos/"+etudiant.getId();
		etudiant.setPhoto(photoURL);
		Filiere filiere=filiereService.getFiliereByNom(nomFil);
		if (filiere==null) return null;
		etudiant.setFiliere(filiere);
		return etudiantService.addEtudiant(etudiant);
	}
	
	//Supprimer une filière
	@DeleteMapping("filieres/{id}")
	public boolean deleteFiliereById(@PathVariable Long id) {
		return filiereService.deleteFiliereById(id);
	}
	
	
}
