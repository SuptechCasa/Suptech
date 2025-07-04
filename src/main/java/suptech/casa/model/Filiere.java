package suptech.casa.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor @AllArgsConstructor @Data
public class Filiere {
	@Id
Long id;
String nom;
@OneToMany(mappedBy = "filiere",cascade = CascadeType.REMOVE)
@JsonIgnore
List<Etudiant> etudiants;
}