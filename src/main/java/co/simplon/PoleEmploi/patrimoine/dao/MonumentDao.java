package co.simplon.PoleEmploi.patrimoine.dao;

import java.util.List;

import co.simplon.PoleEmploi.patrimoine.modele.Monument;

public interface MonumentDao {
	List<Monument> findAll(int first, int size);
	
	List<Monument> findAllForVilleId(Long idVille, int first, int size);
	
	Monument getMonumentById(Long id);

	void deleteMonumentById(Long id);
	
	Monument updateMonument(Monument monument);
	
	Monument createMonumentForVille(Monument monument, Long id);
}
