/**
 * 
 */
package dev.paie.entite;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Utilisateur {
	
	public enum ROLES {
		ROLE_ADMINISTRATEUR,ROLE_UTILISATEUR
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column
	private String nomUtilisateur;
	@Column
	private String motDePasse;
	@Column
	private Boolean estActif;
	@Enumerated(EnumType.STRING)
	private ROLES role;
	
	public Utilisateur(){
		
	}
	
	/** getters
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/** Setter
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/** getters
	 * @return the nomUtilisateur
	 */
	public String getNomUtilisateur() {
		return nomUtilisateur;
	}
	/** Setter
	 * @param nomUtilisateur the nomUtilisateur to set
	 */
	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}
	/** getters
	 * @return the motDePasse
	 */
	public String getMotDePasse() {
		return motDePasse;
	}
	/** Setter
	 * @param motDePasse the motDePasse to set
	 */
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	/** getters
	 * @return the estActif
	 */
	public Boolean getEstActif() {
		return estActif;
	}
	/** Setter
	 * @param estActif the estActif to set
	 */
	public void setEstActif(Boolean estActif) {
		this.estActif = estActif;
	}
	/** getters
	 * @return the role
	 */
	public ROLES getRole() {
		return role;
	}
	/** Setter
	 * @param role the role to set
	 */
	public void setRole(ROLES role) {
		this.role = role;
	}
	
	
}
