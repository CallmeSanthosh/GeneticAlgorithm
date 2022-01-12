package mu.javaproject.ga.crossover;

import java.util.Random;

import mu.javaproject.ga.population.Individual;
import mu.javaproject.ga.population.Population;

/**
 * This class is used to take two points from the parents and to swap the genes
 * to perform the crossover Operation, it implements @see GeneticFunctions
 *
 */

public class TwoPointCrossover implements Crossover {

	public TwoPointCrossover(Population population) {
		performCrossover(population);
	}

	/**
	 * @param population
	 * @return population
	 * @purpose This function executes the operation of the TwoPointCrossover
	 *          genetic function
	 */

	public Population performCrossover(Population population) {

		Random randomNum = new Random();

		int crossPoint1 = randomNum.nextInt(Individual.geneLength - 4);
		int crossPoint2 = crossPoint1 + 3;

		for (int i = 0; i < Individual.geneLength; i++) {
			if (i > crossPoint1 && i < crossPoint2) {
				int temp = population.getFittestIndividual().getGenes().get(i);
				population.getFittestIndividual().getGenes().set(i,
						population.getSecondFittestIndividual().getGenes().get(i));
				population.getSecondFittestIndividual().getGenes().set(i, temp);
			}
		}
		return population;
	}
}
