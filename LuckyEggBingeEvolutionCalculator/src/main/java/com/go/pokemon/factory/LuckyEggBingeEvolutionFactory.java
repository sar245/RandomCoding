package com.go.pokemon.factory;

import com.go.pokemon.beans.CurrentInventory;
import com.go.pokemon.beans.LuckyEggBingeEvolutionEnum;
import com.go.pokemon.commands.LuckyEggBingeEvolutionCommand;
import com.go.pokemon.commands.FillTheBag;
import com.go.pokemon.commands.TransferToProfessorWillow;
import com.go.pokemon.commands.UseAnEgg;

/**
 * 
 */

/**
 * @author asubramanian
 *
 */
public class LuckyEggBingeEvolutionFactory {
	public static LuckyEggBingeEvolutionCommand getCommand(
			LuckyEggBingeEvolutionEnum operation, boolean optimizedEvolution) {
		switch (operation) {
		case FILL_THE_BAG:
			return FillTheBag.getInstance(optimizedEvolution);
		case TRANSFER_TO_PROFESSOR_WILLOW:
			return TransferToProfessorWillow.getInstance(optimizedEvolution);
		case USE_AN_EGG:
			return UseAnEgg.getInstance();
		default:
			break;
		}
		return null;
	}

}
