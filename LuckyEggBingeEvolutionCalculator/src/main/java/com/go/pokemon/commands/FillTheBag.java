/**
 * 
 */
package com.go.pokemon.commands;

import com.go.pokemon.beans.CurrentInventory;

/**
 * @author asubramanian
 *
 */
public class FillTheBag implements LuckyEggBingeEvolutionCommand {

	private static FillTheBag fillTheBag = new FillTheBag();
	
	private boolean optimizedEvolution = true;

	/**
	 * 
	 */
	private FillTheBag() {
	}

	public static FillTheBag getInstance(boolean optimizedEvolution) {
		fillTheBag.optimizedEvolution = optimizedEvolution;
		return fillTheBag;
	}

	@Override
	public void execute(CurrentInventory currentInventory) {
		int numOfPokemonsToFillTheBag;
		if (optimizedEvolution) {
			int numberOfCandyNeeded = currentInventory.getMaxCandyNeededPerEgg() - currentInventory.getCurrentAvailableCandy();
			int numberOfPokemonsNeeded = CurrentInventory.MAX_EVOLUTION_PER_EGG - currentInventory.getCurrentBagSize(); 
			if (numberOfCandyNeeded <= 0 && numberOfPokemonsNeeded <= 0) return;
			int optimalNumberOfPokemonsNeeded;
			if (numberOfCandyNeeded > 0 && numberOfPokemonsNeeded > 0) {
				float numberOfPokemonsNeededFloat = numberOfCandyNeeded / Float.valueOf(CurrentInventory.MAX_CANDY_PER_POKEMON_CAUGHT);
				optimalNumberOfPokemonsNeeded = 
						(((Double) Math.ceil(numberOfPokemonsNeededFloat)).intValue() > numberOfPokemonsNeeded) 
						? ((Double) Math.ceil(numberOfPokemonsNeededFloat)).intValue()
						: numberOfPokemonsNeeded;
			} else if (numberOfCandyNeeded > 0) {
				float numberOfPokemonsNeededFloat = numberOfCandyNeeded / Float.valueOf(CurrentInventory.MAX_CANDY_PER_POKEMON_CAUGHT);
				optimalNumberOfPokemonsNeeded = ((Double) Math.ceil(numberOfPokemonsNeededFloat)).intValue();
			} else {
				optimalNumberOfPokemonsNeeded = numberOfPokemonsNeeded;
			}
			if (currentInventory.getCurrentBagSize() + optimalNumberOfPokemonsNeeded > CurrentInventory.MAX_BAG_SIZE) {
				numOfPokemonsToFillTheBag = CurrentInventory.MAX_BAG_SIZE - currentInventory.getCurrentBagSize();
			} else {
				numOfPokemonsToFillTheBag = optimalNumberOfPokemonsNeeded;
			}
		} else {
			numOfPokemonsToFillTheBag = CurrentInventory.MAX_BAG_SIZE - currentInventory.getCurrentBagSize();
		}
		currentInventory.setCurrentBagSize(numOfPokemonsToFillTheBag + currentInventory.getCurrentBagSize());
		currentInventory.setCurrentAvailableCandy(currentInventory.getCurrentAvailableCandy() + numOfPokemonsToFillTheBag * CurrentInventory.MAX_CANDY_PER_POKEMON_CAUGHT);
		currentInventory.setExperienceAccumulated(currentInventory.getExperienceAccumulated() + numOfPokemonsToFillTheBag * CurrentInventory.MIN_EXPERIENCE_GAINED_PER_POKEMON_CAUGHT);
		currentInventory.setPokeballsNeeded(currentInventory.getPokeballsNeeded() + numOfPokemonsToFillTheBag);
	}

}
