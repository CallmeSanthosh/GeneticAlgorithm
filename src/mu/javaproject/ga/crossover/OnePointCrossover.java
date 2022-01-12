package mu.javaproject.ga.crossover;

import java.util.Random;

import mu.javaproject.ga.population.Individual;
import mu.javaproject.ga.population.Population;

/**
 * This class is used to take one single point * from the parents and to swap
 * the genes to perform the crossover operation, * it implements @see
 * GeneticFunctions
 *
 */

public class OnePointCrossover implements Crossover {

	public OnePointCrossover(Population population) {
		performCrossover(population);
	}

	/**
	 * @param population
	 * @return population
	 * @purpose This function executes the operation of the OnePointCrossover
	 *          genetic function
	 */

	public Population performCrossover(Population population) {
		Random randomNum = new Random();

		// Select a random crossover point from default Random Class
		int crossOverPoint = randomNum.nextInt(Individual.geneLength);

		// Swap values among fittest Individuals
		for (int i = 0; i < crossOverPoint; i++) {
			int temp = population.getFittestIndividual().getGenes().get(i);
			population.getFittestIndividual().getGenes().set(i,
					population.getSecondFittestIndividual().getGenes().get(i));
			population.getSecondFittestIndividual().getGenes().set(i, temp);
		}
		return population;
	}
}
