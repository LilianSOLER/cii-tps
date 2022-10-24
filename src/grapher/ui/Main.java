/* grapher.ui.Main
 * (c) blanch@imag.fr 2021–2023                                            */

package grapher.ui;

import javax.swing.*;

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
		JList expressionsList = new JList();
		expressionsList.setModel(grapher.functions);
		expressionsList.addListSelectionListener(interaction);
		splitPane.setLeftComponent(expressionsList);


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
