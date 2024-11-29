package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import models.ExerciseViewModel;
import models.MockTextArea;

public class ExercisePlanTest {

	private ExerciseViewModel viewModel;
	private MockTextArea mockDisplayArea;
	


	// creates a mock display area before each test.
	@BeforeEach
	public void setUp() {
		mockDisplayArea = new MockTextArea();
		viewModel = new ExerciseViewModel(mockDisplayArea);
	}

	@Test
	public void testAddExerciseValid() {
		viewModel.addExercise("Push-Up", "15", "7");

		// Check that the exercise was added correctly
		String expected = "Added: Exercise [name=Push-Up, weight=15, reps=7]";
		assertTrue(mockDisplayArea.getContent().contains(expected), "Expected text not found in display area");
	}

	@Test
	public void testAddExerciseInvalidInput() {
		viewModel.addExercise("Push-Up", "-5", "7"); // Invalid weight.

		// Check that an error message was displayed
		String expected = "The weight of the exercise must be greater than 0.";
		assertTrue(mockDisplayArea.getContent().contains(expected), "Expected error message not found in display area");
	}

	@Test
	public void testSortExercisesByWeight() {
		viewModel.addExercise("Push-Up", "10", "7");
		viewModel.addExercise("Squats", "15", "9");
		viewModel.sortExerciseByWeight();
		;

		// Check that the exercises were sorted and displayed
		String sortedOutput = "Exercises sorted by weight:\n" + "Exercise [name=Push-Up, weight=10, reps=7]\n"
				+ "Exercise [name=Squats, weight=15, reps=9]";
		assertTrue(mockDisplayArea.getContent().contains(sortedOutput), "Sorted output not found in display area");
	}

	@Test
	public void testCalculatePoundForPoundStrength() {
		viewModel.calculatePoundForPound("200", "150");

		// Check that the pound-for-pound strength was calculated correctly
		String expected = "Pound-for-Pound Strength: 1.33 lbs/lb body weight\n";
		assertTrue(mockDisplayArea.getContent().contains(expected),
				"Expected pound-for-pound strength not found in display area");
	}

	@Test
	public void testCalculatePoundForPoundInvalidInput() {
		viewModel.calculatePoundForPound("200", "0"); // Invalid body weight

		// Check that an error message was displayed
		String expected = "Body weight must be greater than 0.\n";
		assertTrue(mockDisplayArea.getContent().contains(expected), "Expected error message not found in display area");
	}
}
