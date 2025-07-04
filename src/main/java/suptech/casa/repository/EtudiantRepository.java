package suptech.casa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import suptech.casa.model.Etudiant;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long>{
public List<Etudiant> findByNoteGreaterThan(double note);
public List<Etudiant> findByNomLike(String nom);
}
