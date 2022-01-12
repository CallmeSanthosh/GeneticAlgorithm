package mu.javaproject.ga.factory;

import java.util.Random;

import mu.javaproject.ga.crossover.Crossover;
import mu.javaproject.ga.crossover.OnePointCrossover;
import mu.javaproject.ga.crossover.TwoPointCrossover;
import mu.javaproject.ga.factory.GeneticConfigurationStrategy.OperationType;
import mu.javaproject.ga.mutation.Mutation;
import mu.javaproject.ga.mutation.RandomMutation;
import mu.javaproject.ga.mutation.SubstituteMutation;
import mu.javaproject.ga.population.Population;
import mu.javaproject.ga.selection.RandomSelection;
import mu.javaproject.ga.selection.RankSelection;
import mu.javaproject.ga.selection.Selection;

/**
 * The core class for all operations is GeneticAlgorithmRunner. This class
 * implements the factory design pattern, which manages the instantiation
 * *(creation) of various Selection, Reproduction (/Mutation) * or (/Crossover)
 * objects.
 *
 * * executeGeneticOperations() is a method for creating Selection, Crossover, and
 * Mutation objects. Two classes "RandomTypeFactory" and "RegularTypeFactory"
 * are extending this GeneticFactory class. These two classes will perform the
 * Specific type of genetic operations, For example, RandomFactory will perform
 * random Genetic operations such as random selection and random mutation and
 * RegularFactory will perform regular Genetic Operations such as Ranked
 * Selection and Substitute Mutation
 *
 */

public class GeneticConfigurationStrategy {
	/**
	 * 
	 * 
	 * Strategy Design pattern to allow different GA Selection,Crossover or Mutation
	 * Implementations(or strategies) at run-time
	 * 
	 * It chooses which factory from "Random Factory" or "Regular factory" to
	 * execute at run time.
	 */

	public enum OperationType {
		RANDOM, REGULAR
	};

	public OperationType randomOperationType() {
		OperationType[] values = OperationType.values();
		int length = values.length;
		int randIndex = new Random().nextInt(length);
		return values[randIndex];

	}

	public GeneticFactory executeGeneticOperations(Population population) {
		if (randomOperationType() == OperationType.RANDOM) {
			return (GeneticFactory) new RandomTypeFactory(population);
		} else {
			return (GeneticFactory) new RegularTypeFactory(population);
		}
	}

}
