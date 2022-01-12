package mu.javaproject.ga.population;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Individual {
	private int fitness = 0;
	private List<Integer> genes = new ArrayList<>();
	public static final int geneLength = 12;
	/**
	 * below list variable is final as the target output will be same throughout the
	 * code, we are comparing the Individual fitness by comparing it with
	 * unmodifiable List elements
	 */

	public static final List<Integer> FINAL_LIST = Collections.unmodifiableList(
			new ArrayList<Integer>(Arrays.asList(1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0)));

	public Individual() {
		Random randomNum = new Random();
		// for each of the individual setting genes randomly
		for (int i = 0; i < geneLength; i++) {
			getGenes().add(Math.abs(randomNum.nextInt() % 2));
		}
		setFitness(0);
	}

	// here Calculated Individual fitness
	public void calculateIndividualFitness() {

		int fitnessCount = 0;
		for (int i = 0; i < geneLength; i++) {
			if (getGenes().get(i) == FINAL_LIST.get(i)) {
				fitnessCount++;
			}
		}
		setFitness(fitnessCount);
	}

	/** All the getters and setters request **/

	/**
	 * getter for the fitness of each Individual
	 * 
	 * @return fitness
	 */

	public int getFitness() {
		return fitness;
	}

	/**
	 * setter for the fitness of each Individual
	 * 
	 * @param fitness
	 */

	public void setFitness(int fitness) {
		this.fitness = fitness;
	}

	/**
	 * getter for total length of the genes(Chromosomes)
	 * 
	 * @return gene length
	 */

	public List<Integer> getGenes() {
		return genes;
	}

	/**
	 * setter for genes(Chromosomes)
	 * 
	 * @param genes
	 */

	public void setGenes(List<Integer> genes) {
		this.genes = genes;
	}

}
