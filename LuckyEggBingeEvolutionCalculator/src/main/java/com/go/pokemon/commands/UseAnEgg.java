/**
 * 
 */
package com.go.pokemon.commands;

import com.go.pokemon.beans.CurrentInventory;

/**
 * @author asubramanian
 *
 */
public class UseAnEgg implements LuckyEggBingeEvolutionCommand {

	private static UseAnEgg useAnEgg = new UseAnEgg();

	/**
	 * 
	 */
	private UseAnEgg() {
	}

	public static UseAnEgg getInstance() {
		return useAnEgg;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.go.pokemon.commands.Command#execute()
	 */
	@Override
	public void execute(CurrentInventory currentInventory) {
		currentInventory.setCurrentBagSize(currentInventory.getCurrentBagSize()
				- CurrentInventory.MAX_EVOLUTION_PER_EGG);
		currentInventory.setCurrentAvailableCandy(currentInventory
				.getCurrentAvailableCandy()
				- CurrentInventory.MAX_EVOLUTION_PER_EGG
				* currentInventory.getPokemonCandyMultiplier()
				+ CurrentInventory.MAX_EVOLUTION_PER_EGG);
		currentInventory
				.setUpgradedPokemon(CurrentInventory.MAX_EVOLUTION_PER_EGG);
		currentInventory
				.setExperienceAccumulated(currentInventory
						.getExperienceAccumulated()
						+ CurrentInventory.MAX_EVOLUTION_PER_EGG
						* CurrentInventory.EXPERIENCE_GAINED_PER_POKEMON_EVOLVED_WHEN_USING_EGG);
		currentInventory.setEggsHatchedCount(currentInventory
				.getEggsHatchedCount() + 1);
	}

}
