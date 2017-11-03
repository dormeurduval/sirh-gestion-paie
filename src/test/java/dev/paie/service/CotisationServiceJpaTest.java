/**
 * 
 */
package dev.paie.service;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.entite.Cotisation;
import dev.paie.spring.DataSourceMySQLConfig;
import dev.paie.spring.JpaConfig;

@ContextConfiguration(classes = {JpaConfig.class})

@RunWith(SpringRunner.class)
public class CotisationServiceJpaTest {
	@Autowired private CotisationService cotisationService;
	
	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
		Cotisation cotisation = new Cotisation();
		cotisation.setCode("code");
		cotisation.setLibelle("libelle");
		cotisation.setTauxPatronal(new BigDecimal(20));
		cotisation.setTauxSalarial(new BigDecimal(25));
		
		cotisationService.sauvegarder(cotisation);
		
		cotisation = cotisationService.lister().get(0);
		
		assert cotisation.getLibelle().equals("libelle");
		assert cotisation.getCode().equals("code");
		assert (cotisation.getTauxPatronal()).compareTo(new BigDecimal(20))==0;
		assert cotisation.getTauxSalarial().compareTo(new BigDecimal(25))==0;
		
		cotisation.setCode("new code");
		cotisationService.mettreAJour(cotisation);
		
		assert cotisationService.lister().get(0).getCode().equals("new code");
		// TODO sauvegarder une nouvelle cotisation
		// TODO vérifier qu'il est possible de récupérer la nouvelle cotisation via la
		//méthode lister
		
		
		// TODO modifier une cotisation
		// TODO vérifier que les modifications sont bien prises en compte via la m
		//éthode lister
	}
}
