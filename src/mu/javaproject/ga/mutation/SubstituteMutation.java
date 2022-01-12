package mu.javaproject.ga.mutation;

import java.util.Random;

import mu.javaproject.ga.population.Individual;
import mu.javaproject.ga.population.Population;

/**
 * This class implements @see GeneticFunctions and is used to perform permutation mutations.
 */

public class SubstituteMutation implements Mutation {
    /**
     * This will invoke the population's original mutate method.
     *
     * @param population The population object.
     */

    public SubstituteMutation(Population population) {
        mutate(population);
    }

    /**
     * This approach produces the most common type of mutation, which occurs just 10% of the time.
     *
     * @param population, The population to be worked on.
     * @return Population
     */

    public Population mutate(Population population) {
        Random random = new Random();

        int mutationPoint1 = random.nextInt(Individual.geneLength);
        int mutationPoint2;
       //For swapping, the loop and condition below will get two separate mutation points.
        
        do {
         mutationPoint2 = random.nextInt(Individual.geneLength);
        
        }while(mutationPoint1==mutationPoint2);
        
        int temp = population.getFittestIndividual().getGenes().get(mutationPoint1);
        population.getFittestIndividual().getGenes().set(mutationPoint1,  population.getSecondFittestIndividual()
                .getGenes().get(mutationPoint2));
        population.getSecondFittestIndividual().getGenes().set(mutationPoint2, temp) ;
        return population;
    }
}
