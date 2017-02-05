/**
 * 
 */
package com.go.pokemon.calculator;

import com.go.pokemon.beans.CurrentInventory;
import com.go.pokemon.beans.LuckyEggBingeEvolutionEnum;
import com.go.pokemon.factory.LuckyEggBingeEvolutionFactory;

/**
 * @author asubramanian
 *
 */
public class LuckyEggBingeEvolutionCalculator {

	private static final boolean optimizedEvolution = true;

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		CurrentInventory currentInventory = new CurrentInventory();
		if (args != null && args.length == 1) {
			currentInventory.setPokemonCandyMultiplier(Integer
					.parseInt(args[0]));
		} else {
			System.out
					.println("Did not get a value for pokemon candy multiplier, using default value of 12 (Pidgey settings)");
		}

		while (currentInventory.getEggsHatchedCount() < CurrentInventory.MAX_EGGS) {
			if (currentInventory.getCurrentAvailableCandy() >= currentInventory
					.getMaxCandyNeededPerEgg()
					&& currentInventory.getCurrentBagSize() >= CurrentInventory.MAX_EVOLUTION_PER_EGG) {
				LuckyEggBingeEvolutionFactory.getCommand(
						LuckyEggBingeEvolutionEnum.USE_AN_EGG,
						optimizedEvolution).execute(currentInventory);
				currentInventory
						.writeToFile(LuckyEggBingeEvolutionEnum.USE_AN_EGG);
			} else if (currentInventory.getCurrentBagSize() == CurrentInventory.MAX_BAG_SIZE
					&& currentInventory.getCurrentAvailableCandy() < currentInventory
							.getMaxCandyNeededPerEgg()) {
				LuckyEggBingeEvolutionFactory
						.getCommand(
								LuckyEggBingeEvolutionEnum.TRANSFER_TO_PROFESSOR_WILLOW,
								optimizedEvolution).execute(currentInventory);
				currentInventory
						.writeToFile(LuckyEggBingeEvolutionEnum.TRANSFER_TO_PROFESSOR_WILLOW);
			} else if (currentInventory.getCurrentAvailableCandy() < currentInventory
					.getMaxCandyNeededPerEgg()
					|| currentInventory.getCurrentBagSize() < CurrentInventory.MAX_EVOLUTION_PER_EGG) {
				LuckyEggBingeEvolutionFactory.getCommand(
						LuckyEggBingeEvolutionEnum.FILL_THE_BAG,
						optimizedEvolution).execute(currentInventory);
				currentInventory
						.writeToFile(LuckyEggBingeEvolutionEnum.FILL_THE_BAG);
			}
		}
	}

}
