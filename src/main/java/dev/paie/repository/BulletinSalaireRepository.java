/**
 * 
 */
package dev.paie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.paie.entite.Avantage;
import dev.paie.entite.BulletinSalaire;

/**
 * @author joris
 *
 */
public interface BulletinSalaireRepository extends JpaRepository<BulletinSalaire, Integer> {

}
