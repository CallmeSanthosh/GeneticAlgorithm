package mu.javaproject.ga.runner;

import java.io.*;

import java.util.List;

import mu.javaproject.ga.factory.GeneticConfigurationStrategy;
import mu.javaproject.ga.population.Individual;
import mu.javaproject.ga.population.Population;

/**
 * This is the runner class for the project. It will first create a SINGLE
 * instance(Singleton) of Population class to make sure every class is working
 * on the same population instance. I have created the Factory to be
 * GeneticFactory and this is the Abstract Factory Pattern where all the Genetic
 * Operations are abstracted. At First, We are Creating a initial population and
 * calculating fitness function f(x) to find the fit-test person. If maximum
 * fitness is not obtained, genetic operations will start with
 * SELECTION,CROSSOVER and MUTATION process and the loop goes on until we find
 * the maximum fitness in any particular generation
 * 
 */

public class GeneticAlgorithmRunner {

	private static Population population;
	private static int generationCount = 1;

	/**
	 * Starting point of Genetic Algorithm Operations
	 *
	 * @param args this is used to pass the variable in runtime. But here we are not
	 *             using this
	 */

	public static void main(String[] args) {

		population = Population.getInstance();

		GeneticConfigurationStrategy configurationFactory = new GeneticConfigurationStrategy();

		// Initialize the population
		population.initialPopulation(5, true);

		// creating a file to write output

		try {
			File myObj = new File("output.txt");
			if (myObj.createNewFile()) {
				System.out.println("File created: " + myObj.getName());
			} else {
				// System.out.println("File already exists.");
			}
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		try {
			FileWriter writer = new FileWriter("output.txt");
			writer.write("*************************This is the output of the Genetic algorithm********************\n");

			// calculate the fitness of the initial population
			population.fitnessFunction();
			writer.write("\nGeneration: #" + generationCount + " Fittest: " + population.getFittest());
			System.out.println("Generation: #" + generationCount + " Fittest: " + population.getFittest());
			for (int i = 0; i < population.getPopulationSize(); i++) {

				List<Integer> genes = (List<Integer>) population.getIndividuals().get(i).getGenes();
				writer.write("\nIndividual # " + i + " " + genes + " | Fitness : "
						+ population.getIndividuals().get(i).getFitness());
				System.out.println("Individual # " + (i) + " " + genes + " | Fitness : "
						+ population.getIndividuals().get(i).getFitness());

			}

			// Loop until maximum fitness is found
			while (population.getFittest() < population.getMaximumFitness()) {

				++generationCount;

				/**
				 * Strategy Design pattern to allow different GA Selection,Crossover or Mutation
				 * Implementations(or strategies) at run-time
				 **/
				// GAfactoryConfig.executeGeneticOperations(SelectionType.RANK, PointType.ONE);

				configurationFactory.executeGeneticOperations(population);

				// calculate new fitness of the Individuals
				writer.write("\n---------------------------------------------------------------------------------");
				System.out.println("-------------------------------------------------------------------------");
				population.fitnessFunction();
				writer.write("\nGeneration: # " + generationCount + " Fittest Individual fitness: "
						+ population.getFittest());
				System.out.println(
						"Generation: # " + generationCount + " Fittest Individual fitness: " + population.getFittest());
				writer.write("\nTARGET INDIVIDUAL : [1 0 1 0 1 0 1 0 1 0 1 0]");
				System.out.println("TARGET INDIVIDUAL : [1 0 1 0 1 0 1 0 1 0 1 0]");

				// prints the population

				for (int i = 0; i < population.getPopulationSize(); i++) {

					List<Integer> genes = (List<Integer>) population.getIndividuals().get(i).getGenes();
					writer.write("\nIndividual # " + (i + 1) + " " + genes + " | Fitness : "
							+ population.getIndividuals().get(i).getFitness());
					System.out.println("Individual # " + (i + 1) + " " + genes + " | Fitness : "
							+ population.getIndividuals().get(i).getFitness());

				}
			}

			// prints the final solution
			writer.write("\n***************************************************************************");
			System.out.println("****************************************************************************");
			writer.write("\nSolution found in generation " + generationCount);
			System.out.println("Solution found in generation " + generationCount);
			writer.write("\nFitness: " + population.getMostFittest().getFitness());
			System.out.println("Fitness: " + population.getMostFittest().getFitness());
			writer.write("\nGenes : ");
			System.out.print("Genes: ");
			writer.write("[");
			for (int i = 0; i < Individual.geneLength; i++) {
				writer.write(population.getMostFittest().getGenes().get(i) + " ");
				System.out.print(population.getMostFittest().getGenes().get(i));
			}
			writer.write("]");
			writer.write("\n\n*****************************************************************************");
			System.out.println("\n*****************************************************************************");

			System.out.println("");

			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
