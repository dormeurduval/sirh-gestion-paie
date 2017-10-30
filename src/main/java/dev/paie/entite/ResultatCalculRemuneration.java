package dev.paie.entite;

import org.springframework.stereotype.Service;

@Service
public class ResultatCalculRemuneration {
	private String salaireDeBase;
	private String salaireBrut;
	private String totalRetenueSalarial;
	private String totalCotisationsPatronales;
	private String netImposable;
	private String netAPayer;
	/** getters
	 * @return the salaireDeBase
	 */
	public String getSalaireDeBase() {
		return salaireDeBase;
	}
	/** Setter
	 * @param salaireDeBase the salaireDeBase to set
	 */
	public void setSalaireDeBase(String salaireDeBase) {
		this.salaireDeBase = salaireDeBase;
	}
	/** getters
	 * @return the salaireBrut
	 */
	public String getSalaireBrut() {
		return salaireBrut;
	}
	/** Setter
	 * @param salaireBrut the salaireBrut to set
	 */
	public void setSalaireBrut(String salaireBrut) {
		this.salaireBrut = salaireBrut;
	}
	/** getters
	 * @return the totalRetenueSalarial
	 */
	public String getTotalRetenueSalarial() {
		return totalRetenueSalarial;
	}
	/** Setter
	 * @param totalRetenueSalarial the totalRetenueSalarial to set
	 */
	public void setTotalRetenueSalarial(String totalRetenueSalarial) {
		this.totalRetenueSalarial = totalRetenueSalarial;
	}
	/** getters
	 * @return the totalCotisationsPatronales
	 */
	public String getTotalCotisationsPatronales() {
		return totalCotisationsPatronales;
	}
	/** Setter
	 * @param totalCotisationsPatronales the totalCotisationsPatronales to set
	 */
	public void setTotalCotisationsPatronales(String totalCotisationsPatronales) {
		this.totalCotisationsPatronales = totalCotisationsPatronales;
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
	
}
