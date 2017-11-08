/**
 * 
 */
package dev.paie.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.Utilisateur.ROLES;
import dev.paie.config.ServicesConfig;
import dev.paie.config.WebAppConfig;
import dev.paie.entite.*;
import dev.paie.repository.*;
import dev.paie.spring.JpaConfig;

/**
 * @author joris
 *
 */
@Service
@Transactional
public class InitialiserDonneesServiceDev implements InitialiserDonneesService {

	@Autowired private PasswordEncoder passwordEncoder;
	
	@Autowired
	UtilisateurRepository utilisateurRepository;
	
	@Autowired
	private CotisationRepository cotisationRepository;
	
	@Autowired
	private EntrepriseRepository entrepriseRepository;
	
	@Autowired
	private PeriodeRepository periodeRepository;
	
	@Autowired
	private GradeRepository gradeRepository;
	
	@Autowired
	private ProfilRemunerationRepository profilRenumerationRepository;
	
	
	ApplicationContext context;
	@Transactional
	public void initialiser() {
		/*,,  */
		/*Cotisation.class */
		context = new ClassPathXmlApplicationContext(new String[] {"cotisations-imposables.xml", "cotisations-non-imposables.xml"});
		
		Stream.of( Cotisation.class ).forEach(
				classe -> context.getBeansOfType(classe).values().stream().forEach(object -> cotisationRepository.save(object)));
		
		context = new ClassPathXmlApplicationContext(new String[] { "entreprises.xml"});

		Stream.of( Entreprise.class ).forEach(
				classe -> context.getBeansOfType(classe).values().stream().forEach(object -> entrepriseRepository.save(object)));
		
		context = new ClassPathXmlApplicationContext(new String[] { "grades.xml"});
		
		Stream.of( Grade.class ).forEach(
				classe -> context.getBeansOfType(classe).values().stream().forEach(object -> gradeRepository.save(object)));
		
		context = new ClassPathXmlApplicationContext(new String[] {"profilRemuneration.xml"});
		
		Stream.of( ProfilRemuneration.class ).forEach(
				classe -> context.getBeansOfType(classe).values().stream().forEach(object -> profilRenumerationRepository.save(object)));
		
		periodeRepository.save(new Periode(LocalDate.of(2017, 1, 1), LocalDate.of(2017, 1, 31)));
		periodeRepository.save(new Periode(LocalDate.of(2017, 2, 1), LocalDate.of(2017, 2, 28)));
		periodeRepository.save(new Periode(LocalDate.of(2017, 3, 1), LocalDate.of(2017, 3, 31)));
		periodeRepository.save(new Periode(LocalDate.of(2017, 4, 1), LocalDate.of(2017, 4, 30)));
		periodeRepository.save(new Periode(LocalDate.of(2017, 5, 1), LocalDate.of(2017, 5, 31)));
		periodeRepository.save(new Periode(LocalDate.of(2017, 6, 1), LocalDate.of(2017, 6, 30)));
		periodeRepository.save(new Periode(LocalDate.of(2017, 7, 1), LocalDate.of(2017, 7, 31)));
		periodeRepository.save(new Periode(LocalDate.of(2017, 8, 1), LocalDate.of(2017, 8, 31)));
		periodeRepository.save(new Periode(LocalDate.of(2017, 9, 1), LocalDate.of(2017, 9, 30)));
		periodeRepository.save(new Periode(LocalDate.of(2017, 10, 1), LocalDate.of(2017, 10, 31)));
		periodeRepository.save(new Periode(LocalDate.of(2017, 11, 1), LocalDate.of(2017, 11, 30)));
		periodeRepository.save(new Periode(LocalDate.of(2017, 12, 1), LocalDate.of(2017, 12, 31)));
		
		Utilisateur utilisateur = new Utilisateur();
		
		utilisateur.setEstActif(true);
		utilisateur.setMotDePasse(passwordEncoder.encode("lala"));
		utilisateur.setNomUtilisateur("joris");
		utilisateur.setRole(ROLES.ROLE_ADMINISTRATEUR);
		
		
		utilisateurRepository.save(utilisateur);
		
		utilisateur = new Utilisateur();
		
		utilisateur.setEstActif(true);
		utilisateur.setMotDePasse(passwordEncoder.encode("lala"));
		utilisateur.setNomUtilisateur("charles");
		utilisateur.setRole(ROLES.ROLE_UTILISATEUR);
		
		
		utilisateurRepository.save(utilisateur);
		
		
		
	}

}
