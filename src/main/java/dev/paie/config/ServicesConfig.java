/**
 * 
 */
package dev.paie.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import dev.paie.spring.*;
@Configuration
@ComponentScan({"dev.paie.service","dev.paie.util","dev.paie.listener"})
@Import({JpaConfig.class, DataSourceMySQLConfig.class})
@EnableJpaRepositories("dev.paie.repository")
@EnableTransactionManagement

public class ServicesConfig {
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
