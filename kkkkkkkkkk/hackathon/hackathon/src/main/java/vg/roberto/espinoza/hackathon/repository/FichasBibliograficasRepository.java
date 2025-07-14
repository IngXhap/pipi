package vg.roberto.espinoza.hackathon.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vg.roberto.espinoza.hackathon.model.FichaBibliografica;


@Repository
public interface FichasBibliograficasRepository extends JpaRepository<FichaBibliografica, Integer> {
 List<FichaBibliografica> findByEstado(Boolean estado); 
    
}
