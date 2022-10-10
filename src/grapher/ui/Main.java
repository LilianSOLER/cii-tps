/* grapher.ui.Main
 * (c) blanch@imag.fr 2021–2023                                            */

package grapher.ui;

import javax.swing.*;

// main that launch a grapher.ui.Grapher

public class Main extends JFrame {
	Main(String title, String[] expressions, Interaction interaction) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		Grapher grapher = new Grapher();
		interaction.setGrapher(grapher);

		for (String expression : expressions) {
			grapher.add(expression);
		}

		add(grapher);

		addMouseListener(interaction);
		addMouseMotionListener(interaction);
		addMouseWheelListener(interaction);

		JSplitPane splitPane = new JSplitPane();
		splitPane.setRightComponent(grapher);
		splitPane.setLeftComponent(new JList<String>(expressions));
		add(splitPane);


		pack();
	}

	public static void main(String[] argv) {
		final String[] expressions = argv;
		Interaction interaction = new Interaction();
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Main("grapher", expressions, interaction).setVisible(true);
			}
		});
	}
}
