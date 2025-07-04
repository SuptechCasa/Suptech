package suptech.casa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import suptech.casa.model.Filiere;

public interface FiliereRepository extends JpaRepository<Filiere, Long>{

	Filiere findByNom(String nomFil);

}
