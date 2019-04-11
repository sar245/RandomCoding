/**
 * 
 */
package com.some.queue.implementation;

/**
 * @author Arun Ramachandran
 *
 */
public class PetrolPump {

	int petrol;
	int distance;

	// constructor
	public PetrolPump(int petrol, int distance) {
		this.petrol = petrol;
		this.distance = distance;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PetrolPump [petrol=" + petrol + ", distance=" + distance + "]";
	}

}
