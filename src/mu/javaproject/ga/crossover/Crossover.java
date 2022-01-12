package mu.javaproject.ga.crossover;

import mu.javaproject.ga.population.Population;

/**
 * Crossover is my interface and two different types of crossovers
 * -1)OnePointCrossover,2)TwoPointCrossover are implemented by the sub class
 * which invokes this interface
 *
 */

public interface Crossover {

	abstract Population performCrossover(Population population);
}
