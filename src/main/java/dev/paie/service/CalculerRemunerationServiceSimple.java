/**
 * 
 */
package dev.paie.service;

import java.math.BigDecimal;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.Cotisation;
import dev.paie.entite.ResultatCalculRemuneration;
import dev.paie.util.PaieUtils;

/**
 * @author joris
 *
 */
@Service
public class CalculerRemunerationServiceSimple implements CalculerRemunerationService {
	
	//@Autowired private PaieUtils paieUtils;


	@Override
	@Transactional
	public ResultatCalculRemuneration calculer(BulletinSalaire bulletin) {
		PaieUtils paieUtils = new PaieUtils();
		ResultatCalculRemuneration resultat=new ResultatCalculRemuneration();
		
		BigDecimal salaireBase = bulletin.getRemunerationEmploye().getGrade().getNbHeuresBase().multiply
				(bulletin.getRemunerationEmploye().getGrade().getTauxBase());
		BigDecimal salaireBrut = salaireBase.add(bulletin.getPrimeExceptionnelle());
			
		
		resultat.setSalaireBrut(paieUtils.formaterBigDecimal(salaireBrut));
		
		salaireBrut = new BigDecimal(resultat.getSalaireBrut());
		
		BigDecimal non_imposable= new BigDecimal(0);
		BigDecimal imposable= new BigDecimal(0);
		List<Cotisation> l = bulletin.getRemunerationEmploye().getProfilRemuneration().getCotisationsNonImposables();
		for(Cotisation c:l){
			if(c.getTauxSalarial()!=null){
				non_imposable=non_imposable.add(c.getTauxSalarial().multiply(salaireBrut));
			}
			
			if(c.getTauxPatronal()!=null){
				imposable=imposable.add(c.getTauxPatronal().multiply(salaireBrut));
			}
		}
		
		resultat.setTotalRetenueSalarial(paieUtils.formaterBigDecimal(non_imposable));
	
		resultat.setTotalCotisationsPatronales(paieUtils.formaterBigDecimal(imposable));
		
		BigDecimal netimposable = salaireBrut.add(new BigDecimal(resultat.getTotalRetenueSalarial()).negate());
		
		resultat.setNetImposable(paieUtils.formaterBigDecimal(netimposable));
		
		netimposable = new BigDecimal(resultat.getNetImposable());
		
		BigDecimal sommeImposable= new BigDecimal(0);
		List<Cotisation> lImposable = bulletin.getRemunerationEmploye().getProfilRemuneration().getCotisationsImposables();
		for(Cotisation c:lImposable){
			if(c.getTauxSalarial()!=null){
				sommeImposable=sommeImposable.add(c.getTauxSalarial().multiply(salaireBrut));
			}
			
		}
		
		resultat.setNetAPayer(paieUtils.formaterBigDecimal(netimposable.add(sommeImposable.negate())));
		
		return resultat;
	}


}
