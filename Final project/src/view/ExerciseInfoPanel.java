package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import models.ExerciseViewModel;

public class ExerciseInfoPanel extends JPanel {
	// adds a title to the project
	private JLabel title = new JLabel("~Fitness Manager~     ");

	// makes label and input field for the name of the exercise
	private JLabel exerciseNameText = new JLabel("Exercise Name:");
	private JTextField exerciseNameField = new JTextField(5);

	// makes label and input field for weight
	private JLabel weightText = new JLabel("Weight for exercise (lbs):");
	private JTextField weightField = new JTextField(5);

	// makes label and input field for number of reps
	private JLabel repsText = new JLabel("Number of reps:");
	private JTextField repsField = new JTextField(5);

	// makes label and input field for body weight
	private JLabel bwText = new JLabel("Body weight (lbs)");
	private JTextField bwField = new JTextField(5);

	// adds exercise to the list
	private JButton listButton = new JButton("Add exercise");

	// makes sort by weight button
	private JButton sortButton = new JButton("Sort by weight");

	// makes calculate button for pound for pound strength.
	private JButton calcButton = new JButton("Calculate Pound for pound Strength");

	// makes a clear button
	private JButton clearButton = new JButton("Clear");

	// displays exercise info
	private JTextArea displayArea = new JTextArea(10, 25);
	private JScrollPane scrollPane = new JScrollPane(displayArea);

	// view model to handle logic
	private ExerciseViewModel viewModel;

	public ExerciseInfoPanel() {
		super();

		viewModel = new ExerciseViewModel(displayArea);
		// Set up GroupLayout
		GroupLayout layout = new GroupLayout(this);
		setLayout(layout);

		// Add some padding around the panel
		setBorder(new EmptyBorder(10, 10, 10, 10));

		// Make gaps between components
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);

		// Horizontal Group
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER) 
																							
				.addComponent(title)
				.addGroup(
						layout.createSequentialGroup()
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(exerciseNameText).addComponent(weightText).addComponent(repsText)
										.addComponent(bwText))
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(exerciseNameField).addComponent(weightField)
										.addComponent(repsField).addComponent(bwField)))
				.addComponent(scrollPane).addGroup(layout.createSequentialGroup()

						.addComponent(listButton).addComponent(sortButton).addComponent(clearButton))
				.addComponent(calcButton));

		// Vertical Group
		layout.setVerticalGroup(layout.createSequentialGroup().addComponent(title)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(exerciseNameText)
						.addComponent(exerciseNameField))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(weightText)
						.addComponent(weightField))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(repsText)
						.addComponent(repsField))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(bwText)
						.addComponent(bwField))
				.addComponent(scrollPane)

				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(listButton)
						.addComponent(sortButton).addComponent(clearButton))
				.addComponent(calcButton)

		);

		// Set display area to read-only
		displayArea.setEditable(false);


		// add button listeners
		listButton.addActionListener(new ListButtonListener());
		sortButton.addActionListener(new SortButtonListener());
		calcButton.addActionListener(new CalcButtonListener());
		clearButton.addActionListener(new ClearButtonListener());
	}

	// adds the function to the add to list button
	class ListButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// sends exercise info the the view model
			viewModel.addExercise(exerciseNameField.getText(), weightField.getText(), repsField.getText());

			// clears input fields
			clearInputFields();
		}

	}

	// adds function to the sort button
	class SortButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			viewModel.sortExerciseByWeight();

		}
	}

	// adds function to the calc button
	class CalcButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			viewModel.calculatePoundForPound(weightField.getText(), bwField.getText());

		}

	}

	// adds function to the clear button
	class ClearButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			clearAllFields();

		}

	}

	// method to clear all the exercise info to add new exercise
	private void clearInputFields() {
		exerciseNameField.setText("");
		weightField.setText("");
		repsField.setText("");
	}

	// clears every field
	private void clearAllFields() {
		clearInputFields();
		bwField.setText("");
		displayArea.setText("");
	}
}
