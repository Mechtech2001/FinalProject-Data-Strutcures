package driver;

import javax.swing.JFrame;
import javax.swing.JPanel;

import view.ExerciseInfoPanel;


public class ExercisePlan {

	public static void main(String[] args) {
		// makes the application window and adds content to it
		JFrame frame = new JFrame();
		JPanel panel = new ExerciseInfoPanel();

		// adds panel to the frame.
		frame.add(panel);

		// adds title to
		frame.setTitle("Fitness Manager");
		// sets size on the window
		frame.setSize(500, 500);
		// makes the exit button of the window functional
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// makes window visible
		frame.setVisible(true);

	}

}
