package masivian.test.roulettebetting.objects;

import javax.validation.constraints.NotNull;

public class Roulette {

	@NotNull
	private String idRoulette;
	@NotNull
	private String rouletteStatus;
	
	

	public Roulette() {
		super();
	}

	public Roulette(@NotNull String idRoulette, @NotNull String rouletteStatus) {
		super();
		this.idRoulette = idRoulette;
		this.rouletteStatus = rouletteStatus;
	}

	/**
	 * @return the idRoulette
	 */
	public String getIdRoulette() {
		return idRoulette;
	}

	/**
	 * @param idRoulette the idRoulette to set
	 */
	public void setIdRoulette(String idRoulette) {
		this.idRoulette = idRoulette;
	}

	/**
	 * @return the rouletteStatus
	 */
	public String getRouletteStatus() {
		return rouletteStatus;
	}

	/**
	 * @param rouletteStatus the rouletteStatus to set
	 */
	public void setRouletteStatus(String rouletteStatus) {
		this.rouletteStatus = rouletteStatus;
	}

	@Override
	public String toString() {
		return "Roulette [idRoulette=" + idRoulette + ", rouletteStatus=" + rouletteStatus + "]";
	}

}
