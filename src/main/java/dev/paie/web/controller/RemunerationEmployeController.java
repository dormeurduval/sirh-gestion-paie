/**
 * 
 */
package dev.paie.web.controller;

import java.util.Date;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.Entreprise;
import dev.paie.entite.Grade;
import dev.paie.entite.Periode;
import dev.paie.entite.ProfilRemuneration;
import dev.paie.entite.RemunerationEmploye;
import dev.paie.entite.ResultatCalculRemuneration;
import dev.paie.repository.BulletinSalaireRepository;
import dev.paie.repository.EntrepriseRepository;
import dev.paie.repository.GradeRepository;
import dev.paie.repository.PeriodeRepository;
import dev.paie.repository.ProfilRemunerationRepository;
import dev.paie.repository.RemunerationEmployeRepository;
import dev.paie.service.CalculerRemunerationServiceSimple;

@Controller
@RequestMapping("/employes")
public class RemunerationEmployeController {
	
	@Autowired
	private BulletinSalaireRepository bulletinSalaireRepository;
	
	@Autowired
	private EntrepriseRepository entrepriseRepository;
	
	@Autowired
	private GradeRepository gradeRepository;
	
	@Autowired
	private ProfilRemunerationRepository profilRemunerationRepository;
	
	@Autowired
	private RemunerationEmployeRepository remunerationEmployeRepository;
	
	@Autowired
	private PeriodeRepository periodeRepository;
	
	@Secured({"ROLE_UTILISATEUR", "ROLE_ADMINISTRATEUR"})
	@RequestMapping(method = RequestMethod.GET, path = "/creer")
	public ModelAndView formulaireEmploye() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("employes/creerEmploye");
		List<Entreprise> entreprises = entrepriseRepository.findAll();
		mv.addObject("entreprises",entreprises);
		
		List<Grade> grades = gradeRepository.findAll();
		mv.addObject("grades",grades);
		
		List<ProfilRemuneration> profilRemunerations = profilRemunerationRepository.findAll();
		mv.addObject("profilRemunerations",profilRemunerations);
		return mv;
	}
	
	@Secured("ROLE_ADMINISTRATEUR")
	@RequestMapping(method = RequestMethod.POST, path = "/creer")
	public ModelAndView creerEmploye(@RequestParam("entreprise") String entreprise,
	@RequestParam("matricule") String matricule,@RequestParam("profilRemuneration") String profilRemuneration,
	@RequestParam("grade") String grade) {
		ModelAndView mv = new ModelAndView();
		
		RemunerationEmploye remunerationEmploye = new RemunerationEmploye();
		
		remunerationEmploye.setMatricule(matricule);
		
		
		List<Entreprise> entreprises = entrepriseRepository.findAll();
		List<Grade> grades = gradeRepository.findAll();
		List<ProfilRemuneration> profilRemunerations = profilRemunerationRepository.findAll();
		
		remunerationEmploye.setEntreprise(entreprises.stream().filter(e->e.getDenomination().equals(entreprise)).findFirst().get());
		
		remunerationEmploye.setGrade(grades.stream().filter(g->g.getCode().equals(grade)).findFirst().get());
		
		remunerationEmploye.setProfilRemuneration(profilRemunerations.stream().filter(p->p.getCode().equals(profilRemuneration)).findFirst().get());
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		
		remunerationEmploye.setCreationDate(new Date());
		
		remunerationEmployeRepository.save(remunerationEmploye);
		
		mv.addObject("remunerationEmployes",remunerationEmployeRepository.findAll());
		
		mv.setViewName("employes/listeEmploye");
		return mv;
	}
	
	@Secured({"ROLE_UTILISATEUR", "ROLE_ADMINISTRATEUR"})
	@RequestMapping(method = RequestMethod.GET, path = "/lister")
	public ModelAndView creerBulletin() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("employes/creerBulletin");
		
		List<Periode> periodes = periodeRepository.findAll();
		List<String> matricules = remunerationEmployeRepository.findAll().stream().map(p->p.getMatricule()).collect(Collectors.toList());
		mv.addObject("periodes",periodes);
		mv.addObject("matricules",matricules);
		
		return mv;
	}
	
	@Secured("ROLE_ADMINISTRATEUR")
	@RequestMapping(method = RequestMethod.POST, path = "/lister")
	@Transactional
	public ModelAndView formulaireBulletin(@RequestParam("matricule") String matricule,
	@RequestParam("periode") String periode,@RequestParam("prime") String prime) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("employes/listeBulletin");
		
		BulletinSalaire bulletin = new BulletinSalaire();
		bulletin.setCreationDate(new Date());
		bulletin.setPrimeExceptionnelle(new BigDecimal(prime));
		bulletin.setRemunerationEmploye(remunerationEmployeRepository.findAll().stream().filter(e-> e.getMatricule().equals(matricule)).findFirst().get());
		bulletin.setPeriode(periodeRepository.findAll().stream().filter(p->
		p.getDateDebut().toString().equals(periode.substring(0,10)) && p.getDateFin().toString().equals(periode.substring(13))).findFirst().get());
		
		bulletinSalaireRepository.save(bulletin);
		mv.addObject("bulletinSalaires",bulletinSalaireRepository.findAll());
		
		
		bulletinSalaireRepository.findAll().stream().forEach(b->{
		CalculerRemunerationServiceSimple calculerRemunerationServiceSimple =  new CalculerRemunerationServiceSimple();
		b.setSalaireBrute(calculerRemunerationServiceSimple.calculer(b).getSalaireBrut());
		b.setNetAPayer(calculerRemunerationServiceSimple.calculer(b).getNetAPayer());
		b.setNetImposable(calculerRemunerationServiceSimple.calculer(b).getNetImposable());
		});
		mv.addObject("calculerRemunerationServiceSimple",new CalculerRemunerationServiceSimple());
		return mv;
	}
}

