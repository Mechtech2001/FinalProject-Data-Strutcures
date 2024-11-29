package models;

public class Exercise {
	// variables
	private String name;
	private int weight;
	private int reps;

	// default constructor
	public Exercise() {

	}

	// non-defualt constructor
	public Exercise(String name, int weight, int reps) {
		this.name = name;
		this.weight = weight;
		this.reps = reps;
	}

	// getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getReps() {
		return reps;
	}

	public void setReps(int reps) {
		this.reps = reps;

	}

	// methods
	@Override
	public String toString() {
		return "Exercise [name=" + name + ", weight=" + weight + ", reps=" + reps + "]";
	}

}
