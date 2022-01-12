package mu.javaproject.ga.selection;

import mu.javaproject.ga.population.Population;

public interface Selection {
    /**
     * Each subclass of Selection should implement this function.
     * This function performs either a Random Selection or a Rank Selection genetic procedure.
     *
     * @param population, The population that has to be worked on
     * @return Population object
     */
    abstract Population performSelection(Population population);
}

