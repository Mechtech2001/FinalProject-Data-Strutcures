package models;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ExceriseData {
	// variables
	private ArrayList<Exercise> exerciseList;
	private Queue<Exercise> exerciseQueue;

	// constructor
	public ExceriseData() {
		exerciseList = new ArrayList<>();
		exerciseQueue = new LinkedList<>();
	}

	// adds exercise to list
	public void addExercise(Exercise exercise) {
		exerciseList.add(exercise);
	}

	// adds exercise to queue
	public void addToQueue(Exercise exercise) {
		exerciseQueue.add(exercise);
	}

	// prints all the exercises in the list.
	public void displayExercises() {
		for (Exercise exercise : exerciseList) {
			System.out.println(exercise);
		}
	}

}
