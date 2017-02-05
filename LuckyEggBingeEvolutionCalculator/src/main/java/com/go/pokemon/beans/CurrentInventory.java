/**
 * 
 */
package com.go.pokemon.beans;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author asubramanian
 *
 */
public class CurrentInventory {

	public static final int MAX_CANDY_PER_POKEMON_CAUGHT = 3;
	public static final int MAX_BAG_SIZE = 250;
	public static final int MAX_POKEMON_UPGRADES_IN_ONE_EGG = 60;
	public static final int MAX_EGGS = 25;
	public static final int MAX_EVOLUTION_PER_EGG = 60;
	public static final int MIN_EXPERIENCE_GAINED_PER_POKEMON_CAUGHT = 100;
	public static final int EXPERIENCE_GAINED_PER_POKEMON_EVOLVED_WHEN_USING_EGG = 1000;
	private static final String PIPELINE_SEPERATOR = "|";
	private static final String NEW_LINE_SEPERATOR ="\n";
	private static final String HEADER = "Operation|Current Bag Size|Current Available Candy|Upgraded Pokemon|Eggs Hatched|Experience Accumulated|Minimum Pokeballs Needed";
	private int currentBagSize = 0;
	private int currentAvailableCandy = 0;
	private int experienceAccumulated = 0;
	private int minimumPokeballsNeeded = 0;
	private int upgradedPokemon = 0;
	private int pokemonCandyMultiplier = 12;
	private int eggsHatchedCount = 0;
	private String fileName;

	/**
	 * @return the currentBagSize
	 */
	public int getCurrentBagSize() {
		return currentBagSize;
	}

	/**
	 * @param currentBagSize
	 *            the currentBagSize to set
	 */
	public void setCurrentBagSize(int currentBagSize) {
		this.currentBagSize = currentBagSize;
	}

	/**
	 * @return the currentAvailableCandy
	 */
	public int getCurrentAvailableCandy() {
		return currentAvailableCandy;
	}

	/**
	 * @param currentAvailableCandy
	 *            the currentAvailableCandy to set
	 */
	public void setCurrentAvailableCandy(int currentAvailableCandy) {
		this.currentAvailableCandy = currentAvailableCandy;
	}

	/**
	 * @return the experienceAccumulated
	 */
	public int getExperienceAccumulated() {
		return experienceAccumulated;
	}

	/**
	 * @param experienceAccumulated
	 *            the experienceAccumulated to set
	 */
	public void setExperienceAccumulated(int experienceAccumulated) {
		this.experienceAccumulated = experienceAccumulated;
	}

	/**
	 * @return the minimumPokeballsNeeded
	 */
	public int getPokeballsNeeded() {
		return minimumPokeballsNeeded;
	}

	/**
	 * @param minimumPokeballsNeeded the minimumPokeballsNeeded to set
	 */
	public void setPokeballsNeeded(int minimumPokeballsNeeded) {
		this.minimumPokeballsNeeded = minimumPokeballsNeeded;
	}

	/**
	 * @return the upgradedPokemon
	 */
	public int getUpgradedPokemon() {
		return upgradedPokemon;
	}

	/**
	 * @param upgradedPokemon
	 *            the upgradedPokemon to set
	 */
	public void setUpgradedPokemon(int upgradedPokemon) {
		this.upgradedPokemon = upgradedPokemon;
	}

	/**
	 * @return the pokemonCandyMultiplier
	 */
	public int getPokemonCandyMultiplier() {
		return pokemonCandyMultiplier;
	}

	/**
	 * @param pokemonCandyMultiplier
	 *            the pokemonCandyMultiplier to set
	 */
	public void setPokemonCandyMultiplier(int pokemonCandyMultiplier) {
		this.pokemonCandyMultiplier = pokemonCandyMultiplier;
	}

	/**
	 * @return the eggsHatchedCount
	 */
	public int getEggsHatchedCount() {
		return eggsHatchedCount;
	}

	/**
	 * @param eggsHatchedCount
	 *            the eggsHatchedCount to set
	 */
	public void setEggsHatchedCount(int eggsHatchedCount) {
		this.eggsHatchedCount = eggsHatchedCount;
	}

	public int getMaxCandyNeeded() {
		return MAX_EGGS * getMaxCandyNeededPerEgg();
	}

	public int getMaxCandyNeededPerEgg() {
		return MAX_EVOLUTION_PER_EGG * pokemonCandyMultiplier;
	}
	
	public void writeToFile(LuckyEggBingeEvolutionEnum operation) {
		BufferedWriter bw = null;
		FileWriter fw = null;
		try {
			StringBuffer data = new StringBuffer().append(operation).append(CurrentInventory.PIPELINE_SEPERATOR)
					.append(currentBagSize).append(CurrentInventory.PIPELINE_SEPERATOR)
					.append(currentAvailableCandy).append(CurrentInventory.PIPELINE_SEPERATOR)
					.append(upgradedPokemon).append(CurrentInventory.PIPELINE_SEPERATOR)
					.append(eggsHatchedCount).append(CurrentInventory.PIPELINE_SEPERATOR)
					.append(experienceAccumulated).append(CurrentInventory.PIPELINE_SEPERATOR)
					.append(minimumPokeballsNeeded).append(CurrentInventory.NEW_LINE_SEPERATOR);
			if (fileName == null) {
				fileName = "Output" + System.currentTimeMillis() + ".csv";
			}
			File file = new File(fileName);
			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
				data.insert(0, CurrentInventory.NEW_LINE_SEPERATOR);
				data.insert(0, CurrentInventory.HEADER);
			}

			// true = append file
			fw = new FileWriter(file.getAbsoluteFile(), true);
			bw = new BufferedWriter(fw);
			bw.write(data.toString());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
				if (fw != null)
					fw.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CurrentInventory [currentBagSize=")
				.append(currentBagSize).append(", currentAvailableCandy=")
				.append(currentAvailableCandy)
				.append(", experienceAccumulated=")
				.append(experienceAccumulated).append(", minimumPokeballsNeeded=")
				.append(minimumPokeballsNeeded).append(", upgradedPokemon=")
				.append(upgradedPokemon).append(", pokemonCandyMultiplier=")
				.append(pokemonCandyMultiplier).append(", eggsHatchedCount=")
				.append(eggsHatchedCount).append("]");
		return builder.toString();
	}

}
