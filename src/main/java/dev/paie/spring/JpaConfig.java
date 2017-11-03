/**
 * 
 */
package dev.paie.spring;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan({"dev.paie.service","dev.paie.spring","dev.paie.entite","dev.paie.util"})
@EnableTransactionManagement
public class JpaConfig {

	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {

	JpaTransactionManager txManager = new JpaTransactionManager();

	txManager.setEntityManagerFactory(emf);

	return txManager;
 }

// Cette configuration nécessite une source de données configurée.
// Elle s'utilise donc en association avec un autre fichier de configuration d
  //éfinissant un

	@Bean
	public EntityManagerFactory entityManagerFactory(DataSource dataSource) {

		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setGenerateDdl(true);
		
		vendorAdapter.setShowSql(true);
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		
		factory.setJpaVendorAdapter(vendorAdapter);
		
		factory.setPackagesToScan("dev.paie.entite");
		factory.setDataSource(dataSource);
		factory.afterPropertiesSet();
		return factory.getObject();
	}
}