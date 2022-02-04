package it.beije.pascal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.beije.pascal.model.Annuncio;

@Repository
public interface AnnuncioRepository extends JpaRepository<Annuncio, Integer> {

	//FIXME
	@Query(nativeQuery = true, value = "SELECT annuncio.id,venditore_id,indirizzo_id,tipo_immobile,tipo_annuncio,mq,stato_rogito,visita_guidata,virtual_tour,create_timestamp FROM annuncio JOIN indirizzo ON annuncio.indirizzo_id = indirizzo.id WHERE tipo_immobile = :tipoImmobile AND tipo_annuncio = :tipoAnnuncio AND comune = :comune")
	public List<Annuncio> searchAnnuncio(@Param("tipoImmobile") String tipoImmobile, @Param("tipoAnnuncio") String tipoAnnuncio, @Param("comune") String comune);
}
