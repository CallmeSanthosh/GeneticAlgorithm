package mu.javaproject.ga.mutation;

import java.util.Random;

import mu.javaproject.ga.population.Individual;
import mu.javaproject.ga.population.Population;

/**
 * RandomMutation is a class that deals with random mutations.
 * This is one method of mutation, which is completely random. It belongs to the Mutation interface as a subclass.
 *
 */

public class RandomMutation implements Mutation {
    /**
     * This will invoke the population's original mutate method.
     *
     *  @param population This is the population on which work is being performed.
     */

    public RandomMutation(Population population) {
        mutate(population);
    }

    /**
     * By swapping values with the Individuals, this method performs the mutation.
     *
     * @param population This is the population on which work is being performed.
     * @return Population
     */

    public Population mutate(Population population) {
        Random randomNum = new Random();

        // Choose a mutation point at random.
        // The loop mutation will occur at random intervals.
        
        for(int i =0;i<randomNum.nextInt(Individual.geneLength);i++) {
        	int mutationPoint = randomNum.nextInt(Individual.geneLength);

        // Flip values at the mutation point
        	if (population.getFittestIndividual().getGenes().get(mutationPoint) == 1) {
            population.getFittestIndividual().getGenes().set(mutationPoint, 0);
        	} else {
            population.getFittestIndividual().getGenes().set(mutationPoint, 1);
        	}
        }

        return population;
    }
}