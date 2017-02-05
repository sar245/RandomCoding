/**
 * 
 */
package com.go.pokemon.commands;

import com.go.pokemon.beans.CurrentInventory;

/**
 * @author asubramanian
 *
 */
public class TransferToProfessorWillow implements LuckyEggBingeEvolutionCommand {

	private static TransferToProfessorWillow transferToProfessorWillow = new TransferToProfessorWillow();

	private boolean optimizedEvolution = true;

	/**
	 * 
	 */
	private TransferToProfessorWillow() {
	}

	public static TransferToProfessorWillow getInstance(
			boolean optimizedEvolution) {
		transferToProfessorWillow.optimizedEvolution = optimizedEvolution;
		return transferToProfessorWillow;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.go.pokemon.commands.Command#execute()
	 */
	@Override
	public void execute(CurrentInventory currentInventory) {
		if (optimizedEvolution) {
			int numberOfCandyNeeded = currentInventory
					.getMaxCandyNeededPerEgg()
					- currentInventory.getCurrentAvailableCandy();
			if (numberOfCandyNeeded <= 0)
				return;
			if (numberOfCandyNeeded >= CurrentInventory.MAX_BAG_SIZE) {
				currentInventory.setCurrentBagSize(0);
				currentInventory.setCurrentAvailableCandy(currentInventory
						.getCurrentAvailableCandy()
						+ CurrentInventory.MAX_BAG_SIZE);
			} else {
				currentInventory.setCurrentBagSize(currentInventory
						.getCurrentBagSize() - numberOfCandyNeeded);
				currentInventory.setCurrentAvailableCandy(currentInventory
						.getCurrentAvailableCandy() + numberOfCandyNeeded);
			}
		} else {
			currentInventory.setCurrentBagSize(0);
			currentInventory
					.setCurrentAvailableCandy(currentInventory
							.getCurrentAvailableCandy()
							+ CurrentInventory.MAX_BAG_SIZE);
		}
	}

}
