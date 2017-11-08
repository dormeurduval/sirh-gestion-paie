/**
 * 
 */
package dev.paie.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import dev.paie.config.ServicesConfig;
import dev.paie.config.WebAppConfig;
import dev.paie.service.InitialiserDonneesService;
import dev.paie.service.InitialiserDonneesServiceDev;
import dev.paie.spring.DataSourceMySQLConfig;
import dev.paie.spring.JpaConfig;

@Component
class EventListenersDemarage {
	
	@Autowired
	private InitialiserDonneesService initialiserDonnees;	

    @EventListener({ContextRefreshedEvent.class})
    void contextRefreshedEvent() {
    	initialiserDonnees.initialiser();
    }
}    

