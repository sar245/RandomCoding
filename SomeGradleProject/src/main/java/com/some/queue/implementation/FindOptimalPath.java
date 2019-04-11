/**
 * 
 */
package com.some.queue.implementation;

/**
 * @author Arun Ramachandran
 *
 */
public class FindOptimalPath {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Queue<PetrolPump> queue = new Queue<PetrolPump>();

		// {4, 6}, {6, 5}, {7, 3} and {4, 5}
		PetrolPump p1 = new PetrolPump(4, 6);
		PetrolPump p2 = new PetrolPump(6, 5);
		PetrolPump p3 = new PetrolPump(7, 3);
		PetrolPump p4 = new PetrolPump(4, 5);

		PetrolPump[] p = { p1, p2, p3, p4 };
		for (int i = 0; i < p.length; i++) {
			for (int j = i; j < i + p.length; j++) {
				queue.enqueue(p[j % p.length]);
			}
			if (checkForFullCircle(queue)) {
				System.out.println("Result is : " + i);
				break;
			}
			queue = new Queue<PetrolPump>();
		}

	}

	private static boolean checkForFullCircle(Queue<PetrolPump> queue) {
		int mileage = 0;
		while (!queue.isEmpty()) {
			PetrolPump p = queue.dequeue();
			mileage += -p.distance + p.petrol;
			if (mileage < 0) {
				return false;
			}
		}
		return true;
	}
}
