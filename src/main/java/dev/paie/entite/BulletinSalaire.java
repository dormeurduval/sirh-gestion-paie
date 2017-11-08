package dev.paie.entite;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="bulletin")
public class BulletinSalaire {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	private RemunerationEmploye remunerationEmploye;
	
	@ManyToOne
	private Periode periode;
	@Column
	private BigDecimal primeExceptionnelle;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDate;
	
	private String salaireBrute;
	private String netImposable;
	private String netAPayer;
	
	
	
	public BulletinSalaire(){
		
	}
	
	
	
	/** getters
	 * @return the salaireBrute
	 */
	public String getSalaireBrute() {
		return salaireBrute;
	}



	/** Setter
	 * @param salaireBrute the salaireBrute to set
	 */
	public void setSalaireBrute(String salaireBrute) {
		this.salaireBrute = salaireBrute;
	}



	/** getters
	 * @return the netImposable
	 */
	public String getNetImposable() {
		return netImposable;
	}



	/** Setter
	 * @param netImposable the netImposable to set
	 */
	public void setNetImposable(String netImposable) {
		this.netImposable = netImposable;
	}



	/** getters
	 * @return the netAPayer
	 */
	public String getNetAPayer() {
		return netAPayer;
	}



	/** Setter
	 * @param netAPayer the netAPayer to set
	 */
	public void setNetAPayer(String netAPayer) {
		this.netAPayer = netAPayer;
	}



	/** getters
	 * @return the creationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}



	/** Setter
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}



	public RemunerationEmploye getRemunerationEmploye() {
		return remunerationEmploye;
	}
	public void setRemunerationEmploye(RemunerationEmploye remunerationEmploye) {
		this.remunerationEmploye = remunerationEmploye;
	}
	public Periode getPeriode() {
		return periode;
	}
	public void setPeriode(Periode periode) {
		this.periode = periode;
	}
	public BigDecimal getPrimeExceptionnelle() {
		return primeExceptionnelle;
	}
	public void setPrimeExceptionnelle(BigDecimal primeExceptionnelle) {
		this.primeExceptionnelle = primeExceptionnelle;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	
}
