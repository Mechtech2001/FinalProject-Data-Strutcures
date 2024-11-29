package models;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextArea;

import view.ExerciseInfoPanel;

public class ExerciseViewModel {

	// sets up default text area
	private JTextArea displayArea;
	// sets up list
	private List<Exercise> exerciseList;


	// constructor to pass display area from panel
	public ExerciseViewModel(JTextArea displayArea) {
		this.displayArea = displayArea;
		this.exerciseList = new ArrayList<>();
	}

	// method to add exercise to a list
	public void addExercise(String name, String weight, String reps) {
		try {
			
			// makes sure the name of the exercise isn't empty
			if (name.isEmpty()) {
				displayArea.append("Please enter a name for the exercise.\n");
				return;
			}

			// makes sure the weight field was entered
			if (weight.isEmpty()) {
				displayArea.append("Please enter the weight for the exercise.\n");
				return;
			}

			// makes sure the reps field was entered.
			if (reps.isEmpty()) {
				displayArea.append("Please enter the amount of reps for the exercise.\n");
				return;
			}
			
			// gets the weight and reps from the panel and converts it to an integer
			int amountOfWeight = Integer.parseInt(weight);
			int numOfReps = Integer.parseInt(reps);

			// makes sure the weight for the exercise is greater than 0
			if (amountOfWeight <= 0) {
				displayArea.append("The weight of the exercise must be greater than 0.\n");
				return;
			}

			// makes are the number of reps is greater than 0
			if (numOfReps <= 0) {
				displayArea.append("The number of reps must be greater than 0.\n");
				return;
			}

			// creates new exercise to add to the list
			Exercise exercise = new Exercise(name, amountOfWeight, numOfReps);
			exerciseList.add(exercise);

			// displays exercise
			displayArea.append("Added: " + exercise + "\n");

		} catch (NumberFormatException e) {
			displayArea.append("Invaild numeric input. Please try again.\n");
		}
	}

	// method to sort list
	public void sortExerciseByWeight() {
		if (exerciseList.isEmpty()) {
			displayArea.append("There is no exercises to sort.\n");
			return;
		}

		// sorts list
		SortExercises sorter = new SortExercises();
		exerciseList = sorter.mergeSort(exerciseList);

		// displays sorted list
		displayArea.append("Exercises sorted by weight:\n");
		for (Exercise exercise : exerciseList) {
			displayArea.append(exercise + "\n");
		}
	}

	// method to calculate pound for pound strength
	public void calculatePoundForPound(String weight, String bodyWeight) {
		try {
			// changes the strings from the panel to doubles
			double exerciseWeight = Double.parseDouble(weight);
			double userBodyWeight = Double.parseDouble(bodyWeight);

			// makes sure the body weight is more than 0
			if (userBodyWeight <= 0) {
				displayArea.append("Body weight must be greater than 0.\n");
				return;
			}

			// makes sure the weight for the exercise is greater than 0
			if (exerciseWeight <= 0) {
				displayArea.append("The weight of the exercise must be greater than 0.\n");
				return;
			}

			// calculates pound for pound strength
			double pfpStrength = exerciseWeight / userBodyWeight;
			displayArea.append(String.format("Pound-for-Pound Strength: %.2f lbs/lb body weight\n", pfpStrength));
		} catch (NumberFormatException e) {
			displayArea.append(" Please enter a valid number for weight lifted and body weight. \n");
		}

	}
}
