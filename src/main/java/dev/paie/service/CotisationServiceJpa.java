/**
 * 
 */
package dev.paie.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.paie.entite.Cotisation;

@Service
public class CotisationServiceJpa implements CotisationService {
	@PersistenceContext private EntityManager em;


	@Override
	@Transactional
	public void sauvegarder(Cotisation nouvelleCotisation) {
		// TODO Auto-generated method stub
		em.persist(nouvelleCotisation);
		
	}


	@Override
	@Transactional
	public void mettreAJour(Cotisation cotisation) {
		
		List result= em.createQuery("from Cotisation c where id="+cotisation.getId()).getResultList();
		
		Cotisation newCotisation = (Cotisation)result.get(0);
		newCotisation.setCode(cotisation.getCode());
		newCotisation.setLibelle(cotisation.getLibelle());
		newCotisation.setTauxPatronal(cotisation.getTauxPatronal());
		newCotisation.setTauxSalarial(cotisation.getTauxSalarial());
		
		em.merge(newCotisation);
		
	}


	@Override
	public List<Cotisation> lister() {
		// TODO Auto-generated method stub
		return em.createQuery("from Cotisation c").getResultList();
	}
}
