/**
 * 
 */
package dev.paie.service;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.ServicesConfig;
import dev.paie.entite.Grade;
import dev.paie.spring.DataSourceMySQLConfig;

@ContextConfiguration(classes = {DataSourceMySQLConfig.class})

@RunWith(SpringRunner.class)
public class GradeServiceJdbcTemplateTest {
	@Autowired
	private GradeService gradeService;
	
	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
		// TODO sauvegarder un nouveau grade
		Grade grade = new Grade();
		grade.setCode("this is a code");
		grade.setNbHeuresBase(new BigDecimal(5));
		grade.setTauxBase(new BigDecimal(10));
		
		gradeService.sauvegarder(grade);
		
		grade = gradeService.lister().get(0);
		
		assert grade.getCode().equals("this is a code");
		assert grade.getNbHeuresBase().equals(new BigDecimal(5));
		assert grade.getTauxBase().equals(new BigDecimal(10));
		
		grade.setCode("changement");
		grade.setNbHeuresBase(new BigDecimal(22));
		grade.setTauxBase(new BigDecimal(30));
		
		gradeService.mettreAJour(grade);
		
		grade = gradeService.lister().get(0);
		assert grade.getCode().equals("changement");
		assert grade.getNbHeuresBase().equals(new BigDecimal(22));
		assert grade.getTauxBase().equals(new BigDecimal(30));
		// TODO vérifier qu'il est possible de récupérer le nouveau grade via la m
		//éthode lister
		// TODO modifier un grade
		// TODO vérifier que les modifications sont bien prises en compte via la m
		//éthode lister
	}
}
