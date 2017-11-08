/**
 * 
 */
package dev.paie.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.ServicesConfig;
import dev.paie.config.WebAppConfig;
import dev.paie.entite.Avantage;
import dev.paie.repository.AvantageRepository;
import dev.paie.repository.GradeRepository;

@ContextConfiguration(classes = { ServicesConfig.class,WebAppConfig.class})

@RunWith(SpringRunner.class)
public class AvantageRepositoryTest {
	@Autowired
	private AvantageRepository avantageRepository;
	
	
	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
		// TODO sauvegarder un nouvel avantage
		// TODO vérifier qu'il est possible de récupérer le nouvel avantage via la m
		//éthode findOne
		// TODO modifier un avantage
		// TODO vérifier que les modifications sont bien prises en compte via la m
		//éthode findOne
		/*	
		Avantage avantage= new Avantage();
		avantage.setCode("code");
		avantage.setNom("nom");
		avantageRepository.save(avantage);
		
		avantage = avantageRepository.findOne(17);
		
		assert avantage.getCode().equals("code");
		assert avantage.getNom().equals("nom");
		
		avantage.setCode("new code");
		
		avantageRepository.save(avantage);
		
		
		assert avantageRepository.findOne(17).getCode().equals("new code");
	
	
		avantage =avantageRepository.findByCode("new code").get(0);
		
		assert avantage.getCode().equals("new code");*/
	}
}
