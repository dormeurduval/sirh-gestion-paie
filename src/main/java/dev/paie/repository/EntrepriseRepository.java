/**
 * 
 */
package dev.paie.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import dev.paie.entite.*;

public interface EntrepriseRepository extends JpaRepository<Entreprise, Integer> {

}

