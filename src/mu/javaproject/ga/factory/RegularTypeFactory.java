package mu.javaproject.ga.factory;

import mu.javaproject.ga.crossover.Crossover;

import mu.javaproject.ga.crossover.TwoPointCrossover;
import mu.javaproject.ga.mutation.Mutation;
import mu.javaproject.ga.mutation.SubstituteMutation;
import mu.javaproject.ga.population.Population;
import mu.javaproject.ga.selection.RankSelection;
import mu.javaproject.ga.selection.Selection;

/**
 * 
 * This factory executes runtime, it executes genetic operations such as
 * Selection, Crossover and mutation, and the operations are RankedSelection,
 * Two point Selection and Substitute Mutation
 *
 */

public class RegularTypeFactory implements GeneticFactory {
	Population population;

	RegularTypeFactory(Population population) {
		this.population = population;
		selectionChoice();
		crossoverChoice();
		mutationChance();
	}

	@Override
	public Selection selectionChoice() {
		// TODO Auto-generated method stub
		return new RankSelection(population);
	}

	@Override
	public Crossover crossoverChoice() {
		// TODO Auto-generated method stub
		return new TwoPointCrossover(population);
	}

	@Override
	public Mutation mutationChance() {
		// TODO Auto-generated method stub
		return new SubstituteMutation(population);
	}

}
