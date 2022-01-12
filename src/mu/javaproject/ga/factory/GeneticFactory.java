package mu.javaproject.ga.factory;

import java.util.Random;

import mu.javaproject.ga.crossover.Crossover;
import mu.javaproject.ga.factory.GeneticConfigurationStrategy.OperationType;
import mu.javaproject.ga.mutation.Mutation;
import mu.javaproject.ga.selection.Selection;

/**
 * This is the Abstract Interface for Abstract factory pattern GeneticFactory class, which is where
 * the user communicates with and requests a specific version of a Genetic
 * algorithm.
 * 
 */

interface GeneticFactory {

//	GeneticFactory random;

	/**
	 * In all relevant configs, this method is defined. This is changed by each
	 * individual to fit their own needs.
	 *
	 * @param type
	 * @param population
	 * @return Selection
	 */
	 Selection selectionChoice();

	/**
	 * In all relevant configs, this method is defined. This is changed by each
	 * individual to fit their own needs.
	 *
	 * @param point
	 * @param population
	 * @return Crossover
	 */

	Crossover crossoverChoice();

	/**
	 * In all relevant configs, this method is defined. This is changed by each
	 * individual to fit their own needs.
	 *
	 * @param mutationPoint
	 * @param population
	 * @return Mutation
	 */

	Mutation mutationChance();

}
