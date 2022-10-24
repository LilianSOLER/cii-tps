/* grapher.ui.Main
 * (c) blanch@imag.fr 2021–2023                                            */

package grapher.ui;

import javax.swing.*;
import java.awt.*;

// main that launch a grapher.ui.Grapher

public class Main extends JFrame {
	Main(String title, String[] expressions) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		Interaction interaction = new Interaction();
		Grapher grapher = new Grapher();
		interaction.setGrapher(grapher);

		for (String expression : expressions) {
			grapher.add(expression);
		}

		add(grapher);

		grapher.addMouseListener(interaction);
		grapher.addMouseMotionListener(interaction);
		grapher.addMouseWheelListener(interaction);


		JSplitPane splitPane = new JSplitPane();
		splitPane.setRightComponent(grapher);

		JPanel sideBar = new JPanel();
		sideBar.setLayout(new BorderLayout());


		JList expressionsList = new JList();
		expressionsList.setModel(grapher.functions);
		expressionsList.addListSelectionListener(interaction);
		splitPane.setLeftComponent(expressionsList);


		JToolBar toolBar = new JToolBar();
		JButton addButton = new JButton("Add");
		addButton.addActionListener(e -> {
			String expression = JOptionPane.showInputDialog("Expression");
			if (expression != null) {
				grapher.add(expression);
			}
		});
		JButton removeButton = new JButton("Remove");
		removeButton.addActionListener(e -> {
			if (expressionsList.getSelectedIndex() != -1) {
				grapher.remove(expressionsList.getSelectedIndex());
			}
		});
		JButton clearButton = new JButton("Clear");
		clearButton.addActionListener(e -> grapher.clear());
		toolBar.add(addButton);
		toolBar.add(removeButton);
		toolBar.add(clearButton);

		sideBar.add(expressionsList, BorderLayout.CENTER);
		sideBar.add(toolBar, BorderLayout.SOUTH);

		splitPane.setLeftComponent(sideBar);

		add(splitPane);

		pack();

	}

	public static void main(String[] argv) {
		final String[] expressions = argv;
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Main("grapher", expressions).setVisible(true);
			}
		});
	}
}
