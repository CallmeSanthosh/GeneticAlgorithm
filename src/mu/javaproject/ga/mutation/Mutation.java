package mu.javaproject.ga.mutation;

import mu.javaproject.ga.population.Population;

/**
 * This class will execute the mutation Operation of the Genetic Algorithm.
 * every subclass should implemente the muation method.
 * Also,This class takes in a population and returns it.
 *
 */

public interface Mutation {
    /**
     * All subclasses will define this method.
     *
     * @param population is the 'Population Object'.
     * @return Population
     */

    public abstract Population mutate(Population population);
}