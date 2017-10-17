package co.simplon.PoleEmploi.patrimoine.dao;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import co.simplon.PoleEmploi.patrimoine.modele.Monument;
import co.simplon.PoleEmploi.patrimoine.modele.Ville;

@Named
public class MonumentJpaDao implements MonumentDao {

	@Inject
	private EntityManager entityManager;

	public MonumentJpaDao() {
		super();
	}
	
	@Override
	public List<Monument> findAll(int first, int size) {
		return entityManager
				.createNamedQuery("Monument.findAll", Monument.class)
				.setFirstResult(first).setMaxResults(size).getResultList();
	}

	@Override
	public List<Monument> findAllForVilleId(Long idVille, int first, int size) {
		return entityManager
				.createNamedQuery("Monument.findAllByVilleId", Monument.class)
				.setParameter("id", idVille).setFirstResult(first)
				.setMaxResults(size).getResultList();
	}

	@Override
	public Monument getMonumentById(Long id) {
		return entityManager.find(Monument.class, id);
	}

	@Override
	public void deleteMonumentById(Long id) {
		entityManager.getTransaction().begin();
		entityManager.createNamedQuery("Monument.deleteById")
				.setParameter("id", id).executeUpdate();
		entityManager.getTransaction().commit();
	}

	@Override
	public Monument updateMonument(Monument monument) {
		entityManager.getTransaction().begin();
		monument = entityManager.merge(monument);
		entityManager.getTransaction().commit();
		return monument;
	}

	@Override
	public Monument createMonumentForVille(Monument monument, Long id) {
		entityManager.getTransaction().begin();
		Ville ville = entityManager.find(Ville.class, id);
		monument.setVille(ville);
		entityManager.persist(monument);
		entityManager.getTransaction().commit();
		return monument;
	}

}
