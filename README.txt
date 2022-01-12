CS613 Advanced OOPS Module:

WELCOME TO GENETIC ALGORITHM PROJECT OVERVIEW:


/** Team Members: **/

1)ARTI PATEL,21250524
2)ASHI CHAUHAN,21250591
3)PRIYANKA SHIVAJI DUDHE,21250504
4)SANTHOSH KUMAR JAYAVEL,20250813

All of the the above mentioned members have contributed equally( 25 % EACH )  i.e 100% in the development of Genetic Algorithm project.

--> GeneticAlgorithmRunner.java inside mu.javaproject.ga.runner package is the start point for the compilation of the code.


The project contains six packages in Total.

* mu.javaproject.ga.runner - runner package to compile the Algorithm with Strategy design pattern to allow different GA Selection,Crossover or Mutation Implementations(or strategies) at run-time.
* mu.javaproject.ga.factory - factory design pattern(Abstract factory is implemented) to handle the instantiation (creation) of the different Selection, Reproduction (/Crossover) or Mutation objects. 
* mu.javaproject.ga.selection/mu.javaproject.ga.crossover/mu.javaproject.ga.mutation - All the Operations of the Genetic Algorithm are invoked
* mu.javaproject.ga.population - SINGLETON class Population with the concept of lazy-initialisation and thread-safe implementation.

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

OUTPUT OF THE PROJECT :

--Output of the project is mention in the output.txt file.
-- As a project output fit-test genes is :
	/** Solution found in generation 28
	*   Fitness: 12
	*/  Genes : [1 0 1 0 1 0 1 0 1 0 1 0 ]

--> The code initially attempts to see if it can achieve a maximum fitness in the first generation, and if it can't, it repeats the process. In each generation, perform SELECTION, CROSSOVER, and MUTATION operations until you discover the greatest feasible fitness f(x) in that generation, which is the solution.

--The code initially check whether it is possible to find a maximum fitness is very first generation, and if not, the genetic algorithm will run over below operations:
1) SELECTION 2) Crossover 3) Mutation. It will run until it found the output string with maximum fitness.
----------------------------------------------------------------------------------------------------------------------------------


----------------------------------------------------------------------------------------------------------------------------------

1.singleton pattern:


--> In Population class, the singleton pattern is used. we have defined Population class Singleton as same Population will evolve or mutate throughout the loop. 



From the below code,

        //Because every class is working on the same population, single instance concurrency is maintained throughout the program.
	//Making the constructor private so that only one instance of the Population can be loaded.
	private Population() {

	}

	//Only when the Genetic Algorithm runs is an instance created.

	/**thread safe lazy initialization using getInstance**/

	public static Population getInstance() {
		if (_instance == null) {
		// synchronized block to remove overhead
		synchronized (Population.class) {
		if (_instance == null) {
		_instance = new Population();
		}
		}
	}
		return _instance;
		}
	

--> We used the getInstance static method of the population class to provide thread safe lazy initialization since we only want the Population instance to be generated when the Genetic Algorithm Runner class starts running (i.e., only when the application starts running).
--if the population runs again then what problems we could have face.


2.strategy pattern:

--> in 'GeneticConfigurationStrategy' file we have used the Strategy pattern. A class's behavior or algorithm can be altered during runtime in Java (i.e., the strategy object alters the context object's execution algorithm).

--Strategy Design pattern to allow different GA Selection,Crossover or Mutation
* Implementations(or strategies) at run-time
*
* It chooses which factory from "Random Factory" or "Regular factory" to execute at run time.

*The Genetic strategy differs depending on the kind of randomly selected operation type and point passed below.

For Example:
public GeneticFactory executeGeneticOperations(Population population) {
if (randomOperationType() == OperationType.RANDOM) {
return new RandomTypeFactory(population);
} else {
return new RegularTypeFactory(population);
}
}


3.factory pattern:


--> We have implemented Abstract factory design pattern in GeneticFactory.java and and this is the place where the user communicates to and asks for a specific version of a Genetic algorithm.

--> GeneticFactory.java provides an interface for calling all genetic processes, but it leaves it up to the concrete factory classes in RandomTypeFactory.java and RegularTypeFactory.java for creation.

--For Example:
--RandomTypeFactory.java returns objects like RandomSelection, OnePointCrossover, and RandomMutation.

--RegularTypeFactory,The RankSelection, TwoPointCrossover, and SubstituteMutation objects are provided by Java.


-->  The different Selection, Reproduction (/Crossover), or Mutation Operator objects are instantiated (created) according to the kind of particular factory (RandomTypeFactory or RegularTypeFactory).


-- For the better understanding about the abstract factory pattern diagram is attached into the  (AbstractFactoryPattern.png) file.


4. Data Abstraction - It is used in the packages Crossover, Selection, and Mutation.
We have used Interfaces and abstract class to achieve Data abstraction throughout the code.For Example: Class Mutation is 		    an interface with method mutate() and there are two subclasses class RandomMutation and SubstituteMutation classes are                       implementing the mutate() method.public interface Mutation {
/**
* All subclasses will define this method.
*
* @param population is the 'Population Object'.
* @return Population
* public abstract Population mutate(Population population);}
*/

6.Data Encapsulation__We have used private data member and public getter and setter methods to get and set the value of these variables throughout the code to achieve the Data Encapsulation.__Separation of behavior and implementation particularly with respect to the Strategy & Factory design patterns__
Hierarchy of classes is maintained. For repeating code, we have combined it in the Base class.

__Data Structure used__
We have used List as Individual which contains random 0's and 1's. Also Population class contains List of Individuals.
/*
* private List<Integer> genes = new ArrayList<>(); //List of genes in Individual class
* private List<Individual> individuals = new ArrayList<>(); // list of Individual in Population class
* Also we have used Comparator interface to sort the population using fitness.
*
*/


5. Data hiding - Individual class it's gene and fitness is private and can be accessed through getter and setter method.
GeneticAlgorithmRunner class has private Population  object.
In Population class data like fittestIndividual, secondFittestIndividual, size and all individual details are private and only accessible through getter setter and outside Population class nobody should be able to change these data directly.
---------------------------------------------------------------------------------------------------------------------------------------
