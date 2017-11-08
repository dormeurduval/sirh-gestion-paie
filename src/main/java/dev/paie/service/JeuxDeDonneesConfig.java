package dev.paie.service;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource({"classpath:jdd-config.xml","classpath:grades.xml"})
public class JeuxDeDonneesConfig {
}
